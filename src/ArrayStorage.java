/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int i = 0;
        while (storage[i] != null) {
            storage[i] = null;
            i++;
        }
    }

    void save(Resume r) {
        int i = 0;
        while (storage[i] != null) {
            i++;
        }
        storage[i] = r;
    }

    Resume get(String uuid) {
        int i = 0;
        while (storage[i] != null) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
            i++;
        }
        return storage[i];
    }

    void delete(String uuid) {
        System.out.println(storage[2]);
        int deleteIndex = 0;
        int j = 0;
        while (storage[j] != null) {
            if (storage[j].uuid.equals(uuid)) {
                deleteIndex = j;
            }
            j++;
        }
        for (int i = deleteIndex; i < storage.length - 1; i++) {
            storage[i] = storage[i + 1];
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        for (int i = 0; i < resumes.length; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        int counter = 0;
        while (storage[counter] != null) {
            counter++;
        }
        return counter;
    }
}
