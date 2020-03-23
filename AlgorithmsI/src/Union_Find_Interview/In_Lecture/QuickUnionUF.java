package Union_Find_Interview.In_Lecture;

public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N){
        id = new int[N];
        for(int i = 0; i <N; i++){
            id[i] = i;
        }
    }

    private int root(int i){ //only root entries would have their id value the same as i
        while(i != id[i]) i = id[i];
        return i;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){ //change the value of the root of q
        int i = root(p);
        int j = root(q);
        id[j] = i;
    }

    //Worst case for all operations are O(N)
    // Trees can get tall and find is more expensive that QuickFind
}
