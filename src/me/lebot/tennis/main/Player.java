package me.lebot.tennis.main;

/**
 * Created by axell on 04/05/2017.
 */
public class Player {
    private String label;

    /**
     * Constructor
     *
     * @param label Name of the player
     */
    public Player(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Player{" +
                "label='" + label + '\'' +
                '}';
    }
}
