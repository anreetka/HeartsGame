/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class Game {

    private final String name;//the title of the game
    private static ArrayList<Player> players = new ArrayList<Player>();
	private GroupOfCards cards;
	private ScoreKeeper scoreKeeper;// the players of the game
    
    private static final int NUM_PLAYERS = 4;
    
    public Game(String name) {
        this.name = name;
    }
    
        public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome to Hearts!");
        

        
        for(int i = 0; i < NUM_PLAYERS; i++){
            System.out.print("Enter player "+ (i +1)+ " name: ");
            String playerNameOne = scanner.nextLine();
            Player playerOne= new Player(playerNameOne);
            
            players.add(playerOne);
   
        }
        
        Game game = new Game("Hearts");
        game.startGame();
        
        
    }
        
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the players of this game
     */
    public static ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    
    

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public void startGame(){
        
        Scanner scanner = new Scanner(System.in);
        dealCards(players);   
        System.out.println();
        System.out.println("Dealing cards...");
        getPlayers();
        
        System.out.println("Game started!");
        
        boolean heartsBroken = false;
        boolean gameOver = true;
        System.out.println();
        while(!isGameFinished(players)&& gameOver){
            for(Player player: players){
                System.out.println("-------------------------");
                player.displayHand();
                System.out.println(player.getName() + " enter a card to play: ");
                String cardInput = scanner.nextLine();
                Card card = findCardInHand(player, cardInput);
                while(card == null || (!heartsBroken && card.getSuit().equals("Hearts"))){
                    if(card == null){
                        System.out.println("Invalid card. Try again.");
                    }else{
                        System.out.println("Hearts have not been broken yet.");
                        player.setScore(card.getRank());
                    }
                    
                    System.out.print(player.getName() + ", enter a card to play:  ");
                    cardInput = scanner.nextLine();
                    card = findCardInHand(player, cardInput);
                }
                
                if(!cardInput.equals("Hearts")){
                    player.setScore(getPenaltyPoints(player) - card.getRank());
                }
                player.removeCardFromHand(card);
                System.out.println(player.getName()+" played: " + card);
                if(card.getSuit().equals("Hearts")){
                    heartsBroken = true;
                }
                
                Player nextPlayer = getNextPlayer(players, player);
                System.out.println(nextPlayer.getName()+ " 's turn...");
                System.out.println("--------------------------------------");

                    
            for(Player aPlayer :players){
                aPlayer.displayHand();   
             }
            
            heartsBroken = false; 
            
        }
            declareWinner();   
            for(Player aPlayer: players){
                int numOfHearts = 0;
                for(int i = 0; i< aPlayer.getHand().size(); i++){
                   if(aPlayer.getHand().get(i).getSuit() == "Hearts"){
                     numOfHearts++;
                    }
                }
                
                if(numOfHearts == aPlayer.getHand().size()){
                    System.out.println(aPlayer.getName() + " has been declared officially lost the play.");
                    gameOver = false;
                } 
            }       
        } 
        
        playRound();
        
    }
    
    public static void dealCards(ArrayList<Player> players) {
        GroupOfCards cards = new GroupOfCards();
        cards.shuffle();
        for(int i = 0; i < 5; i++){
            System.out.println("Player "+ (i+1) + " cards: ");
            for(Player player: players){                
                Card card  = cards.drawCard();
                System.out.println(card.toString()+ " ");
                player.addCardToHand(card);
                }
        }
    }

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public static Player declareWinner(){
        CalculateScore();
        int playerOnePoints = players.get(0).getScore();
        int playerTwoPoints = players.get(1).getScore();
        int playerThreePoints = players.get(2).getScore();
        int playerFourPoints = players.get(3).getScore();
        
        Player gameWinner = getGameWinner(players);
        System.out.println("Overall winner: "+ gameWinner.getName() + " with the least penalty points!");
        
        return gameWinner;
               
    }
    
    public static void CalculateScore(){
        for(Player player:players){
            int penaltyPoints = getPenaltyPoints(player);
            player.setScore(penaltyPoints);
            System.out.println(player.getName() + " 's penalty points " + penaltyPoints);
        }
    }
    
    private static Card findCardInHand(Player player, String cardInput){
        for(Card card : player.getHand()){
            if(card.toString().equalsIgnoreCase(cardInput)){
                return card;
            }    
    }
        return null;
}
    
    
    public static Player getNextPlayer(ArrayList<Player> players, Player currentPlayer){
        int currentIndex = -1;
        for(int i = 0; i < 4; i++){
            if(players.get(i) == currentPlayer){
                currentIndex = i;
                break;
            }
        }
        
        if(currentIndex == -1){
            throw new IllegalStateException("Cureent Player not found in the players array.");
        }
        int nextIndex = (currentIndex + 1)%4;
        
        return players.get(nextIndex);        
    }
    
    private static int getPenaltyPoints(Player player){
        int penaltyPoints = 0;
        for(Card card: player.getHand()){
            if(card.getSuit().equals("Hearts")){
                penaltyPoints = penaltyPoints + card.getRank();
            }else if(card.toString().equals("Q of Spades")){
                penaltyPoints += 13;
            }
        }
        
        return penaltyPoints;
        
    }
    
    private static boolean isGameFinished(ArrayList<Player> players){
        for(Player player: players){
            if(!player.getHand().isEmpty()){
                return false;
            }                     
        }
        
        return true;
    }
    
    private static Player getGameWinner (ArrayList<Player> players){
        Player gameWinner = players.get(0);    
        for(int i = 1; i<NUM_PLAYERS; i++){
            if(getPenaltyPoints(gameWinner) > getPenaltyPoints(players.get(i))){
                gameWinner = players.get(i);
            }
        }        
        return gameWinner;
    }
    
    
    public static void playRound(){
        System.out.println("Would you like to play next round? y/n");
        Scanner sc = new Scanner(System.in);
        char input = sc.next().charAt(0);
        
        if(input == 'y'){
            resetPenaltyPoints();
            Game game = new Game("hearts");
            game.startGame();
        }else if(input =='n'){
            System.out.println("Thanks for playing."); 
        }
        
    }
    
    
    public static int resetPenaltyPoints(){
        int points = 0;
        for(Player player: players){
            player.setScore(0);
        }
        return points;
    }
    
    
 
    
}
