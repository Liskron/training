package pl.pollub.training.model.day2;

import java.io.*;

public class SerializeDemo implements Serializable{


    public String name;
    public String address;
    public transient int SSN;
    public int number;

    public void mailCheck()
    {
        System.out.println("Mailing a check to " + name + " " + address);
    }
}
