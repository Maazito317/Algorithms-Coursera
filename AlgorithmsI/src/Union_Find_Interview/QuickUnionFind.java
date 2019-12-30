package Union_Find_Interview;

/**
 * Social network connectivity.
 * Given a social network containing nn members and a log file containing m timestamps at which times pairs of members formed friendships,
 * design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend).
 * Assume that the log file is sorted by timestamp and that friendship is an equivalence relation.
 * The running time of your algorithm should be mlogn or better and use extra space proportional to n.
 */

public class QuickUnionFind {

    private int[] parent;
    private int[] size;
    private int numConnComp;

    public QuickUnionFind(int N){
        numConnComp = N;
        size = new int[N];
        parent =new int[N];

        for(int i = 0; i < N; i++){
            size[i]=1;
            parent[i]=i;
        }
    }

    public int count(){ return numConnComp;} //Use this to check when count reaches 1 means all the connections have been established

    public void validate(int p){
        int n = parent.length;
        if (p < 0 || p >=n){throw new IllegalArgumentException("index "+p+ " is not in between 0 and "+(n-1));}
    }

    public int root(int p){
        validate(p);
        while (p !=parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int rootP = root(p);
        int rootQ = root(q);
        if (connected(p,q)) return;

        if (size[rootP] < size[rootQ]){
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        numConnComp--;
    }

}
