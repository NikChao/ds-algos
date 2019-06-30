package com.company;

import java.util.*;

public class KClosestPoints {

    public static class Point {
        public double x;
        public double y;

        public double distance() {
            return Math.sqrt(x*x+y*y);
        }

        public String toString() {
            return Double.toString(x) + ", " + Double.toString(y);
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // nlogn solution
    public List<Point> kClosestPoints(List<Point> points, int k) {
        PriorityQueue<Point> pointQueue =
                new PriorityQueue<>(k, (Point a, Point b) -> (int) Math.ceil(b.distance() - a.distance()));

        for (Point p : points) {
            pointQueue.add(p);
        }

        while (pointQueue.size() > k) {
            pointQueue.remove();
        }

        return new ArrayList<>(pointQueue);
    }
}