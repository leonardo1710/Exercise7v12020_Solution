package at.ac.fhcampuswien;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args){
        //Experiment with your implementation, especially generics, here!
    }


    public static <T> void copyFromArrayToCollection(T[] a, Collection<T> c) {
        Collections.addAll(c, a);
    }

    public static <T extends Number> void copyFromNumbersArrayToCollection(T[] a, Collection<T> c){
        Collections.addAll(c, a);
    }

    public static List<String> fileToList(String filename) {
        File file = new File(filename);
        List<String> fileList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                fileList.add(line);
            }
        } catch (IOException e) {
            System.err.format("Could not read %s: %s%n", file, e);
        }
        return fileList;
    }

}
