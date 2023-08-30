import java.util.ArrayList;

public class CardsDeck {

    private final ArrayList<Card> cards = new ArrayList<>();

    CardsDeck() {
        for (int i = 1; i <= 12; i++) {
            String[] naipes = new String[]{"♠", "♥", "♣", "♦"};
            for (String naipe : naipes) {
                cards.add(new Card(i, naipe));
            }
        }
    }

    Card getRandomCard() {
        int randomCardIndex = (int) (Math.random() * cards.size());
        Card card = cards.get(randomCardIndex);
        cards.remove(randomCardIndex);
        return card;
    }

}
