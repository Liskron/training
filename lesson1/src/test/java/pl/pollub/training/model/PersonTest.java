package pl.pollub.training.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void isAdultTest() {
        Person instance = new Person(1, "Roman", 22);
        boolean result = instance.isAdult();
        assertTrue(result);
    }

    @Test
    public void isNotAdultTest() {
        Person instance = new Person(1, "Roman", 17);
        boolean result = instance.isAdult();
        assertFalse(result);
    }

    @Test
    public void setAndGetTest() {
        Person instance = new Person(1, "Roman", 17);
        instance.setName("Vlad");
        String name = instance.getName();
        assertEquals("Vlad", name);
    }
}
