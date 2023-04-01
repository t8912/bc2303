package week3.games.poker.model;

import java.util.ArrayList;
import java.util.List;

public class DisCardPile {
    private final List<Card> cards;

    public DisCardPile() {
        this.cards = new ArrayList<>();
    }

    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public void clear() {
        cards.clear();
    }

    public List<Card> getCards() {
        return cards;
    }
}
