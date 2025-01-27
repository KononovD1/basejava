package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {

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
    protected void doSave(Resume resume, Integer key) {
        list.add(resume);
    }

    @Override
    protected boolean isExist(Integer key) {
        return key != null;
    }

    @Override
    protected void doUpdate(Resume resume, Integer key) {
        list.set(key, resume);
    }

    @Override
    protected void doDelete(Integer key) {
        list.remove(key.intValue());
    }

    @Override
    protected Resume doGet(Integer key) {
        return list.get((Integer) key);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public List<Resume> getList() {
        return new ArrayList<>(list);
    }

    @Override
    public int size() {
        return list.size();
    }
}
