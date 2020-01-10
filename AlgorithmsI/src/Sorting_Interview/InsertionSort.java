package Sorting_Interview;

public class InsertionSort { //faster than Selection as all elements don't have to be traversed
    private static void exchange(Comparable[] arr, int m, int n){
        Comparable tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0; //returns true if v is less than w
    }

    public static void sort(Comparable[] arr){
        for(int i = 0; i < arr.length; i++){
            for (int j = i; j > 0; j--){
                if(less(arr[j],arr[j-1]))
                    exchange(arr,j,j-1);
                else break;
            }
        }
    }

    public static void main(String[] args){
        Integer[] arr = {5, 3, 7, 1, 8, 2, 4, 9, 10, 6};
        InsertionSort.sort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
