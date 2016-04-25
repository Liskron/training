package pl.pollub.training.model.day2;

import pl.pollub.training.model.day1.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdasSample {

    private List<Person> filter(List<Person> e) {
        List<Person> copyE = new ArrayList<Person>();
        for (int i = 0; i < e.size(); i++) {
            if (e.get(i).getAge() >= 20) {
                copyE.add(e.get(i));
            }
        }
        return copyE;
    }

    public List<Person> filter1(List<Person> persons) {
        return persons.parallelStream().filter(person -> person.getAge() > 20).collect(Collectors.toList());
    }
}
