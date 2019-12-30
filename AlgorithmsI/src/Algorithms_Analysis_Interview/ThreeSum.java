package Algorithms_Analysis_Interview;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class ThreeSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while (sc.hasNextInt()){
            nums.add(sc.nextInt());
        }

        Collections.sort(nums);

        for (int i = 0; i < nums.size() -2; i++ ){
            int j = i+1;
            int k = nums.size()-1;

            while (j < k){
                int sum = nums.get(i) + nums.get(j) + nums.get(k);
                if (sum == 0){
                    System.out.println(i+":"+nums.get(i)+", "+j+":"+nums.get(j)+", "+k+":"+nums.get(k));
                }
                if (sum >= 0){
                    k--;
                } else j++;
            }
        }

    }
}
