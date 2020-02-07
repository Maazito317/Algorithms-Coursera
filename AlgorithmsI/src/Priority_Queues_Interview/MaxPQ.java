package Priority_Queues_Interview;

public class MaxPQ <Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public MaxPQ(int capacity){
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public MaxPQ() {

    }

    public boolean isEmpty(){ return N==0;}

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j){
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private void swim(int k){
        if (k > 0 && less(k/2, k)){
            exchange(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2*k <= N){
            int j = 2*k;
            if (j < N && less(j,j+1)) j++;
            if (!less(k,j)) break;
            exchange(k,j);
            k = j;
        }
    }

    public void insert(Key k){
        pq[N++] = k;
        swim(N);
    }

    public Key deleteMax(){
        if (isEmpty()) throw new NullPointerException("Nothing to delete");
        Key max = pq[1];
        exchange(1,N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }
}
