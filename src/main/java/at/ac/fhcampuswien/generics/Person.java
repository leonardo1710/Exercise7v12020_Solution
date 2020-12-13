package at.ac.fhcampuswien.generics;

import java.io.*;

public abstract class Person implements Comparable<Person>, Serializable {

    private String name;

    public Person(String name){
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    public static void serializePerson(Person p, String filename){
        FileOutputStream fos;
        ObjectOutputStream out;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(p);
            out.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Person deserializePerson(String filename){
        Person p = null;
        FileInputStream fis;
        ObjectInputStream in;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            p = (Person)in.readObject();
            in.close();
        } catch(IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return p;
    }
}
