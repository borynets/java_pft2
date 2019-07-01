package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point;

public class PointTests {

  @Test
  public void distanceTest (){
    Point p = new Point(10, 8);
    Point p2 = new Point (6,4);
    Assert.assertEquals(Math.round(p.distance(p2)), 6);
  }

  @Test
  public void distanceTest2 (){
    Point p = new Point(22, 13);
    Point p2 = new Point (10,7);
    Assert.assertEquals(Math.round(p.distance(p2)), 13);
  }
}
