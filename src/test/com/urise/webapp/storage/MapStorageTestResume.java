package com.urise.webapp.storage;

import org.junit.Test;
import urise.webapp.storage.MapStorageResume;

public class MapStorageTestResume extends AbstractStorageTest {

    public MapStorageTestResume() {
        super(new MapStorageResume());
    }

    @Test
    public void saveOverflow() throws Exception {
//    do not need
    }
}