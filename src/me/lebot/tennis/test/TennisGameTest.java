package me.lebot.tennis.test;

import me.lebot.tennis.main.Player;
import me.lebot.tennis.main.ScoreType;
import me.lebot.tennis.main.TennisGame;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by axell on 04/05/2017.
 */
public class TennisGameTest {
    Player player1;
    Player player2;
    TennisGame game;

    @Before
    public void setUp() throws Exception {
        player1 = new Player("Axel");
        player2 = new Player("Nicolas");
        game = new TennisGame(player1, player2);
    }

    @Test
    public void testGivePointToPlayer() throws Exception {
        game.givePointToPlayer(player1); //15
        assertEquals(game.getScorePlayer1(), ScoreType.FIFTEEN);
        assertEquals(game.getScorePlayer2(), ScoreType.LOVE);
        game.givePointToPlayer(player2); //15
        assertEquals(game.getScorePlayer1(), ScoreType.FIFTEEN);
        assertEquals(game.getScorePlayer2(), ScoreType.FIFTEEN);
        game.givePointToPlayer(player2); //30
        assertEquals(game.getScorePlayer1(), ScoreType.FIFTEEN);
        assertEquals(game.getScorePlayer2(), ScoreType.THIRTY);
    }

    @Test
    public void testIsFinished() throws Exception {
        game.givePointToPlayer(player1);//15
        game.givePointToPlayer(player1);//30
        game.givePointToPlayer(player1);//40
        game.givePointToPlayer(player1);//win
        assertEquals(game.isFinished(), true);
    }

    @Test
    public void testWinner() throws Exception {
        assertEquals(null, game.winner());
        game.givePointToPlayer(player1);//15
        game.givePointToPlayer(player1);//30
        assertEquals(null, game.winner());
        game.givePointToPlayer(player1);//40
        game.givePointToPlayer(player1);//win
        assertEquals(player1, game.winner());
    }
}