package com.urise.webapp.model;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }


//    public String toString() {
//        return ("(" + name + ", " + id + ", " + author + ", " + publisher + ")");
//    }
    @Override
    public int compareTo(Resume object) {
        return this.uuid.compareTo(object.uuid);
//        return uuid.compareTo(object.uuid);
    }
}
