/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;                  // number of resumes

    void save(Resume r) {
        storage[count] = r;
        count++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (uuid.equals(storage[i].toString())) {
                if (size() - 2 >= 0) System.arraycopy(storage, 2, storage, 1, size() - 2);
                storage[size() - 1] = null;
                count --;
                break;
            }
        }
    }

    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
        count = 0;
    }

    Resume[] getAll() {
        Resume[] netResume = new Resume[count];
        System.arraycopy(storage, 0, netResume, 0, size());
        return netResume;
    }

    int size() {
        return count;
    }
}


// То что комментарий ниже не нужен в гите - осознаю. Мне такое решение больше нравится, но тыкнул на решение которое предложила идея.

//    void delete(String uuid) {
//        for (int i = 0; i < storage.length; i++) {
//            if (uuid.equals(storage[i].toString())) {
//                for (int q = 1; q < size() - 1; q++) {
//                    storage[q] = storage[q + 1];
//                }
//                storage[size() - 1] = null;
//                count --;
//                break;
//            }
//        }
//    }
