package Union_Find_Interview;

/**
 Union-find with specific canonical element.
 Add a method find() to the union-find data type so that find(i) returns the largest element in the connected component containing i.
 The operations, union(), connected(), and find() should all take logarithmic time or better.
 For example, if one of the connected components is {1,2,6,9},
 then the find() method should return 99 for each of the four elements in the connected components.
 **/

public class UnionFindWithLargest {
    private int[] large;
    private int[] parent;
    private int[] size;
    private int count;

    public UnionFindWithLargest(int N)
    {
        count = N;
        parent = new int[N];
        size = new int[N];
        large = new int[N];
        for (int i = 0; i < N; i++){
            parent[i] = i;
            size[i] = 1;
            large[i] = i;
        }
    }

    public int count() {return count;}

    public void validate(int p){
        int n = parent.length;
        if (p < 0 || p >=n){throw new IllegalArgumentException("index "+p+ " is not in between 0 and "+(n-1));}
    }

    public int root(int p){
        validate(p);
        while (p != parent[p])
            parent[p] = parent[parent[p]]; //path compression
        p = parent[p];
        return p;

    }


    public int find(int p){
        return large[root(p)];
    }

    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }
    public void union(int p, int q)
    {
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) return;

        int largestP = large[root(p)];
        int largestQ = large[root(q)];


        //weighting
        if(size[rootP] < size[rootQ]){
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
            if(largestP > largestQ) large[rootP] = largestP; //updating largest value
        }
        else{
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
            if(largestP < largestQ) large[rootQ] = largestQ;
        }
        count--;
    }


}
