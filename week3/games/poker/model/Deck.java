package week3.games.poker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import week3.games.poker.enums.CardNumber;
import week3.games.poker.enums.CardSuit;
import week3.games.poker.interfaces.Shuffling;

public class Deck implements Shuffling {
    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (CardSuit suit : CardSuit.values()) {
            for (CardNumber number : CardNumber.values()) {
                cards.add(new Card(number, suit));
            }
        }
    }

    public Card draw() {
        if (cards.isEmpty()) {
            throw new RuntimeException("Deck is empty.");
        }
        return cards.remove(0);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int size() {
        return cards.size();
    }
}


//public class Deck implements Shuffling {
  ///public class Deck {

  
  //private final List<Card> cards;

  //public Deck() {
      //cards = new ArrayList<>();
     // for (CardSuit suit : CardSuit.values()) {
          //for (CardNumber number : CardNumber.values()) {
              //cards.add(new Card(number, suit));
          //}
      //}
  //}

 // public Card draw() {
     // if (cards.isEmpty()) {
        //  throw new RuntimeException("Deck is empty.");
     // }
    //  return cards.remove(0);
 // }

  //public void shuffle() {
     // Collections.shuffle(cards);
  //}

 // public int size() {
   // return cards.size();
//}
//}
  
  


/*public class Deck {
  private final List<Card> cards;
  
  public Deck() {
      cards = new ArrayList<>();
      for (CardSuit suit : CardSuit.values()) {
          for (CardNumber number : CardNumber.values()) {
              cards.add(new Card(number, suit));
          }
      }
  }
  
  //@Override
  //public void shuffle(List<?> list) {
    //  Collections.shuffle(list);
  //}
  
  //public void shuffle() {
    //  shuffle(cards);
  //}
  
  public Card deal() {
      if (cards.isEmpty()) {
          return null;
      }
      return cards.remove(0);
  }
  
  public List<Card> deal(int count) {
      List<Card> dealtCards = new ArrayList<>();
      for (int i = 0; i < count; i++) {
          Card card = deal();
          if (card != null) {
              dealtCards.add(card);
          }
      }
      return dealtCards;
    }

}
 * 
 */











/*
 * import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import week3.games.poker.enums.CardNumber;
import week3.games.poker.enums.CardSuit;

public class Deck {
  ArrayList<Card> cards;

  public Deck() {
    cards = new ArrayList<>();
    // Adding 52 + 2 into a deck
    for (CardNumber number : CardNumber.values()) { // 15
      if (number == CardNumber.RED_JOKER || number == CardNumber.BLACK_JOKER) {
        cards.add(new Card(number, CardSuit.DEFAULT));
        continue;
      }
      for (CardSuit suit : CardSuit.values()) {
        if (suit != CardSuit.DEFAULT) {
          cards.add(new Card(number, suit));
        }
      }
    }
  }



  public boolean removeJokers(){
  //for loop??
List<Card> removeList = new ArrayList<>();
for (Card card : this.cards){
 if (card.getNumber() == CardNumber.RED_JOKER //
  || card.getNumber() == CardNumber.BLACK_JOKER){
   this.cards.remove(card);
  }
}
return this.cards.removeAll(removeList);

}
///public void removeJokers(List<String> cards){
///for (int i = cards.size(); i >=0; i--){
 /// if (cards.contains("JOKER")){
    ///cards.remove(i);
 /// }
 // cards.remove(i);
///} 
  //remove
  //cards.remove(i);
///}

public void riffle() {

}

public void overhand() {

}

//public void shuffling(){
//cards = new ArrayList<>();
  //for (int i = 0; i <10; i++){
   //int intdex1 = 
  //}
// 10 times shuffling 
//random 2 index
// tips array
//ArrayList to Array
//shuffle
//Array to ArrayList
//}

//search on internet
public void shuffling() {
  // Shuffle the deck 10 times
  for (int i = 0; i < 10; i++) {
      // Generate two random indices
      int index1 = (int) (Math.random() * cards.size());
      int index2 = (int) (Math.random() * cards.size());
      // Swap the cards at the two indices
      Collections.swap(cards, index1, index2);
  }
}


  public void withdraw(int numberOfCard) {
    // get random number (0-53)
    for (int i = 0; i < numberOfCard; i++) {
      int index = 50; // TBC
      this.cards.remove(index);
    }
  }

  @Override
  public String toString() {
    String result = "";
    for (Card s : this.cards) {
      result += String.format("[CardNumber:%s, CardSuit:%s]", s.number, s.suit);
      result += "\n";
    }
    return result;
  }

  public static void main(String[] args) {
    Deck deck = new Deck();
    System.out.println("Before shuffling:");
        //System.out.println(deck.getCards());
        deck.shuffling();
        System.out.println("After shuffling:");
        //System.out.println(deck.getCards());
    // Withdraw 1 card
    deck.withdraw(1);
    System.out.println(deck.toString());
    //System.out.println(deck.cards.get(50).getNumber().name());
    //System.out.println(deck.cards.get(50).getSuit().name());
    // deck -> 54 cards
  }
/*
 * 
 * 
 * 
 * 
 * 
 * 
 */
