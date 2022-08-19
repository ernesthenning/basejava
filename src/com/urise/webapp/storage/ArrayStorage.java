package com.urise.webapp.storage;
import com.urise.webapp.model.Resume;
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];

    public void clear() {
        int i = 0;
        while (storage[i] != null) {
            storage[i] = null;
            i++;
        }
    }

    public void save(Resume r) {
        if (size() < 10000) {
            if (!isPresentUuid(r.getUuid())) {
                int i = 0;
                while (storage[i] != null) {
                    i++;
                }
                storage[i] = r;
            } else {
                System.out.println("Резюме с таким uuid имеется в базе!");
            }
        } else {
            System.out.println("Хранилище заполнено!");
        }
    }

    public void update(Resume resume) {
        if (isPresentUuid(resume.getUuid())) {
            storage[getIndex(resume.getUuid())] = resume;
        } else {
            System.out.println("Резюме не найдено");
        }

    }

    public Resume get(String uuid) {
        if (isPresentUuid(uuid)) {
            int index = getIndex(uuid);
            return storage[index];
        } else {
            System.out.println("Неверный uuid");
            return null;
        }
    }

    public void delete(String uuid) {
        if (isPresentUuid(uuid)) {
            int deleteIndex = getIndex(uuid);
            for (int i = deleteIndex; i < storage.length - 1; i++) {
                storage[i] = storage[i + 1];
            }
        } else {
            System.out.println("Неверный uuid");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        for (int i = 0; i < resumes.length; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    public int size() {
        int counter = 0;
        while (storage[counter] != null) {
            counter++;
        }
        return counter;
    }
    public int getIndex (String uuid) {
        int counter = 0;
        for (int i = 0; i < size(); i++) {
            if (storage[i].getUuid().equals(uuid)) {
                counter = i;
            }
        }
        return counter;
    }

    public boolean isPresentUuid (String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return true;
            }
        }
        return false;
    }
}
