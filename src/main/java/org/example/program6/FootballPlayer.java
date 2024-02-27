package org.example.program6;

// FootballPlayer Class
//     This class is the child class for all football players
//     It will contain the following
//          40-yard dash time
public class FootballPlayer extends Player {
    private double FortyYardDashTime;

    /**
     * No-arg constructor
     */
    public FootballPlayer() {
        super();
        this.FortyYardDashTime = 0;
    }

    /**
     * Parametrized Constructor
     *
     * @param FortyYardDashTime of the player
     */
    public FootballPlayer(char sport, String firstname, String lastname, int height, int weight, double gpa, double FortyYardDashTime) {
        super(sport, firstname, lastname, height, weight, gpa);
        this.FortyYardDashTime = FortyYardDashTime;
    }

    /**
     * Get the player's 40-yard dash time
     *
     * @return the player's 40-yard dash time
     */
    public double getFortyYardDashTime() {
        return FortyYardDashTime;
    }

    /**
     * Set the player's 40-yard dash time
     *
     * @param FortyYardDashTime the player's 40-yard dash time
     */
    public void setFortyYardDashTime(double FortyYardDashTime) {
        this.FortyYardDashTime = FortyYardDashTime;
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

        // Implement the eligibility criteria for football players.
        // At least 73 inches tall, at least 190 pounds, and a 40-yard dash time of less than 4.7 seconds
        return getHeight() > 73 && getWeight() > 190 && getFortyYardDashTime() < 4.7;
    }
}
