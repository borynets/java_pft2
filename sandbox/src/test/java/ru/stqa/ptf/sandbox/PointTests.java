package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point;

public class PointTests {

  @Test
  public void distanceTest (){
    Point p = new Point(10, 8);
    Point p2 = new Point (6,4);
    Assert.assertEquals(Point.distance(p,p2), 16);
  }
}
