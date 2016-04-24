package pl.pollub.training.model;

import org.junit.Assert;
import org.junit.Test;
import pl.pollub.training.model.inheritence.ClassA;
import pl.pollub.training.model.inheritence.ClassC;
import pl.pollub.training.model.pattern.PersonService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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

    @Test
    public void sorting() {
        List<Person> intList = new ArrayList<Person>();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            int randomInt = 18 + rand.nextInt(82);
            Person person = new Person(i, "Name" + randomInt, randomInt);
            intList.add(person);
        }
        Collections.sort(intList, new Person.SortByAgeAsc());
        System.out.println(intList);
    }

    @Test
    public void objectMethods() throws CloneNotSupportedException {
        Person instance = new Person(1, "Roman", 17);
        Person copy = (Person) instance.clone();
        System.out.println(instance);
        System.out.println(copy);
    }

    @Test
    public void staticTest() {
        StaticClass staticClass = new StaticClass();
    }

    @Test
    public void testInherience() {
        ClassA object = new ClassA();
    }

    @Test
    public void testPolymorfism() {
        ClassC instance = new ClassA();
        instance.doSomething();
    }

    @Test
    public void testOutOfMemory() {
        List<Person> storage = new ArrayList<Person>();
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            Person person = new Person(999, "Name", 999);
            storage.add(person);
        }
        System.out.println("Finish");
    }

    private PersonService service = PersonService.getInstance();

    @Test
    public void testSigletone() {
        Person person = new Person(1, "Roman", 17);
        service.addPerson(person);
        assertEquals(person, service.getPerson(1));
        Assert.assertNull(service.getPerson(2));
    }

    @Test
    public void testBuilder() {
        Person person = new Person.Builder()
                .setName("ROma")
                .setId(55)
                .build();

    }
}
