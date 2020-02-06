package Sorting2_Interview;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class ThreeWayQuickSort {

    public static void exchange(Comparable[] a, int i, int j){
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0; //returns true if v is less than w
    }

    private static void sort(Comparable[] arr, int lo, int hi){
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = arr[lo];
        int i = lo;
        while (i <= gt){
            if (less(arr[i],v)) exchange(arr, lt++, i++);
            else if (less(v,arr[i])) exchange(arr, i, gt--);
            else i++;
        }
        sort(arr, lo, lt-1);
        sort(arr, gt+1, hi);

    }

    public static void sort(Comparable[] arr){
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length-1);
    }

    public static void main(String[] args){
        Integer[] arr = {1,2,3,5,7,4,2,3,2,2,8,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
