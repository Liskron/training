package pl.pollub.training.model.day1;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author Vlad
 * http://www.tutorialspoint.com/java/java_serialization.htm
 */
public class Person implements Comparable<Person>, Cloneable, Serializable {

    private static final long serialVersionUID = -5420014771518445831L;

    private int id;
    private String name;
    private int age;
    private String address;
    private AgeGroup ageGroup;

    public Person() {
        System.out.println("Object created");
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ageGroup = AgeGroup.valueOf("CHILDREN");
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
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (age != person.age) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (address != null ? !address.equals(person.address) : person.address != null) return false;
        return ageGroup == person.ageGroup;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (ageGroup != null ? ageGroup.hashCode() : 0);
        return result;
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
