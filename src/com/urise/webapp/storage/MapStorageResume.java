package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorageResume extends AbstractStorage {

    private final Map<String, Resume> hashMap = new HashMap<>();

    @Override
    protected Resume findKey(String uuid) {
        return hashMap.get(uuid);
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
        hashMap.replace(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Object key) {
        hashMap.remove(((Resume) key).getUuid());
    }

    @Override
    protected Resume doGet(Object key) {
        return (Resume) key;
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
