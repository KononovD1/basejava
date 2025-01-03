package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> hashMap = new HashMap<>();

    @Override
    protected String findKey(String uuid) {
        if (hashMap.containsKey(uuid)) {
            return uuid;
        }
        return null;
    }

    @Override
    protected void doSave(Resume resume, Object key) {
        hashMap.put(resume.getUuid(), resume);
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

        hashMap.replace((String) key, resume);
    }

    @Override
    protected void doDelete(Object key) {
        hashMap.remove(key);
    }

    @Override
    protected Resume doGet(Object key) {
        return hashMap.get(key);
    }

    @Override
    public void clear() {
        hashMap.clear();
    }

    @Override
    public List<Resume> getList() {
        return new ArrayList<>(hashMap.values());
    }

    @Override
    public int size() {
        return hashMap.size();
    }
}
