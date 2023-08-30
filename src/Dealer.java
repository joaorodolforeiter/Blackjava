public class Dealer extends Player {

    private final CardsDeck cardsDeck = new CardsDeck();

    public Dealer(String name) {
        super(name);
    }

    Card giveCard() {
        return cardsDeck.getRandomCard();
    }

}
