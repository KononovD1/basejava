/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < 10000; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            } else {
                break;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < 10000; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < 10000; i++) {
            if (storage[i] == null) {
                return null;
            } else if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < 10000; i++) {
            if (storage[i] == null) {
                return;
            } else if (storage[i].uuid == uuid) {
                for (int j = i; j < 10000; j++) {
                    storage[j] = storage[j + 1];
                    if (storage[j + 1] == null) {
                        return;
                    }
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        for (int i = 0; i < 10000; i++) {
            if (storage[i] == null) {
                Resume[] filled = new Resume[i];
                for (int idFilled = 0; idFilled < i; idFilled++) {
                    filled[idFilled] = storage[idFilled];
                }
                return filled;
            }
        }
        return new Resume[0];
    }

    int size() {
        for (int i = 0; i < 10000; i++) {
            if (storage[i] == null) {
                return i;
            }
        }
        return 10000;
    }
}
