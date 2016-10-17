package ru.urfu;

import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andrey on 16.10.16.
 */
public class MessageStorageTest {
    private MessageStorage storage = new MessageStorage();
    @Test
    public void renderAllMessages() throws Exception {
        storage.addMessage("hello World");
        assertTrue(storage.renderAllMessages().contains("<li>hello World</li>"));
    }
}