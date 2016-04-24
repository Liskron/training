package pl.pollub.training.model.pattern;

import pl.pollub.training.model.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonService {

    private Map<Integer, Person> database = new HashMap<Integer, Person>();

    private static PersonService instance;

    private PersonService() {
    }

    public static PersonService getInstance() {
        if (instance == null) {
            instance = new PersonService();
        }
        return instance;
    }

    public Person getPerson(int id) {
        return database.get(id);
    }

    public void addPerson(Person person) {
        database.put(person.getId(), person);
    }
}
