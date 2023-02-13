package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class GroupOfCards {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();

        System.out.println("Enter the name of the game: ");
        String gameName = input.nextLine();
        Game game = new Game(gameName) {
            @Override
            public void play() {
                System.out.println("The game is starting!");
            }

            @Override
            public void declareWinner() {
                System.out.println("The winner is " + players.get(0).getPlayerName());
            }
        };

        System.out.println("Enter the number of players: ");
        int numOfPlayers = input.nextInt();

        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Enter player " + (i + 1) + " name: ");
            String playerName = input.next();
            Player player = new Player(playerName) {
                @Override
                public void play() {
                    System.out.println();
                }
            };
            players.add(player);
        }

        game.setPlayers(players);
        game.play();
        game.declareWinner();
    }
}
