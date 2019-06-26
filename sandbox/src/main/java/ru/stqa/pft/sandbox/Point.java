package ru.stqa.pft.sandbox;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static double distance(Point p1, Point p2){
    double result = (p1.x - p2.x)*2 + (p1.y - p2.y)*2;
    double distance = Math.sqrt(result);
    return distance;
  }
}
