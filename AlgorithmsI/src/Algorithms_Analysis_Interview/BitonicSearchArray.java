package Algorithms_Analysis_Interview;

/**
 * Search in a bitonic array. An array is bitonic if it is comprised of an increasing sequence of integers followed immediately by a decreasing sequence of integers. Write a program that, given a bitonic array of nn distinct integer values, determines whether a given integer is in the array.
 *
 * Standard version: Use ∼3lgn compares in the worst case.
 * Signing bonus: Use ∼2lgn compares in the worst case (and prove that no algorithm can guarantee to perform fewer than ∼2lgn compares in the worst case).
 */
public class BitonicSearchArray {

    public static boolean SearchVal(int[] arr, int start, int end, int toFind, boolean asc){
        int mid = (start+end)/2;
        if (start == end) return true;
        if (start > end) return false;

        if ((asc && arr[mid] > toFind )||(!asc && arr[mid] < toFind)) return SearchVal(arr, start,mid-1,toFind,asc);
        else return SearchVal(arr,mid+1,end,toFind,asc);

    }

    public static int findMax(int[] arr, int start, int end){ //using binary search
        int mid = (start + end)/2;
        if (start == end) return mid;

        else if(arr[mid] > arr[mid+1]){
            return findMax(arr,start, mid);
        } else{
            return findMax(arr,mid+1,end);
        }
    }

    public static boolean find(int[] arr,int peak,int toFind){
        return SearchVal(arr,0,peak, toFind,true) || SearchVal(arr,peak,arr.length-1,toFind,false);
    }

    public static void main(String[] args){
        int[] arr = {1,3,5,7,9,11,8,6,4,2};
        int toFind = 7;

        int max = findMax(arr,0,arr.length-1);
        System.out.println(toFind+":"+find(arr,max,toFind));

    }

}

