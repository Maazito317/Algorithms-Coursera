package Priority_Queues_Interview;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.MaxPQ;

//Dynamic median.
// Design a data type that supports insert in logarithmic time, find-the-median in constant time,
// and remove-the-median in logarithmic time. If the number of keys in the data type is even,
// find/remove the lower median.

public class MedianHeap {

    private MaxPQ<Integer> right;
    private MinPQ<Integer> left;
    private int L;
    private int R;

    MedianHeap(){
        right = new MaxPQ<Integer>();
        left = new MinPQ<Integer>();
    }

    public double findMedian(){
        L = left.size();
        R = right.size();
        if (L > R) return left.min();
        else if (L < R) return right.max();
        else return ((double)left.min() + (double)right.max())/2;
    }

    public void insert(Integer k){
        double median = findMedian();
        if (k < median){
            right.insert(k);
            if (R - L > 1){
                left.insert(right.max());
            }
        }
        else if (k >= median){
            left.insert(k);
            if (L- R > 1){
                right.insert(left.min());
            }
        }
    }

    public double removeMedian(){
        int L = left.size();
        int R = right.size();
        if (L > R) return left.delMin();
        else return right.delMax();
    }
}
