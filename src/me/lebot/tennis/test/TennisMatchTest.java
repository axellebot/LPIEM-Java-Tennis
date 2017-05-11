package me.lebot.tennis.test;

import me.lebot.tennis.main.MatchType;
import me.lebot.tennis.main.Player;
import me.lebot.tennis.main.ScoreType;
import me.lebot.tennis.main.TennisMatch;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by axell on 05/05/2017.
 */
public class TennisMatchTest {
    private Player player1;
    private Player player2;
    private TennisMatch tennisMatch;

    @Before
    public void setUp() throws Exception {
        player1 = new Player("Axel");
        player2 = new Player("Nicolas");
        tennisMatch = new TennisMatch(player1, player2, MatchType.BEST_OF_THREE, true);
    }

    @Test
    public void testUpdateWithPointWonBy() {
        assertEquals(tennisMatch.getScoreForPlayer(player1), ScoreType.LOVE.toString());
        tennisMatch.givePointToPlayer(player1);//15
        assertEquals(tennisMatch.getScoreForPlayer(player1), ScoreType.FIFTEEN.toString());
        tennisMatch.givePointToPlayer(player1);//30
        assertEquals(tennisMatch.getScoreForPlayer(player1), ScoreType.THIRTY.toString());
        tennisMatch.givePointToPlayer(player1);//40
        assertEquals(tennisMatch.getScoreForPlayer(player1), ScoreType.FOURTY.toString());
        tennisMatch.givePointToPlayer(player1);//Avantage
        assertEquals(tennisMatch.getScoreForPlayer(player1), ScoreType.AVANTAGE.toString());
    }

    @Test
    public void testPointsForPlayer() {
        tennisMatch.getScoreForPlayer(player1);
    }

    @Test
    public void testGetPlayerScoreFromSet(){

    }
}
