package me.lebot.tennis.test;

import me.lebot.tennis.main.Player;
import me.lebot.tennis.main.ScoreType;
import me.lebot.tennis.main.TennisSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by axell on 04/05/2017.
 */
public class TennisSetTest {
    Player player1;
    Player player2;
    TennisSet tennisSet;

    @Before
    public void setUp() throws Exception {
        player1 = new Player("Axel");
        player2 = new Player("Nicolas");
        tennisSet = new TennisSet(player1, player2);
    }

    @Test
    public void testPointForPlayer() throws Exception {
        tennisSet.givePointToPlayer(player1);//15
        assertEquals(ScoreType.FIFTEEN, tennisSet.getCurrentGame().getScorePlayer1());
        tennisSet.givePointToPlayer(player1);//30
        tennisSet.givePointToPlayer(player1);//40
        tennisSet.givePointToPlayer(player1);//win
        tennisSet.givePointToPlayer(player1);//15 set 2
        assertEquals(tennisSet.getScorePlayer1(), 1);
    }

    @Test
    public void testWinner() throws Exception {
        tennisSet.givePointToPlayer(player1);//15
        tennisSet.givePointToPlayer(player1);//30
        tennisSet.givePointToPlayer(player1);//40
        tennisSet.givePointToPlayer(player1);//win
        tennisSet.givePointToPlayer(player1);//15 set 2
        tennisSet.givePointToPlayer(player1);//30
        tennisSet.givePointToPlayer(player1);//40
        tennisSet.givePointToPlayer(player1);//win
        tennisSet.givePointToPlayer(player1);//15 set 3
        tennisSet.givePointToPlayer(player1);//30
        tennisSet.givePointToPlayer(player1);//40
        tennisSet.givePointToPlayer(player1);//win
        tennisSet.givePointToPlayer(player1);//15 set 4
        tennisSet.givePointToPlayer(player1);//30
        tennisSet.givePointToPlayer(player1);//40
        tennisSet.givePointToPlayer(player1);//win
        tennisSet.givePointToPlayer(player1);//15 set 5
        tennisSet.givePointToPlayer(player1);//30
        tennisSet.givePointToPlayer(player1);//40
        tennisSet.givePointToPlayer(player1);//win
        tennisSet.givePointToPlayer(player1);//15 set 6
        tennisSet.givePointToPlayer(player1);//30
        tennisSet.givePointToPlayer(player1);//40
        tennisSet.givePointToPlayer(player1);//win
        tennisSet.givePointToPlayer(player1);//15 set 2
        assertEquals(player1, tennisSet.winner());
    }

    @Test
    public void testIsEnd() throws Exception {
        tennisSet.givePointToPlayer(player1);//15
        tennisSet.givePointToPlayer(player1);//30
        tennisSet.givePointToPlayer(player1);//40
        tennisSet.givePointToPlayer(player1);//win
        tennisSet.givePointToPlayer(player1);//15 set 2
        tennisSet.givePointToPlayer(player1);//30
        tennisSet.givePointToPlayer(player1);//40
        tennisSet.givePointToPlayer(player1);//win
        tennisSet.givePointToPlayer(player1);//15 set 3
        tennisSet.givePointToPlayer(player1);//30
        tennisSet.givePointToPlayer(player1);//40
        tennisSet.givePointToPlayer(player1);//win
        tennisSet.givePointToPlayer(player1);//15 set 4
        tennisSet.givePointToPlayer(player1);//30
        tennisSet.givePointToPlayer(player1);//40
        tennisSet.givePointToPlayer(player1);//win
        tennisSet.givePointToPlayer(player1);//15 set 5
        tennisSet.givePointToPlayer(player1);//30
        tennisSet.givePointToPlayer(player1);//40
        tennisSet.givePointToPlayer(player1);//win
        tennisSet.givePointToPlayer(player1);//15 set 6
        tennisSet.givePointToPlayer(player1);//30
        tennisSet.givePointToPlayer(player1);//40
        tennisSet.givePointToPlayer(player1);//win
        tennisSet.givePointToPlayer(player1);//15 set 2
        assertEquals(true, tennisSet.isFinished());
    }
}
