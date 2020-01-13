package Sorting_Interview;
/*
    Question 1
    Intersection of two sets.
    Given two arrays a[] and b[], each containing N distinct 2D points in the plane,
    design a subquadratic algorithm to count the number of points that are contained both in array a[] and array b[].
     */
public class IntersectionCheck {
    static class Point implements Comparable<Point>{
        private int x;
        private int y;

        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(Point o) { // true if o is smaller than this
            if (o.x > this.x) return -1;
            if (o.x < this.x) return 1;
            if (o.y > this.y) return -1;
            if (o.y < this.y) return 1;
            return 0;
        }
    }
    public static int count(Point[] first, Point[] second) {
        int count = 0;
        ShellSort.sort(first);
        ShellSort.sort(second);
        int i = 0;
        int j = 0;

        while (i < first.length && j < second.length) {
            if (first[i].compareTo(second[j]) == 0) {
                i++;
                j++;
                count++;
            } else if (first[i].compareTo(second[j]) < 0) i++;
            else j++;
        }
        return count;
    }

    public static void main(String[] args){
        Point[] first = {new Point(1,2), new Point(5,3), new Point(2,2), new Point(7,3),new Point(1,9)};
        Point[] second = {new Point(8,2), new Point(5,3), new Point(4,7), new Point(7,3),new Point(0,9)};
        System.out.println("Num Intersection: "+ count(first,second));
    }
}
