package practice.support;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Kitestring {
    public static void main(String[] args) {

        System.out.println(getMinUnique(List.of(3,2,1,2,7)));
    }

    public static int getMinUnique(List<Integer> arr){
        HashSet<Integer> nums = new HashSet<>();

        for(Integer num : arr){
            if(!nums.contains(num)){
                nums.add(num);
            }else{
                while (nums.contains(num)){
                    num++;
                }
                nums.add(num);
            }
        }
int sum = 0;
        for(Integer num : nums){
            sum+=num;
        }

        return sum;
    }
}
