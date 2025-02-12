package urise.webapp.storage;

import urise.webapp.storage.serializer.SerializationStrategy;

import java.io.File;

public class PathStorage extends AbstractPathStorage {
    public PathStorage(String directory, SerializationStrategy ss) {
        super(directory, ss);
    }
}
