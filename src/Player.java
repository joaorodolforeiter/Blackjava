import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private final String name;
    private final ArrayList<Card> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    void addCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        int score = 0;
        for (Card card : this.cards) {
            score += card.getGameValue();
        }
        if (score > 21) {
            score = 0;
            for (Card card : this.cards) {
                if (card.getGameValue() == 11) {
                    score += 1;
                } else {
                    score += card.getGameValue();
                }
            }
        }
        return score;
    }

    public boolean isBusted() {
        return this.getScore() > 21;
    }

    @Override
    public String toString() {
        return String.format("%10s - %2d pontos %s", this.name(), this.getScore(), this.cards());
    }

    public String name() {
        return name;
    }

    public ArrayList<Card> cards() {
        return cards;
    }


}
