package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void refillElement(int index) {
        int charShift = size - index - 1;
        if (charShift > 0) {
            System.arraycopy(storage, index + 1, storage, index, charShift);
        }
    }

    @Override
    protected void addElement(Resume resume, int index) {
        int insertIndex = -index - 1;
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size - insertIndex);
        storage[insertIndex] = resume;
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
