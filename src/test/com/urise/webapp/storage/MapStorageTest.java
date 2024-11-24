package com.urise.webapp.storage;

import org.junit.Test;
import urise.webapp.storage.MapStorage;

public class MapStorageTest extends AbstractArrayStorageTest {

    public MapStorageTest() {
        super(new MapStorage());
    }

    @Test
    public void saveOverflow() throws Exception {
//    do not need
    }
}