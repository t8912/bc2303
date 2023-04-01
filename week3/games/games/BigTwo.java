package week3.games.games;

import week3.games.poker.model.Player;

public class BigTwo {

  public static void main(String[] args) {
    Player playerA = new Player();
    Player playerB = new Player();
  }
  
}
 
/*
 * import java.util.*;

import javax.smartcardio.Card;
import java.util.Comparator;

import week3.games.poker.enums.CardNumber;
import week3.games.poker.enums.CardSuit;

//import javax.smartcardio.Card;

import week3.games.poker.model.Deck;
import week3.games.poker.model.DisCardPile;
import week3.games.poker.model.Player;


 public class BigTwo {
     private final int NUM_PLAYERS = 2;
     private final Player[] players;
     private final Deck deck;
     private final DisCardPile discardPile;
     private Player currentPlayer;
     private List<CardSuit> currentCards;
 
     public BigTwo() {
         players = new Player[NUM_PLAYERS];
         for (int i = 0; i < NUM_PLAYERS; i++) {
             players[i] = new Player("Player " + (i + 1));
         }
         deck = new Deck();
         discardPile = new DisCardPile();
         currentPlayer = players[0];
         currentCards = new ArrayList<>();
     }
 
     public void dealCards() {
         deck.shuffle();
         for (int i = 0; i < deck.size(); i++) {
             players[i % NUM_PLAYERS].addCard(deck.draw());
         }
         for (Player player : players) {
             player.getHand().sort(Comparator.comparing(Card::getNumber));
         }
     }
 
     public void playGame() {
         dealCards();
         while (!isGameOver()) {
             System.out.println("Current player: " + currentPlayer.getName());
             System.out.println("Current hand: " + currentPlayer.getHand());
             System.out.println("Current cards: " + currentCards);
 
             List<CardSuit> play = currentPlayer.play(currentCards);
             if (play == null) {
                 System.out.println("Invalid move, try again.");
                 continue;
             }
 
             currentCards = play;
             currentPlayer.removeCard(null); //
             discardPile.addCards(null); //
 
             if (currentPlayer.getHand().isEmpty()) {
                 System.out.println(currentPlayer.getName() + " wins!");
                 break;
             }
 
             nextPlayer();
         }
     }
 
     private boolean isGameOver() {
         for (Player player : players) {
             if (player.getHand().isEmpty()) {
                 return true;
             }
         }
         return false;
     }
 
     private void nextPlayer() {
         int idx = Arrays.asList(players).indexOf(currentPlayer);
         currentPlayer = players[(idx + 1) % NUM_PLAYERS];
     }
 
     public static void main(String[] args) {
         BigTwo game = new BigTwo();
         game.playGame();
     }
 }

 */
