package Union_Find_Interview.In_Lecture;

public class WeightedQuickUnionUF {
    private int[] id;
    private int[] size;

    public WeightedQuickUnionUF(int N){
        size = new int[N];
        id = new int[N];
        for(int i = 0; i <N; i++){
            id[i] = i;
            size[i] = 1;
        }

    }

    private int root(int i){ //only root entries would have their id value the same as i
        while(i != id[i]){
            id[i] = id[id[i]]; //path compression
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){ //change the value of the root of q
        if (!connected(p,q)){
            int i = root(p);
            int j = root(q);
            if (size[i] < size[j]) {
                id[i] = j;
                size[j] += size[i];
            }
            else{
                id[j] = i;
                size[i] += size[j];
            }
        }
    }
    //Better implementation since union and find take O(lgN) without path compression
}
