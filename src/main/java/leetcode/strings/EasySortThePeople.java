package leetcode.strings;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * N2418 Sort the People
 * You are given an array of strings names, and an array heights that consists of distinct positive integers.
 * Both arrays are of length n.
 * For each index i, names[i] and heights[i] denote the name and height of the ith person.
 * Return names sorted in descending order by the people's heights.
 */
public class EasySortThePeople {
    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};

        System.out.println(Arrays.toString(sortPeople(names, heights)));
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        class Person implements Comparable<Person> {
            final int height;
            final String name;

            Person(String name, int height) {
                this.name = name;
                this.height = height;
            }

            @Override
            public int compareTo(Person person) {
                return person.height - this.height;
            }
        }

        Set<Person> people = new TreeSet<>();
        for (int i = 0; i < names.length; i++) {
            people.add(new Person(names[i], heights[i]));
        }
        Iterator<Person> iterator = people.iterator();
        int counter = 0;
        while (iterator.hasNext()) {
            names[counter++] = iterator.next().name;
        }
        return names;
    }
}
