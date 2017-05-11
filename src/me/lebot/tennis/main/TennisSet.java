package me.lebot.tennis.main;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by axell on 04/05/2017.
 */
public class TennisSet {
    private Player player1;
    private Player player2;
    private int scorePlayer1;
    private int scorePlayer2;
    private List<TennisGame> gameList;
    private int currentGame;
    private boolean isFinished;

    /**
     * Constructor
     *
     * @param player1 the first {@code Player}
     * @param player2 the second {@code Player}
     */
    public TennisSet(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
        this.currentGame = 0;
        this.isFinished = false;
        this.gameList = new LinkedList<>();
        this.gameList.add(new TennisGame(player1, player2));
    }

    /**
     * Create new {@Code TennisGame}
     */
    private void newGame() {
        gameList.add(new TennisGame(player1, player2));
        currentGame++;
    }

    /**
     * Give Point to Player
     *
     * @param player the {@code Player} to give a point
     */
    public void givePointToPlayer(Player player) {
        if (gameList.get(currentGame).isFinished()) {
            if (player1 == gameList.get(currentGame).winner()) {
                scorePlayer1++;
            } else {
                scorePlayer2++;
            }
            if (!endSet()) {
                newGame();
                gameList.get(currentGame).givePointToPlayer(player);
            }
        } else {
            gameList.get(currentGame).givePointToPlayer(player);
        }

    }

    /**
     * Check endSet
     *
     * @return
     */
    private boolean endSet() {
        if (scorePlayer1 == 6 || scorePlayer2 == 6) {
            isFinished = true;
            return true;
        }
        return false;
    }

    /**
     * Get the winner of the game
     *
     * @return the {@code Player} who won
     */
    public Player winner() {
        return (scorePlayer1 > scorePlayer2) ? player1 : player2;
    }


    /**
     * Get the score of the player 1
     *
     * @return score {@code int} of the [@code Player} 1
     */
    public int getScorePlayer1() {
        return scorePlayer1;
    }

    /**
     * Get the score of the player 2
     *
     * @return score {@code int} of the [@code Player} 2
     */
    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public TennisGame getCurrentGame() {
        return gameList.get(currentGame);
    }

    /**
     * Is {@code TennisSet} finished
     *
     * @return boolean {@code true} if ended, {@code false} otherwise
     */
    public boolean isFinished() {
        return isFinished;
    }
}