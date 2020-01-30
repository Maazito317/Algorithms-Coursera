package Sorting2_Interview.PA;

import edu.princeton.cs.algs4.MergeX;

public class BruteCollinearPoints {
    private final LineSegment[] segments;
    private int SegmentSize;

    public BruteCollinearPoints(Point[] points){
        if (points == null) throw new IllegalArgumentException("Points can not be null");
        for (Point p: points){
            if (points == null) throw new IllegalArgumentException("Points can not be null");
        }
        Point[] p = new Point[points.length];
        System.arraycopy(points,0,p,0,points.length);
        segments = makeSegments(p);
    }   // finds all line segments containing 4 points

    private LineSegment[] makeSegments(Point[] p){
        LineSegment[] tmp = new LineSegment[p.length*4];
        MergeX.sort(p);
        for (int i = 0; i < p.length; i++){
            for (int j = i+1; j < p.length; j++){
                for (int k = j+1; k < p.length; k++){
                    for (int l = k+1; l < p.length; l++){
                        Point a = p[i];
                        Point b = p[j];
                        Point c = p[k];
                        Point d = p[l];
                        if (Double.compare(a.slopeTo(b),a.slopeTo(c))==0 && Double.compare(a.slopeTo(b),a.slopeTo(d))==0){
                            tmp[SegmentSize++] = new LineSegment(a,d);
                        }
                    }
                }
            }
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
}
