import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Blackjack blackjack = new Blackjack();

        String nomePlayer;
        int decisao, i = 1, decisaoGame;

        do {
            System.out.println("\n******** BlackJava ********");
            System.out.println("\nDeseja jogar?\n");
            System.out.println("1 - sim");
            System.out.println("0 - não");
            System.out.print("> ");
            decisaoGame = sc.nextInt();

            if (decisaoGame == 1) {
                do {
                    System.out.print("Informe o nome do " + i + "° jogador: ");
                    nomePlayer = sc.next();
                    Player player = new Player(nomePlayer);
                    blackjack.addPlayer(player);
                    System.out.println("\nAlguém mais vai jogar?\n");
                    System.out.println("1 - sim");
                    System.out.println("0 - não");
                    System.out.print("> ");
                    decisao = sc.nextInt();
                    i++;
                } while (decisao != 0);
                blackjack.startGame();

            }

        } while (decisaoGame != 0);

        System.out.println("Fim de JOGO!!!");
    }

}