package urise.webapp.storage;

import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.exception.StorageException;
import urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
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

    public final void save(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        }
        if (size < storage.length) {
            addElement(resume, index);
            size++;
            return;
        }
        new StorageException("Storage overflow", resume.getUuid());
    }

    public final void update(Resume resume, Resume resumeOld) {
        int index = findIndex(resumeOld.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resumeOld.getUuid());
        }
        storage[index] = resume;
    }

    public final void delete(String uuid) {
        int index = findIndex(uuid);
        if (findIndex(uuid) < 0) {
            throw new NotExistStorageException(uuid);
        }
        refillElement(index);
        storage[size] = null;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public final Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public final Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    protected abstract void addElement(Resume resume, int index);

    protected abstract void refillElement(int index);

    protected abstract int findIndex(String uuid);
}
