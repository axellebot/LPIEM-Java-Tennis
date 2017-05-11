package me.lebot.tennis.main;

/**
 * Created by axell on 04/05/2017.
 */
public class TennisGame {

    private Player player1;
    private Player player2;
    private ScoreType scorePlayer1;
    private ScoreType scorePlayer2;
    private boolean isFinished;

    /**
     * Constructor
     *
     * @param player1 the first {@code Player}
     * @param player2 the second {@code Player}
     */
    public TennisGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scorePlayer1 = ScoreType.LOVE;
        this.scorePlayer2 = ScoreType.LOVE;
        this.isFinished = false;
    }

    /**
     * Get the score of the player 1
     *
     * @return {@code ScoreType}
     */
    public ScoreType getScorePlayer1() {
        return scorePlayer1;
    }

    /**
     * Get the score of the player 2
     *
     * @return {@code ScoreType}
     */
    public ScoreType getScorePlayer2() {
        return scorePlayer2;
    }

    /**
     * Is {@code TennisGame} finished
     *
     * @return boolean {@code true} if ended, {@code false} otherwise
     */
    public boolean isFinished() {
        return isFinished;
    }

    /**
     * Get the winner of the game
     *
     * @return the {@code Player} who won
     */
    public Player winner() {
        if (scorePlayer1 == ScoreType.AVANTAGE && isFinished()) {
            return player1;
        } else if (scorePlayer2 == ScoreType.AVANTAGE && isFinished()) {
            return player2;
        } else {
            return null;
        }
    }

    /**
     * Give Point to Player
     *
     * @param player the {@code Player} to give a point
     */
    public void givePointToPlayer(Player player) {
        if (player == player1) {
            givePointToPlayer1();
        } else if (player == player2) {
            givePointToPlayer2();
        }
    }

    /**
     * Give point to {@code Player} 1
     */
    private void givePointToPlayer1() {
        switch (scorePlayer1) {
            case LOVE:
            case FIFTEEN:
            case THIRTY:
                scorePlayer1 = scorePlayer1.next();
                break;
            case FOURTY:
                if (scorePlayer2.getScore() < ScoreType.FOURTY.getScore()) {
                    isFinished = true;
                    scorePlayer1 = scorePlayer1.next();
                } else if (scorePlayer2 == ScoreType.FOURTY) {
                    scorePlayer1 = scorePlayer1.next();
                } else {
                    scorePlayer2 = ScoreType.FOURTY;
                    scorePlayer1 = ScoreType.FOURTY;
                }
                break;
            case AVANTAGE:
                isFinished = true;
                break;
        }
    }

    /**
     * Give point to {@code Player} 2
     */
    private void givePointToPlayer2() {
        switch (scorePlayer2) {
            case LOVE:
            case FIFTEEN:
            case THIRTY:
                scorePlayer2 = scorePlayer2.next();
                break;
            case FOURTY:
                if (scorePlayer1.getScore() < ScoreType.FOURTY.getScore()) {
                    isFinished = true;
                    scorePlayer2 = scorePlayer2.next();
                } else if (scorePlayer1 == ScoreType.FOURTY) {
                    scorePlayer2 = scorePlayer2.next();
                } else {
                    scorePlayer1 = ScoreType.FOURTY;
                    scorePlayer2 = ScoreType.FOURTY;
                }
                break;
            case AVANTAGE:
                isFinished = true;
                break;
        }
    }

}