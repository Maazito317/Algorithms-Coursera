package Sorting2_Interview;

import java.util.Arrays;

public class SmallAuxMerge {
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0; //returns true if v is less than w
    }

    public void merge(Comparable [] data){
        int AuxLen = data.length/2;
        Comparable [] aux = new Comparable[AuxLen];

        for(int i=0; i<AuxLen; i++) aux[i] = data[i];

        int i=0, j = AuxLen;
        for(int k=0; k<data.length; k++){
            if(i > AuxLen) data[k] = data[j++];
            else if(j > data.length-1) data[k] = aux[i++];
            else if(less(aux[i], data[j])) data[k] = aux[i++];
            else data[k] = data[j++];
        }

    }

    public static void main(String... args){
        Integer [] data = {1,3,5,7,9,0,2,4,6,8};
        SmallAuxMerge M = new SmallAuxMerge();
        M.merge(data);
        System.out.println(Arrays.toString(data));
    }
}
