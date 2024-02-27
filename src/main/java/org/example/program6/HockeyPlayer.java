package org.example.program6;

// HockeyPlayer Class
//     This class is the child class for all hockey players
//     It will contain the following
//          Goals per game
//          Penalty minutes per season
//          Plus-minus number

public class HockeyPlayer extends Player {

    private int GoalsPerGame;
    private int PenaltyMinutesPerSeason;
    private int PlusMinusNumber;

    /**
     * No-arg constructor
     */
    public HockeyPlayer() {
        super();
        this.GoalsPerGame = 0;
        this.PenaltyMinutesPerSeason = 0;
        this.PlusMinusNumber = 0;
    }

    /**
     * Parametrized Constructor
     *
     * @param GoalsPerGame            of the player
     * @param PenaltyMinutesPerSeason of the player
     * @param PlusMinusNumber         of the player
     */
    public HockeyPlayer(char sport, String firstname, String lastname, int height, int weight, double gpa, int GoalsPerGame, int PenaltyMinutesPerSeason, int PlusMinusNumber) {
        super(sport, firstname, lastname, height, weight, gpa);
        this.GoalsPerGame = GoalsPerGame;
        this.PenaltyMinutesPerSeason = PenaltyMinutesPerSeason;
        this.PlusMinusNumber = PlusMinusNumber;
    }

    /**
     * Get the player's goals per game
     *
     * @return the player's goals per game
     */
    public int getGoalsPerGame() {
        return GoalsPerGame;
    }

    /**
     * Set the player's goals per game
     *
     * @param GoalsPerGame the player's goals per game
     */
    public void setGoalsPerGame(int GoalsPerGame) {
        this.GoalsPerGame = GoalsPerGame;
    }

    /**
     * Get the player's penalty minutes per season
     *
     * @return the player's penalty minutes per season
     */
    public int getPenaltyMinutesPerSeason() {
        return PenaltyMinutesPerSeason;
    }

    /**
     * Set the player's penalty minutes per season
     *
     * @param PenaltyMinutesPerSeason the player's penalty minutes per season
     */
    public void setPenaltyMinutesPerSeason(int PenaltyMinutesPerSeason) {
        this.PenaltyMinutesPerSeason = PenaltyMinutesPerSeason;
    }

    /**
     * Get the player's plus-minus number
     *
     * @return the player's plus-minus number
     */
    public int getPlusMinusNumber() {
        return PlusMinusNumber;
    }

    /**
     * Set the player's plus-minus number
     *
     * @param PlusMinusNumber the player's plus-minus number
     */
    public void setPlusMinusNumber(int PlusMinusNumber) {
        this.PlusMinusNumber = PlusMinusNumber;
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

        // Implement the eligibility criteria for hockey players.
        // At least less than 12 penalty minutes per season, and a plus-minus number greater than 8
        return getGoalsPerGame() >= 15 && getPenaltyMinutesPerSeason() < 12 && getPlusMinusNumber() > 8;
    }
}
