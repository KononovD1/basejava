package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    final private int STORAGE_LIMIT = 1000;
    final private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public ArrayStorage() {
    }

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void save(Resume r) {
        if (findIndex(r.getUuid()) != -1) {
            System.out.printf("Resume %s already exist\n", r.getUuid());
            return;
        }
        if (size < storage.length) {
            storage[size++] = r;
            return;
        }
        System.out.printf("Storage overflow, resume %s not saved\n", r.getUuid());
    }

    public void update(Resume r, Resume rOld) {
        int i = findIndex(rOld.getUuid());
        if (i == -1) {
            System.out.printf("Resume %s for update not found\n", rOld.getUuid());
            return;
        }
        storage[i] = r;
    }

    public Resume get(String uuid) {
        int i = findIndex(uuid);
        if (i == -1) {
            System.out.printf("Resume %s not found\n", uuid);
            return null;
        }
        return storage[i];
    }

    public void delete(String uuid) {
        int i = findIndex(uuid);
        if (findIndex(uuid) == -1) {
            System.out.printf("Resume %s for delete not found\n", uuid);
            return;
        }
        storage[i] = storage[--size];
        storage[size] = null;
        return;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    protected int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
