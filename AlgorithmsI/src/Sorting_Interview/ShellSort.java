package Sorting_Interview;

public class ShellSort {
    private static void exchange(Comparable[] arr, int m, int n){
        Comparable tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0; //returns true if v is less than w
    }

    public static void sort(Comparable[] arr){
        int h = 1;
        while (h < arr.length/3) h = 3*h + 1;

        while(h >= 1){
            for (int i = h; i < arr.length; i++){
                for (int j = i; j >= h && less(arr[j],arr[j-h]); j -=h){
                    exchange(arr,j,j-h);
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args){
        Integer[] arr = {5, 3, 7, 1, 8, 2, 4, 9, 10, 6};
        ShellSort.sort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
