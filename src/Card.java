public class Card {

    private final int value;
    private final String naipe;

    public Card(int valor, String naipe) {
        this.value = valor;
        this.naipe = naipe;
    }

    public int getGameValue() {
        if (this.value == 1) return 11;
        return Math.min(this.value, 10);
    }

    public String toString() {
        return this.value + this.naipe;
    }

}
