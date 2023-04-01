package week3.games.poker.enums;

//public enum CardNumber {
  /*ACE(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5),
  SIX(6),
  SEVEN(7),
  EIGHT(8),
  NINE(9),
  TEN(10),
  JACK(11),
  QUEEN(12),
  KING(13);

  private final int value;

  CardNumber(int value) {
      this.value = value;
  }

  public int getValue() {
      return value;
  }
}
   * 
   * 
   * 
   * 
   * 
   * 
   */

/*
 * public enum CardNumber {
    ACE("Ace"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King"),
    RED_JOKER("Red Joker"),
    BLACK_JOKER("Black Joker");
    
   
}
  
 */

 public enum CardNumber {
  TWO(2), 
  THREE(3), 
  FOUR(4), 
  FIVE(5), 
  SIX(6), 
  SEVEN(7), 
  EIGHT(8), 
  NINE(9), 
  TEN(10),
  JACK(11), 
  QUEEN(12), 
  KING(13), 
  ACE(14);

  private final int value;

  CardNumber(int value) {
      this.value = value;
  }

  public int getValue() {
      return value;
  }
}