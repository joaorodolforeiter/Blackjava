import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Blackjack {

    final Dealer dealer = new Dealer("dealer");
    final ArrayList<Player> players = new ArrayList<>();
    void addPlayer(Player player) {
        players.add(player);
    }

    void startGame() {

        Scanner sc = new Scanner(System.in);

        System.out.println("******** BlackJack ********");

        dealer.addCard(dealer.giveCard());

        for (Player player : players) {
            player.addCard(dealer.giveCard());
            player.addCard(dealer.giveCard());
        }

        System.out.println("\nDealer");
        System.out.println(dealer);
        System.out.println("\nPlayers em jogo");
        for (Player player : players) {
            System.out.println(player);
        }

        System.out.println();

        for (Player player : players) {
            int decisao = 1;
            while (decisao != 0 && player.getScore() < 21) {

                System.out.println(player.name() + " tem " + player.getScore() + " pontos " + player.cards());
                System.out.println(player.name() + " deseja mais uma carta? ");
                System.out.println("1 - sim");
                System.out.println("0 - não");
                System.out.print("> ");
                decisao = sc.nextInt();
                System.out.println();

                if (decisao == 1) {
                    Card newCard = dealer.giveCard();
                    System.out.println("Você recebeu a carta " + newCard);
                    player.addCard(newCard);
                }

                if (player.getScore() > 21) {
                    decisao = 0;
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Voce estourou, pobre\n");
                }
            }
        }

        while (dealer.getScore() < 17) {
            Card newCard = dealer.giveCard();
            dealer.addCard(newCard);
            System.out.println("A Casa recebeu a carta " + newCard);
            System.out.println("A Casa tem " + dealer.getScore() + " pontos " + dealer.cards());
            System.out.println();
        }

        if (dealer.isBusted()) {
            System.out.println("Todo mundo Ganhou");
        } else {
            for (Player player : getWinners()) {
                System.out.println(player);
            }
        }

    }

    public ArrayList<Player> getWinners() {
        players.add(dealer);
        int maxScore = Collections.max(players.stream().filter(player -> player.getScore() <= 21).toList(), Comparator.comparing(Player::getScore)).getScore();

        ArrayList<Player> winners = new ArrayList<>();

        for (Player player : players) {
            if (player.getScore() == maxScore) {
                winners.add(player);
            }
        }

        return winners;
    }


}
