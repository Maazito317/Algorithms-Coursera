package Sorting2_Interview;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0; //returns true if v is less than w
    }

    private static boolean isSorted(Comparable[] a){
        return isSorted(a,0,a.length-1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi){
        for (int i = lo; i <= hi; i++){
            if (less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static void exchange(Comparable[] a, int i, int j){
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static int partition(Comparable[] arr, int lo, int hi){
        int i = lo;
        int j = hi+1;

        while(true){
            while(less(arr[i++],arr[lo])){
                if (i == hi) break;
            }
            while(less(arr[lo],arr[j--])){
                if (j == lo) break;
            }
            if (i >= j) break;
            exchange(arr,i,j);
        }
        exchange(arr,lo,j);
        return j;
    }

    private static void sort(Comparable[] arr, int lo, int hi){
        if (lo >= hi) return;
        int j = partition(arr, lo, hi);
        sort(arr, lo, j-1);
        sort(arr, j+1, hi);
    }

    public static void sort(Comparable[] arr){
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length-1);
    }

}
