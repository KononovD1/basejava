package urise.webapp.storage;

import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public final void save(Resume resume) {
        Object key = findKey(resume.getUuid());
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

    protected Object getExistedKey(String uuid) {
        Object key = findKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    protected abstract Resume doGet(Object key);
}
