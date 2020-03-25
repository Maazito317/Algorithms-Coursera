package Algorithms_Analysis_Interview.In_Lecture;

public class BinarySearch {

    public static int search(int[] arr, int key){
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            if (key < arr[mid]) hi = mid - 1;
            else if (key > arr[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(search(arr, 6));
        System.out.println(search(arr, 13));
        System.out.println(search(arr, 1));
    }
}
