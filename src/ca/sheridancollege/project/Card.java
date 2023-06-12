/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public class Card{
    //default modifier for child classes

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    String[] ranks = {"2", "3","4","5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private final String rank;
    private final String suit;
    
        
    public Card(String rank, String suit){
        this.rank= rank;
        this.suit = suit;
    }

     
    
    public int getRank(){
        if(rank == "J"){
            return 11;
        }else if(rank == "Q"){
            return 12;
        }else if(rank == "K"){
            return 13;
        }else if(rank == "A"){
            return 1;
        }else{
            return Integer.parseInt(rank);
        }
    }
    
    public String getSuit(){
        return suit;
    }
    
    @Override
    public String toString(){
        return rank + " of " + suit;
    };

    public ArrayList<Card> createDeck(){   
        ArrayList<Card> deck = new ArrayList<>(52);
        for(String r: ranks){
            for(String s: suits){
                Card playerCard = new Card(r, s);
                deck.add(playerCard);
            }
        } 
        
        return deck;
        
    }
}
