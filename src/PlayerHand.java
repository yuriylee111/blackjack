import domain.Card;
import domain.Deck;
import domain.Rank;

import java.util.ArrayList;
import java.util.List;

public class PlayerHand {
    private final List<Card> cards = new ArrayList<>();

    public void takesFrom(Deck deck) {
        cards.add(deck.draw());
    }

    public int getSum() {
        return sumOfAces(sumWithoutAces());
    }

    private int sumOfAces(int sum) {
        for (Card card : cards) {
            if (card.getRank() == Rank.ACE && sum < 11) {
                sum += 11;
            } else if (card.getRank() == Rank.ACE && sum >= 11) {
                sum += 1;
            }
        }
        return sum;
    }

    private int sumWithoutAces() {
        int sum = 0;
        for (Card card : cards) {
            if (card.getRank() == Rank.ACE) continue;
            switch (card.getRank()) {
                case DEUCE:
                    sum += 2;
                    break;
                case THREE:
                    sum += 3;
                    break;
                case FOUR:
                    sum += 4;
                    break;
                case FIVE:
                    sum += 5;
                    break;
                case SIX:
                    sum += 6;
                    break;
                case SEVEN:
                    sum += 7;
                    break;
                case EIGHT:
                    sum += 8;
                    break;
                case NINE:
                    sum += 9;
                    break;
                case TEN:
                case JACK:
                case QUEEN:
                case KING:
                    sum += 10;
                    break;
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
