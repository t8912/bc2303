package week3.games.poker.model;

import week3.games.poker.enums.CardNumber;
import week3.games.poker.enums.CardSuit;

public class Card {
  private final CardNumber number;
  private final CardSuit suit;

  public Card(CardNumber number, CardSuit suit) {
      this.number = number;
      this.suit = suit;
  }

  public CardNumber getNumber() {
      return number;
  }

  public CardSuit getSuit() {
      return suit;
  }

  @Override
  public String toString() {
      return number + " of " + suit;
  }
}

/*
 * public class Card {
  private final CardNumber number;
  private final CardSuit suit;
  
  public Card(CardNumber number, CardSuit suit) {
      this.number = number;
      this.suit = suit;
  }
  
  public CardNumber getNumber() {
      return this.number;
  }
  
  public CardSuit getSuit() {
      return this.suit;
  }

  @Override
  public String toString() {
      return this.number.getName() + this.suit.getName();
  }

}
 */

/*import week3.games.poker.enums.CardNumber;
import week3.games.poker.enums.CardSuit;

public class Card {
  private final CardNumber number;
  private final CardSuit suit;

  public Card(CardNumber number, CardSuit suit) {
      this.number = number;
      this.suit = suit;
  }

  public CardNumber getNumber() {
      return this.number;
  }

  public CardSuit getSuit() {
      return this.suit;
  }

  @Override
  public String toString() {
      return this.number + " of " + this.suit;
  }
}
 * 
 */

 