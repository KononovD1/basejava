package urise.webapp.storage;

import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.model.Resume;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    public final void save(Resume resume) {
        LOG.info("Save " + resume);
        SK key = getNotExistedKey(resume.getUuid());
        if (isExist(key)) {
            throw new ExistStorageException(resume.getUuid());
        }
        doSave(resume, key);
    }

    public final void update(Resume resume) {
        LOG.info("Update " + resume);
        SK key = getExistedKey(resume.getUuid());
        doUpdate(resume, key);
    }

    public final void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK key = getExistedKey(uuid);
        doDelete(key);
    }

    public final Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK key = getExistedKey(uuid);
        return doGet(key);
    }

    protected abstract SK findKey(String uuid);

    protected abstract void doSave(Resume resume, SK key);

    protected abstract boolean isExist(SK key);

    protected abstract void doUpdate(Resume resume, SK key);

    protected abstract void doDelete(SK key);

    protected abstract List<Resume> getList();

    protected SK getExistedKey(String uuid) {
        SK key = findKey(uuid);
        if (!isExist(key)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    protected SK getNotExistedKey(String uuid) {
        SK key = findKey(uuid);
        if (isExist(key)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    protected abstract Resume doGet(SK key);

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
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
