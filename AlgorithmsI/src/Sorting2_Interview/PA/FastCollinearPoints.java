package Sorting2_Interview.PA;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MergeX;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {
    private final LineSegment[] segments;
    private int SegmentSize;

    public FastCollinearPoints(Point[] points){
        if (points == null) throw new IllegalArgumentException("Points can not be null");
        for (Point p: points){
            if (points == null) throw new IllegalArgumentException("Points can not be null");
        }
        Point[] p = new Point[points.length];
        System.arraycopy(points,0,p,0,points.length);
        segments = makeSegments(p);
    }
    private LineSegment[] makeSegments(Point[] p){
        LineSegment[] tmp = new LineSegment[p.length*4];
        MergeX.sort(p);

        for (int i = 0; i < p.length; i++){
            Point point = p[i];
            int copyLen = p.length - i - 1;
            Point[] copy = new Point[copyLen];
            System.arraycopy(p,i+1,copy,0,copyLen);
            MergeX.sort(copy,point.slopeOrder());
            int counter = 2;

            for (int j = 1; j < copyLen; j++){
                if (Double.compare(point.slopeTo(copy[j-1]),point.slopeTo(copy[j]))==0) counter++;
                else{
                    if(counter >= 4) tmp[SegmentSize++] = new LineSegment(point,copy[j-1]);
                    counter=2;
                }
            }
            if (counter >= 4) tmp[SegmentSize++] = new LineSegment(point,copy[copyLen-1]);
        }
        LineSegment[] finalSegments = new LineSegment[SegmentSize];
        for (int i = 0; i < SegmentSize; i++){
            finalSegments[i] = tmp[i];
        }
        return finalSegments;
    }

    public int numberOfSegments(){return SegmentSize;}        // the number of line segments
    public LineSegment[] segments(){
        return segments;
    }                // the line segments

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}
