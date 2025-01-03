package com.urise.webapp.storage;

import org.junit.Assert;
import org.junit.Test;
import urise.webapp.exception.StorageException;
import urise.webapp.model.Resume;
import urise.webapp.storage.AbstractArrayStorage;
import urise.webapp.storage.Storage;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail("Early overflow");
        }
        storage.save(new Resume());
    }
}