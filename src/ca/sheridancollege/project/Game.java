/**

SYST 17796 Project Base code.
Students can modify and extend to implement their game.
Add your name as an author and the date!
*/
package ca.sheridancollege.project;
import java.util.ArrayList;

/**

The class that models your game. You should create a more specific child of this class and instantiate the methods

given.

@author dancye

@author Paul Bonenfant Jan 2020
*/
public abstract class Game {

private final String name;//the title of the game
private ArrayList<Player> players;// the players of the game

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

public Game(String name) {
this.name = name;
players = new ArrayList<>();
}

/**

@return the name of the game
*/
public String getName() {
return name;
}
/**

@return the players of the game
*/
public ArrayList<Player> getPlayers() {
return players;
}
/**

Add a player to the game
@param player the player to add
*/
public void addPlayer(Player player) {
players.add(player);
}
/**

Play the game. This might be one method or many method calls depending on your game.
*/
public abstract void play();
/**

When the game is over, use this method to declare and display the winning player.
*/
public abstract void declareWinner();
}//end class



