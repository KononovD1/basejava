package com.urise.webapp.storage;

//import com.urise.webapp.storage.serializers.ObjectSerializer;

import urise.webapp.storage.FileStorage;
import urise.webapp.storage.ObjectStreamFileStorage;
import urise.webapp.storage.serializer.ObjectSerializer;

public class FileStorageTest extends AbstractStorageTest {

    public FileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectSerializer()));
    }
}