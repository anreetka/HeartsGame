/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;  
    private int size;//the size of the grouping
    private String rank;
    private String suit;
    String[] RANKS = {"2", "3","4","5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    
    public GroupOfCards(){
          
        Card card = new Card(rank, suit);
        cards = card.createDeck();
                      
    }
    

    public GroupOfCards(int size) {
        this.size = size;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        return cards.isEmpty();
    }

	/**
	 * 
	 * @param player
	 */

    
        
        
        public Card drawCard(){
                Random random = new Random();
                Card card = new Card(RANKS[random.nextInt(12)+1], SUITS[random.nextInt(3)]);
                return card;
 

            
  
        }

}//end class
