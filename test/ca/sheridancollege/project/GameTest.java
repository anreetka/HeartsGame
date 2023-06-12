package ca.sheridancollege.project;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author anree
 */
public class GameTest {
    
    private static Game game;
    
    private static ArrayList<Player> players = new ArrayList<>();;
    
    public GameTest() {
       
    }

    @BeforeClass
    public static void setUp() {
       game = new Game("Hearts");
       Player playerOne = new Player("Player 1");
       Player playerTwo = new Player("Player 2");
       Player playerThree = new Player("Player 3");
       Player playerFour = new Player("Player 4");

       players.add(playerOne);
       players.add(playerTwo);
       players.add(playerThree);
       players.add(playerFour); 
       System.out.println(playerOne);
       System.out.println(playerTwo);
       
       game.setPlayers(players);
    }

    
    @Test
    public void testDeclareWinnerGood() {
        System.out.println("declareWinnerGood");
        players.get(0).setScore(2);
        players.get(1).setScore(5);
        Player expected = players.get(0);
        Player actual = game.declareWinner();
        assertTrue(expected == actual);
    }

    
    @Test
    public void testDeclareWinnerBad() {
        System.out.println("declareWinnerBad");
        players.get(0).setScore(2);
        players.get(1).setScore(5);
        Player expected = players.get(0);
        Player actual = game.declareWinner();
        assertEquals(expected, actual);
    }


    @Test
    public void testGetNameGood() {
        System.out.println("getNameGood");
        String expected = players.get(0).getName();
        System.out.println(players.get(0).getName());
        String actual = game.getPlayers().get(0).getName();
        assertEquals(expected, actual);
    }

    
    @Test
    public void testGetNameBad() {
        System.out.println("getNameBad");
        String expected = players.get(1).getName();
        String actual = game.getPlayers().get(0).getName();
        assertTrue(expected != actual);
    }


    @Test
    public void testGetPlayerGood() {
        System.out.println("getPlayerGood");
        Player expected = players.get(0);
        Player actual = game.getPlayers().get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPlayerBad() {
        System.out.println("getPlayerBad");
        Player expected = players.get(1);
        Player actual = game.getPlayers().get(0);
        assertTrue(expected != actual);
    }
}
