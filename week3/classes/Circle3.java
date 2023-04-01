package week3.classes;

import week3.interfaces.Spinable;

public class Circle3 implements Spinable {
  private double radius;
  private double area;

  private Direction changeDirection; //0 = left, 1 = right
  private int speed;


  public Circle3() {

  }

  public Circle3(double radius) {
    this.radius = radius;
    this.area = Circle3.calcArea(radius);
  }

  public void setRadius(double radius) {
    this.radius = radius;
    this.area = Circle3.calcArea(radius);
  }

  public double getRadius() {
    return this.radius;
  }

  public double getArea() {
    return this.area;
  }

  private static double calcArea(double radius) {
    return radius * 2 * 3.14;
  }

  @Override
  public void changeDirection(int direction){
    this.direction = direction;
  } 

  @Override
  public boolean stop(){
    if (this.speed ==0){
      return false;
    }
    this.speed = 0;
    return true;
  } 

  @Override
  public boolean start(){
    if (this.speed != 0){
      return false;
    }
    accelarate(10);
    return true;
  }

  @Override
  public void accelerate(int delta){
    this.speed += delta;
  } 

  public Direction gDirection(){
    return this.direction;
  }

}

  public static void main(String[] args) {

    Circle3 circle = new Circles3();

    if(Cirecle.direction == Direction.LEFT) {
      System.out.println("This is left");
    }
    
  }

