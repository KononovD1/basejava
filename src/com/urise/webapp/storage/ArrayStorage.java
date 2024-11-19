package urise.webapp.storage;

import urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    protected void refillElement(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected Integer findKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return Integer.valueOf(-1);
    }

    @Override
    protected void addElement(Resume resume, int index) {
        storage[size] = resume;
    }
}
