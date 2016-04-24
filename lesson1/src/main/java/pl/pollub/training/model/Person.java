package pl.pollub.training.model;

import java.util.Comparator;

/**
 * @author Vlad
 */
public class Person implements Comparable<Person>, Cloneable {

    private int id;
    private String name;
    private int age;

    public Person() {
        System.out.println("Object created");
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public boolean isAdult() {
        return this.age >= 18;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }

    public static class SortByAgeAsc implements Comparator<Person> {
        public int compare(Person o1, Person o2) {
            return o1.getAge() - o2.getAge();
        }
    }

    public static class SortByIdAsc implements Comparator<Person> {
        public int compare(Person o1, Person o2) {
            return o1.getId() - o2.getId();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static class Builder {

        private int id;
        private String name;
        private int age;

        public Person build() {
            return new Person(id, name, age);
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
    }

}
