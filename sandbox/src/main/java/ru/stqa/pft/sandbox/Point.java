package ru.stqa.pft.sandbox;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point p2){
    double result = Math.pow((this.x - p2.x), 2) + Math.pow((this.y - p2.y), 2);
    double distance = Math.sqrt(result);
    return distance;
  }
}
