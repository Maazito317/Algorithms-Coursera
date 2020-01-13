package Sorting_Interview;
/*
    Question 2
    Permutation.
    Given two integer arrays of size N, design a subquadratic algorithm to determine whether one is a permutation of the other.
    That is, do they contain exactly the same entries but, possibly, in a different order.
     */
public class Permutation {

    public static boolean checkPerms(Comparable[] first, Comparable[] second){
        if (first.length != second.length) return false;
        ShellSort.sort(first);
        ShellSort.sort(second);

        for (int i = 0; i < first.length; i++){
            if (first[i] != second[i]) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Integer[] first = {1,3,5,7,9,0,8,6,4,2};
        Integer[] second = {0,8,6,4,2,1,3,5,7,9};

        System.out.println(checkPerms(first,second));

        Integer[] third = {1,3,5,7,9,0,8,6,4};
        Integer[] fourth = {0,8,6,4,2,1,3,5,7};

        System.out.println(checkPerms(third,fourth));
    }
}
