package at.ac.fhcampuswien.generics;

import java.util.*;

public class Student extends Person {
    private final int STUDENT_ID;

    public Student(String name, int ID){
        super(name);
        this.STUDENT_ID = ID;
    }

    public int getStudentID(){
        return STUDENT_ID;
    }

    public static Map<Integer, Student> listOfStudentsToMap(List<Student> students){
        Map<Integer, Student> map = new HashMap<>();
        for (Student student : students) {
            map.put(student.getStudentID(), student);
        }
        return map;
    }

    public static List<Student> eraseDuplicatesInList(List<Student> students){
        Set<Student> duplicates = new HashSet<>();
        Set<Student> uniques = new HashSet<>();
        for (Student s : students) {
            if(!uniques.add(s)){
                duplicates.add(s);
            }
        }
        students.clear();
        students.addAll(uniques);
        return new ArrayList<>(duplicates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Student student = (Student) o;
        return STUDENT_ID == student.STUDENT_ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(STUDENT_ID);
    }

}
