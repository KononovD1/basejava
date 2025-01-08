package urise.webapp.storage;

import urise.webapp.exception.StorageException;
import urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    public static final int STORAGE_LIMIT = 1000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public final int size() {
        return size;
    }

    public final void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public final void doDelete(Object index) {
        refillElement((Integer) index);
        storage[size] = null;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    @Override
    public final List<Resume> getList() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    public Resume doGet(Object index) {
        return storage[(Integer) index];
    }

    @Override
    protected void doSave(Resume resume, Object key) {
        if (size < storage.length) {
            addElement(resume, (Integer) key);
            size++;
            return;
        }
        throw new StorageException("Storage overflow", resume.getUuid());
    }

    @Override
    protected void doUpdate(Resume resume, Object index) {
        storage[(Integer) index] = resume;
    }

    protected abstract void addElement(Resume resume, int index);

    protected abstract void refillElement(int index);

    protected abstract Integer findKey(String uuid);

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }
}
