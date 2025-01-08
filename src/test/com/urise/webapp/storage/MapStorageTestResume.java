package com.urise.webapp.storage;

import org.junit.Test;
import urise.webapp.storage.MapResumeStorage;

public class MapStorageTestResume extends AbstractStorageTest {

    public MapStorageTestResume() {
        super(new MapResumeStorage());
    }

    @Test
    public void saveOverflow() throws Exception {
//    do not need
    }
}