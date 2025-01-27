package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage<String> {

    private final Map<String, Resume> hashMap = new HashMap<>();

    @Override
    protected String findKey(String uuid) {
        if (hashMap.containsKey(uuid)) {
            return uuid;
        }
        return null;
    }

    @Override
    protected void doSave(Resume resume, String key) {
        hashMap.put(resume.getUuid(), resume);
    }

    @Override
    protected boolean isExist(String key) {
        return key != null;
    }

    @Override
    protected void doUpdate(Resume resume, String key) {

        hashMap.replace(key, resume);
    }

    @Override
    protected void doDelete(String key) {
        hashMap.remove(key);
    }

    @Override
    protected Resume doGet(String key) {
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
