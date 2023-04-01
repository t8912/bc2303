package week3.interfaces;

import week3.classes.Direction;

public interface Spinable {

  boolean start();

  boolean stop();

  void changeDirection(Direction direction);

  void accelarate(int speed);
  
}
