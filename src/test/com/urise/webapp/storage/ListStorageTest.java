package com.urise.webapp.storage;

import org.junit.Test;
import urise.webapp.storage.ListStorage;

public class ListStorageTest extends AbstractArrayStorageTest {

    public ListStorageTest() {
        super(new ListStorage());
    }

    @Test
    public void saveOverflow() throws Exception {
//    do not need
    }
}