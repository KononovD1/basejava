package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {

    private final Map<String, Resume> hashMap = new HashMap<>();

    @Override
    protected Resume findKey(String uuid) {
        return hashMap.get(uuid);
    }

    @Override
    protected void doSave(Resume resume, Resume key) {
        hashMap.put(resume.getUuid(), resume);
    }

    @Override
    protected boolean isExist(Resume key) {
        return key != null;
    }

    @Override
    protected void doUpdate(Resume resume, Resume key) {
        hashMap.replace(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Resume key) {
        hashMap.remove(key.getUuid());
    }

    @Override
    protected Resume doGet(Resume key) {
        return key;
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
