package Union_Find_Interview;

public class UFwithSuccessorDelete {
    private boolean[] inS;
    private UnionFindWithLargest uf;
    private int N;

    public UFwithSuccessorDelete(int N){
        this.N = N;
        inS = new boolean[N];
        for(int i = 0; i < N; i++){
            inS[i] = true;
        }
        uf = new UnionFindWithLargest(N);
    }

    public void remove(int x){
        inS[x] = false;
        if (x > 0 && !inS[x-1]){
            uf.union(x , x - 1);
        }
        if (x < N - 1 && !inS[x + 1]){
            uf.union(x , x + 1);
        }
    }

    public int successor(int x){
        if(inS[x]) return x;
        else{
            int res = uf.find(x) + 1;
            if (res >= N){
                System.out.println("No successor");
                return -1;
            }
            else return res;
        }
    }

    public static void main(String[] args){
        UFwithSuccessorDelete  uf = new UFwithSuccessorDelete(15);
        uf.remove(3);
        System.out.println(uf.successor(2));
        System.out.println(uf.successor(3));
        uf.remove(8);
        uf.remove(7);
        System.out.println(uf.successor(7));

    }
}
