package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void save(Resume r) {
        if (find(r.getUuid()) != null) {
            System.out.printf("Resume %s already exist\n", r.getUuid());
            return;
        }
        if (size < storage.length) {
            storage[size++] = r;
            return;
        }
        System.out.printf("Storage overflow, resume %s not saved\n", r.getUuid());
    }

    public Resume find(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void update(Resume r, Resume rOld) {
        if (find(rOld.getUuid()) == null) {
            System.out.printf("Resume %s for update not found\n", rOld.getUuid());
            return;
        }
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(rOld.getUuid())) {
                storage[i] = r;
            }
        }
    }

    public Resume get(String uuid) {
        Resume result = find(uuid);
        if (result == null) {
            System.out.printf("Resume %s not found\n", uuid);
        }
        return result;
    }

    public void delete(String uuid) {
        if (find(uuid) == null) {
            System.out.printf("Resume %s for delete not found\n", uuid);
            return;
        }

        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[--size];
                storage[size] = null;
                return;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resumes = Arrays.copyOf(storage, size);
        return resumes;
    }

    public int size() {
        return size;
    }
}
