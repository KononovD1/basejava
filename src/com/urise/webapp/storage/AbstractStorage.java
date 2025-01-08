package urise.webapp.storage;

import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.model.Resume;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    public final void save(Resume resume) {
        Object key = getNotExistedKey(resume.getUuid());
        if (isExist(key)) {
            throw new ExistStorageException(resume.getUuid());
        }
        doSave(resume, key);
    }

    public final void update(Resume resume) {
        Object key = getExistedKey(resume.getUuid());
        doUpdate(resume, key);
    }

    public final void delete(String uuid) {
        Object key = getExistedKey(uuid);
        doDelete(key);
    }

    public final Resume get(String uuid) {
        Object key = getExistedKey(uuid);
        return doGet(key);
    }

    protected abstract Object findKey(String uuid);

    protected abstract void doSave(Resume resume, Object key);

    protected abstract boolean isExist(Object key);

    protected abstract void doUpdate(Resume resume, Object key);

    protected abstract void doDelete(Object key);

    protected abstract List<Resume> getList();

    protected Object getExistedKey(String uuid) {
        Object key = findKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    protected Object getNotExistedKey(String uuid) {
        Object key = findKey(uuid);
        if (isExist(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    protected abstract Resume doGet(Object key);

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = getList();
        Collections.sort(list, new nameComparator().thenComparing(new uuidComparator()));
        return list;
    }

    private static class nameComparator implements Comparator<Resume> {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getFullName().compareTo(o2.getFullName());
        }
    }

    private static class uuidComparator implements Comparator<Resume> {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    }

}
