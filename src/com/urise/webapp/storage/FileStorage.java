package urise.webapp.storage;

import urise.webapp.storage.serializer.SerializationStrategy;

import java.io.File;

public class FileStorage extends AbstractFileStorage{
    public FileStorage(File directory, SerializationStrategy ss) {
        super(directory, ss);
    }
}
