package practice.mid;

import java.util.*;

public class PowerSet {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        //list.add(4);

        List<Set<Integer>> result = powerSet(list);

        for (Set<Integer> mySet : result) {
            System.out.println(mySet.toString());
        }


    }

    public static List<Set<Integer>> powerSet(List<Integer> X) {
        List<Set<Integer>> P = new ArrayList<Set<Integer>>();
        Set<Integer> S = new HashSet<>();
        P.add(S);
        if (!X.isEmpty()) {
            while (!X.isEmpty()) {
                int f = X.remove(0);
                List<Set<Integer>> T = new ArrayList<Set<Integer>>(P);
                for (Set<Integer> x : T) {
                    S = new HashSet<Integer>();
                    S.add(f);
                    S.addAll(x);
                    P.add(S);
                }
                System.out.println();
            }
        }
        return P;
    }
}
