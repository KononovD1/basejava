package urise.webapp.storage;

import urise.webapp.exception.StorageException;
import urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
//public abstract class AbstractArrayStorage implements Storage {
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
    public final Resume[] getAll() {
        return Arrays.copyOf(storage, size);
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
        if ((Integer) index >= 0) {
            return true;
        }
        return false;
    }
}
