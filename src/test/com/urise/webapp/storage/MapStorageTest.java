package com.urise.webapp.storage;

import org.junit.Test;
import urise.webapp.storage.MapStorage;

public class MapStorageTest extends AbstractStorageTest {

    public MapStorageTest() {
        super(new MapStorage());
    }

    @Test
    public void saveOverflow() throws Exception {
//    do not need
    }
}