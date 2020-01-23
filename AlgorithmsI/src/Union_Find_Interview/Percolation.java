package Union_Find_Interview;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int size;
    private int[] open;
    private WeightedQuickUnionUF wquf;
    private int width;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        size = n*n;
        open = new int[size];
        width = n;
        wquf = new WeightedQuickUnionUF(size+2);
    }

    private void validateInput(int i, int j){
        if (i <=0 || i > width) throw new IllegalArgumentException("Row arg is out of bounds");
        if (j <=0 || j > width) throw new IllegalArgumentException("Column arg is out of bounds");

    }

    private int convTo1D(int i, int j){
        return ((i*width - width) + j) - 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        validateInput(row,col);
        int toOpen = convTo1D(row,col);
        open[toOpen] = 1;
        connectToNeighbors(row, col);
    }

    private void connectToNeighbors(int i, int j){}

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        validateInput(row, col);
        return (open[convTo1D(row,col)] == 1);
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){return true;}

    // returns the number of open sites
    public int numberOfOpenSites(){return -1;}

    // does the system percolate?
    public boolean percolates(){return true;}

    // test client (optional)
    public static void main(String[] args){}
}