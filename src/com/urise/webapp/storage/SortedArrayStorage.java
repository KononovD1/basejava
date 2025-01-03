package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {
    private static final Comparator RESUME_COMPARATOR = (Comparator<Resume>) (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

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
    protected Integer findKey(String uuid) {
        Resume searchKey = new Resume(uuid, "Name");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }
}
