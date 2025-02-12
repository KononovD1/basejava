package com.urise.webapp.storage;

//import com.urise.webapp.storage.serializers.ObjectSerializer;

import urise.webapp.storage.AbstractPathStorage;
import urise.webapp.storage.ObjectStreamPathStorage;
import urise.webapp.storage.PathStorage;
import urise.webapp.storage.serializer.ObjectSerializer;

public class PathStorageTest extends AbstractStorageTest {

    public PathStorageTest() {
        super(new PathStorage(STORAGE_DIR.toString(), new ObjectSerializer()));
    }
}