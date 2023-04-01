package week3.classes;

public enum Direction {

  LEFT(0, "Left Direction"), //
  RIGHT(1, "Right Diection"), // 
  ;

  private int code;
  private String desc;

  private Direction(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public int getCode() {
    return this.code;
  }

  public String getDes() {
    return this.desc;
  }

}
