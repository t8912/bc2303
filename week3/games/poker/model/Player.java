package week3.games.poker.model;

import java.util.ArrayList;
//import java.util.Comparator;
import java.util.List;

public class Player {


    private final String name;
    private final List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void removeCard(Card card) {
        hand.remove(card);
    }

    public boolean hasCard(Card card) {
        return hand.contains(card);
    }

    public boolean hasCards(List<Card> cards) {
        return hand.containsAll(cards);
    }

    public void clearHand() {
        hand.clear();
    }

    @Override
    public String toString() {
        return name;
    }
}


/*
 * import java.util.ArrayList;
import java.util.List;

public class Player {
  private final String name;
  private final List<Card> hand;

  public Player(String name) {
      this.name = name;
      hand = new ArrayList<>();
  }
  
  public String getName() {
      return name;
  }
  
  public void addCard(Card card) {
      hand.add(card);
  }
  
  public List<Card> getHand() {
      return hand;
  }
  
  public void clearHand() {
      hand.clear();
  }
}

 */



