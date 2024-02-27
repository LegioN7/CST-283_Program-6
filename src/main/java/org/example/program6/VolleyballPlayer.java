package org.example.program6;

// VolleyballPlayer Class
//     This class is the child class for all volleyball players
//     It will contain the following
//          Service aces per game
//          Kills per game

public class VolleyballPlayer extends Player {
    private int ServiceAcesPerGame;
    private int KillsPerGame;

    public VolleyballPlayer() {
        super();
        this.ServiceAcesPerGame = 0;
        this.KillsPerGame = 0;
    }

    /**
     * Parametrized Constructor
     *
     * @param ServiceAcesPerGame of the player
     * @param KillsPerGame       of the player
     */
    public VolleyballPlayer(char sport, String firstname, String lastname, int height, int weight, double gpa, int ServiceAcesPerGame, int KillsPerGame) {
        super(sport, firstname, lastname, height, weight, gpa);
        this.ServiceAcesPerGame = ServiceAcesPerGame;
        this.KillsPerGame = KillsPerGame;
    }

    /**
     * Get the player's service aces per game
     *
     * @return the player's service aces per game
     */
    public int getServiceAcesPerGame() {
        return ServiceAcesPerGame;
    }

    /**
     * Set the player's service aces per game
     *
     * @param ServiceAcesPerGame the player's service aces per game
     */
    public void setServiceAcesPerGame(int ServiceAcesPerGame) {
        this.ServiceAcesPerGame = ServiceAcesPerGame;
    }

    /**
     * Get the player's kills per game
     *
     * @return the player's kills per game
     */
    public int getKillsPerGame() {
        return KillsPerGame;
    }

    /**
     * Set the player's kills per game
     *
     * @param KillsPerGame the player's kills per game
     */
    public void setKillsPerGame(int KillsPerGame) {
        this.KillsPerGame = KillsPerGame;
    }

    /**
     * Check if the player is eligible to be a candidate
     *
     * @return true if the player is eligible to be a candidate, false otherwise
     */
    @Override
    public boolean isCandidate() {
        // Check if player meets GPA requirements
        if (meetsGPARequirements()) {
            return false;
        }

        // Implement the eligibility criteria for Volleyball players.
        // At least 70 inches tall, 6 service aces per game, and 9 kills per game
        return getHeight() >= 70 && getServiceAcesPerGame() >= 6 && getKillsPerGame() >= 9;
    }
}
