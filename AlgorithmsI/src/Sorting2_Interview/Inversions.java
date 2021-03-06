package Sorting2_Interview;

import java.util.Arrays;

public class Inversions {
        private static int num = 0;
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

    private static void merge(Comparable[] original, Comparable[] copy, int lo, int mid, int hi){
        assert isSorted(original, lo, mid);
        assert isSorted(original, mid+1, hi);

        for (int i = lo; i <= hi; i++){
            copy[i] = original[i];
        }

        int i = lo;
        int j = mid+1;
        for (int k = lo; k <= hi; k++ ){
            if (i > mid) original[k] = copy[j++];
            else if (j > hi) original[k] = copy[i++];
            else if (less(copy[i], copy[j])) original[k] = copy[i++];
            else {original[k] = copy[j++]; num += mid + 1 - i;}
        }

        assert isSorted(original,lo,hi);
    }

    private static void sort(Comparable[] original, Comparable[] copy, int lo, int hi){
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(original, copy, lo, mid);
        sort(original, copy, mid+1, hi);
        merge(original,copy,lo,mid,hi);
    }

    public static void sort(Comparable[] toSort){
        Comparable [] copy = new Comparable[toSort.length];
        sort(toSort, copy, 0, toSort.length - 1);
    }

    public static int numInvert(Comparable[] toSort){
        Comparable[] copy = new Comparable[toSort.length];
        sort(toSort, copy, 0, toSort.length - 1);
        return num;
    }

    public static void main(String[] args){
        Integer[] arr = {6,5,4,3,2,1};
        Inversions i = new Inversions();
        System.out.println(numInvert(arr));
        System.out.println(Arrays.toString(arr));
    }
}
