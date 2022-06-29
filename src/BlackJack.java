import domain.Deck;

import java.util.Scanner;

import static domain.Deck.standard52;

public class BlackJack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deck deck = new Deck(standard52());
        PlayerHand player1 = new PlayerHand();
        PlayerHand dealer = new PlayerHand();

        deck.shuffle();
        player1.takesFrom(deck);

        do {
            player1.takesFrom(deck);
            System.out.println("player = " + player1);
            System.out.printf("scores = %s, one more(y/n): ", player1.getSum());
            if (player1.getSum() > 21) {
                System.out.println("\nplayer loses");
                return;
            }
        } while (scanner.next().equalsIgnoreCase("y"));

        dealer.takesFrom(deck);
        do {
            dealer.takesFrom(deck);
            System.out.println("dealer = " + dealer);
            System.out.println("scores = " + dealer.getSum());
        } while (dealer.getSum() < 15);

        if (player1.getSum() <= 21 && dealer.getSum() > 21) {
            System.out.println("player wins");
        } else if (player1.getSum() > dealer.getSum() && player1.getSum() <= 21 && dealer.getSum() <= 21) {
            System.out.println("player wins");
        } else {
            System.out.println("dealer wins");
        }
    }
}
