package pl.pollub.training.model.day2;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by Wlad on 26.04.2016.
 */
public class SerializeDemoTest {

    @Test
    public void testingSerializeFile(){
        SerializeDemo e = new SerializeDemo();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 888;

        try{
            ObjectOutputStream out =
                    new ObjectOutputStream( new FileOutputStream("C:\\projects\\serialize.ser"));
            out.writeObject(e);
            out.close();
            System.out.println("Serialized data is saved in C:\\projects\\serialize.ser");
        } catch (java.io.IOException e1) {
            e1.printStackTrace();
        }
    }

    @Test
    public void testingDeserializeFile(){
        SerializeDemo e = null;
        try{
            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream("C:\\projects\\serialize.ser"));
            e = (SerializeDemo) in.readObject();
            in.close();
        } catch (ClassNotFoundException e1) {
            System.out.println("SerializeDemo class not found");
            e1.printStackTrace();
            return;
        }catch (IOException e1) {
            e1.printStackTrace();
            return;
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
    }
}