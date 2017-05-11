package me.lebot.tennis.main;

/**
 * Created by axell on 04/05/2017.
 */
public enum ScoreType {
    /**
     * 0,15,30,40 and 100 for A
     */
    LOVE(0) {
        @Override
        public ScoreType previous() {
            return null; // see below for options for this line
        }
    },
    FIFTEEN(15),
    THIRTY(30),
    FOURTY(40),
    AVANTAGE(100) {
        @Override
        public ScoreType next() {
            return null; // see below for options for this line
        }
    };

    private final int score;

    private ScoreType(int score) {
        this.score = score;
    }

    public ScoreType previous() {
        // No bounds checking required here, because the last instance overrides
        return values()[ordinal() - 1];
    }

    public ScoreType next() {
        // No bounds checking required here, because the last instance overrides
        return values()[ordinal() + 1];
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        if (this.equals(ScoreType.AVANTAGE)) {
            return "A";
        } else {
            return "" + score;
        }
    }
}
