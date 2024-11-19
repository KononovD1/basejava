package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    private final ArrayList<Resume> list = new ArrayList<>();

    @Override
    protected Integer findKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void doSave(Resume resume, Object key) {
        list.add(resume);
    }

    @Override
    protected boolean isExist(Object key) {
        if (key == null) {
            return false;
        }
        return true;
    }

    @Override
    protected void doUpdate(Resume resume, Object key) {
        list.set((Integer) key, resume);
    }

    @Override
    protected void doDelete(Object key) {
        list.remove(((Integer) key).intValue());
    }

    @Override
    protected Resume doGet(Object key) {
        return list.get((Integer) key);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

    @Override
    public int size() {
        return list.size();
    }
}
