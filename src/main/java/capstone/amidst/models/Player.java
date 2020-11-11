package capstone.amidst.models;

import javax.validation.constraints.*;

public class Player {
    // Private Fields
    @PositiveOrZero(message = "Player ID must be 0 or higher.")
    private int playerId;

    @NotBlank(message = "Player name is required.")
    private String playerName;

    @NotNull(message = "Player must be either dead or alive.")
    private boolean isDead;

    @NotNull(message = "Player must be either an impostor or a crewmate.")
    private boolean isImpostor;

    @PositiveOrZero(message = "User ID must be 0 or higher.")
    private int appUserId;

    // Constructors
    public Player(int playerId, String playerName, boolean isDead, boolean isImpostor, int appUserId) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.isDead = isDead;
        this.isImpostor = isImpostor;
        this.appUserId = appUserId;
    }
    public Player() {}

    // Getters and Setters
    public int getPlayerId() {
        return playerId;
    }
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public boolean isDead() {
        return isDead;
    }
    public void setDead(boolean dead) {
        isDead = dead;
    }
    public boolean isImpostor() {
        return isImpostor;
    }
    public void setImpostor(boolean impostor) {
        isImpostor = impostor;
    }
    public int getAppUserId() {
        return appUserId;
    }
    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }
}