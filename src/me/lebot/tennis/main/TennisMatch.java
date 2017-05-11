package me.lebot.tennis.main;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by axell on 04/05/2017.
 */
public class TennisMatch {

    private Player player1;
    private Player player2;
    private MatchType matchType;
    private boolean tieBreakInLastSet;
    private List<TennisSet> setList = new LinkedList<>();

    /**
     * Index of the current Set
     */
    private int currentSet = 0;
    private boolean isFinished = false;

    /**
     * @param player1           the first {@code Player}
     * @param player2           the second {@code Player}
     * @param matchType         type of the {@code TennisMatch}
     * @param tieBreakInLastSet
     */
    public TennisMatch(Player player1, Player player2, MatchType matchType, boolean tieBreakInLastSet) {
        this.player1 = player1;
        this.player2 = player2;
        this.matchType = matchType;
        this.tieBreakInLastSet = tieBreakInLastSet;
        setList.add(new TennisSet(player1, player2));
    }


    /**
     * Give Point to Player
     *
     * @param player the {@code Player} to give a point
     */
    public void givePointToPlayer(Player player) {
        if (!this.isFinished()) {
            setList.get(currentSet).givePointToPlayer(player);
            if (setList.get(currentSet).isFinished()) {
                if (matchType == MatchType.BEST_OF_THREE && currentSet == 3 || matchType == MatchType.BEST_OF_FIVE && currentSet == 5) {
                    isFinished = true;
                } else {
                    newSet();
                }
            }
        }
    }

    /**
     * Create new {@Code TennisSet}
     */
    private void newSet() {
        setList.add(new TennisSet(player1, player2));
        currentSet++;
    }

    public String getScoreForPlayer(Player player) {
        ScoreType score;
        if (player == player1) {
            score = setList.get(currentSet).getCurrentGame().getScorePlayer1();
        } else {
            score = setList.get(currentSet).getCurrentGame().getScorePlayer2();
        }
        return score.toString();
    }

    public int gamesInCurrentSetForPlayer(Player player) {
        if (player == player1) {
            return setList.get(currentSet).getScorePlayer1();
        } else {
            return setList.get(currentSet).getScorePlayer2();
        }
    }

    public int getPlayerScoreFromSet(int setNumber, Player player) {
        if (player == player1) {
            return setList.get(setNumber - 1).getScorePlayer1();
        } else {
            return setList.get(setNumber - 1).getScorePlayer2();
        }
    }

    /**
     * Is {@code TennisSet} isFinished
     *
     * @return boolean {@code true} if ended, {@code false} otherwise
     */
    public boolean isFinished() {
        return isFinished;
    }
}
