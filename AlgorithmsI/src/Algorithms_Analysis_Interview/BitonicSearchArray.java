package Algorithms_Analysis_Interview;

public class BitonicSearchArray {

    private static int findMax(int[] arr, int start, int end){ //using binary search
        int mid = (start + end)/2;
        if (start == end) return mid;

        else if(arr[mid] > arr[mid+1]){
            return findMax(arr,start, mid);
        } else{
            return findMax(arr,mid+1,end);
        }
    }


}

