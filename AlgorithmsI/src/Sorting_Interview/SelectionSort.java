package Sorting_Interview;

public class SelectionSort {
    private static void exchange(Comparable[] arr, int m, int n){
        Comparable tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0;
    }

    public static void sort(Comparable[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++){
            int min = i;
            for (int j = i+1; j<len; j++){
                if (less(arr[j],arr[min])) min = j;
            }
            exchange(arr,i,min);
        }
    }

    public static void main(String[] args){
        Integer[] arr = {5, 3, 7, 1, 8, 2, 4, 9, 10, 6};
        SelectionSort.sort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }


    }
}
