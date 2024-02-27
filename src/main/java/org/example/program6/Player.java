package org.example.program6;

/* Player Class
    This class is the parent class for all players
    It will contain the following
        Name
        height
        weight
        GPA
 */

/* Player Requirement
    Must have a GPA of at least 2.3

 */
public abstract class Player {

    private String firstName;
    private String lastName;
    private int Height;
    private int Weight;
    private double GPA;
    private char Sport;

    /**
     * No-arg constructor
     */
    public Player() {
        this.Sport = ' ';
        this.firstName = "";
        this.lastName = "";
        this.Height = 0;
        this.Weight = 0;
        this.GPA = 0;
    }

    /**
     * Parametrized Constructor
     *
     * @param firstName of the player
     * @param lastName  of the player
     * @param Height    of the player
     * @param Weight    of the player
     * @param GPA       of the player
     */
    public Player(char Sport, String firstName, String lastName, int Height, int Weight, double GPA) {
        this.Sport = Sport;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Height = Height;
        this.Weight = Weight;
        this.GPA = GPA;
    }

    /**
     * Get the player's sport
     *
     * @return the player's sport
     */
    public char getSport() {
        return Sport;
    }

    /**
     * Set the player's sport
     *
     * @param Sport the player's sport
     */
    public void setSport(char Sport) {
        this.Sport = Sport;
    }

    /**
     * Get the player's full name
     *
     * @return the player's full name
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Get the player's first name
     *
     * @return the player's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the player's first name
     *
     * @param firstName the player's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the player's last name
     *
     * @return the player's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the player's last name
     *
     * @param lastName the player's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get Height
     *
     * @return Height of the player
     */
    public int getHeight() {
        return Height;
    }

    /**
     * Set Height
     *
     * @param Height of the player
     */
    public void setHeight(int Height) {
        this.Height = Height;
    }

    /**
     * Get Weight
     *
     * @return Weight of the player
     */
    public int getWeight() {
        return Weight;
    }

    /**
     * Set Weight
     *
     * @param Weight of the player
     */
    public void setWeight(int Weight) {
        this.Weight = Weight;
    }

    /**
     * Get GPA
     *
     * @return GPA of the player
     */
    public double getGPA() {
        return GPA;
    }

    /**
     * Set GPA
     *
     * @param GPA of the player
     */
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }


    /**
     * Check if the player meets the requirements
     *
     * @return true if the player meets the GPA requirements, false otherwise
     */
    public boolean meetsGPARequirements() {
        return !(GPA >= 2.3);
    }

    /**
     * Check if the player is a candidate for recruitment.
     *
     * @return true if the player is a candidate, false otherwise
     */
    public abstract boolean isCandidate();


    /**
     * toString
     *
     * @return a string representation of the player
     */
    @Override
    public String toString() {
        return "Player{" + "Name=" + firstName + " " + lastName + ", Height=" + Height + ", Weight=" + Weight + ", GPA=" + GPA + '}';
    }
}
