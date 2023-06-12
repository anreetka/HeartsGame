/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class Player {

    private String name;
    private int score = 0;
    private ArrayList<Card> hand = new ArrayList<>(); 

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public void addCardToHand(Card card){
        hand.add(card);
    }
    
    public void removeCardFromHand(Card card){
        hand.remove(card);
    }
       
    public ArrayList<Card> getHand(){
        return hand;
    }
    
    public void displayHand(){
        System.out.println("Current hand: ");
        for(int i = 0; i < hand.size(); i++){
            System.out.println((i+1) + ". " + hand.get(i));
        }
    }
    
    public void setScore(int newScore){
        newScore = score + newScore;
        this.score = newScore;
    }
    
    public int getScore(){
        return this.score;
    }
    


   
    /**
	 * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
	 * with logic to play your game.
	 */

//    public abstract void startGame();

	/**
	 * 
	 * @param 
	 */
 /*	public void playCard(Card card) {
		// TODO - implement Player.playCard
		throw new UnsupportedOperationException();
	}
*/
}
