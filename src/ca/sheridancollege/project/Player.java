/**

SYST 17796 Project Base code.
Students can modify and extend to implement their game.
Add your name as an author and the date!
*/
package ca.sheridancollege.project;
/**

A class that represents a player in the game. Each player has a unique name.

@author dancye

@author Paul Bonenfant Jan 2020
*/
public abstract class Player {

private String playerName; // the unique name for this player

/**

Constructor for the Player class that sets the player's name
@param playerName the unique name for this player
*/
public Player(String playerName) {
this.playerName = playerName;
}
/**

Getter for the player's name
@return the player's name
*/
public String getPlayerName() {
return playerName;
}
/**

Setter for the player's name
@param playerName the player's name to set
*/
public void setPlayerName(String playerName) {
this.playerName = playerName;
}
/**

A method that represents the logic for the player to make a move in the game.
To be implemented in concrete subclasses.
*/
public abstract void play();
}