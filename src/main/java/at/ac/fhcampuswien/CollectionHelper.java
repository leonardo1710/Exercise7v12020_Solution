package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionHelper {

    public static List<String> intersection(List<String> a, List<String> b){
        List<String> intersects = new ArrayList<>();

        for(String element : a){
            if(b.contains(element)){
                if(!intersects.contains(element)){
                    intersects.add(element);
                }
            }
        }

        for(String element : b){
            if(a.contains(element)){
                if(!intersects.contains(element)){
                    intersects.add(element);
                }
            }
        }

        return intersects;
    }

    public static Set<Number> symmetricDifference(Set<Number> a, Set<Number> b){
        Set<Number> symDiff = new HashSet<>(a);
        symDiff.addAll(b); // Union
        Set<Number> intersection = new HashSet<>(a);
        intersection.retainAll(b); // Intersection
        symDiff.removeAll(intersection);
        return symDiff;
    }

    public static <T extends Number> Set<T> genericSymmetricDifference(Set<? extends T> a, Set<? extends T> b) {
        Set<T> symDiff = new HashSet<>(a);
        symDiff.addAll(b); // Union
        Set<T> intersection = new HashSet<>(a);
        intersection.retainAll(b); // Intersection
        symDiff.removeAll(intersection);
        return symDiff;
    }


}
