package org.example.program6;

// CST-283
// Aaron Pelto
// Winter 2024

/*
    Write a program that will manage a sports recruiting operation.
    Your goal is to examine athletes from three sports and select those with special attributes for further consideration.
    This implies use of four classes:
        One Class for general player attributes and methods
        One Class for Hockey Player,
        One Class for Volleyball Player,
        One Class for Football Player
    Use inheritance to define the three specialized classes from the one general class
 */

/*
    Include set/get methods as needed, but include at least one constructor per class.
    Your program is mainly designed to identify players for serious recruiting if they have all the attributes from a list.
 */

/*
    Your program should be driven by a list of athletes (found in file players.txt).
    Each line of data in this file represents a player.
    The format of the file begins with:
        Game code (F, V, or H), name, height (inches), weight (pounds), GPA
    Beyond these, additional data items will be included for each type of athlete:
        Football: 40 yard dash time
        Volleyball: services aces per game, kills per game
        Hockey: goals per season, penalty minutes per season, plus-minus number
    For processing, define basic array or ArrayList of Player objects.
    Your program should read the file players.txt, determine what type of athlete the data represents, read the subsequent related attributes of the athlete, instantiate the correct object type (football, volleyball, or hockey), and add it to the array.
    Next, sort the array of Player objects by descending GPA.
    Your output should simply be a sequence of all names followed by their sport name, and whether they are being targeted for recruitment.
    For determination if they are to be recruited:
        Invoke an abstract method isCandidate()using polymorphism to determine if a player is a candidate for further recruitment.
         This implies a declaration of isCandidate() in Player as abstract followed by individually declaring the method in each of the three sports classes.


    The specific sports recruiting requirements can be then implemented via the three respective methods.
    Remember that all athletes must reach a certain GPA, so be sure the common Player method checking for GPA is included as part of the specific isCandidate() actions.


    Include a simple JavaFX user interface that includes a text area and a button. When the button is clicked,
    the file should be processed and the list of candidates described above could be produced as string data that
    can be passed in to be displayed in the text area.

 */


import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * SportsRecruitment Class
 * This class is the main class for the Sports Recruitment application
 */
public class SportsRecruitment extends Application {

    // The player data loader
    private final PlayerDataLoader loader = new PlayerDataLoader();

    // Text area for displaying player data
    private TextArea playersTextArea;

    /**
     * The main method that launches the application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * The start method that sets up the stage and scene for the Sports Recruitment application.
     *
     * @param stage the primary stage for this application
     */
    @Override
    public void start(Stage stage) {
        VBox vbox = loadRecruitmentGUI();
        Scene scene = new Scene(vbox, 720, 480);

        stage.setTitle("Sports Recruitment");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Loads the Sports Recruitment GUI which includes a label, text area, and button.
     *
     * @return a VBox containing the GUI elements
     */
    private VBox loadRecruitmentGUI() {
        // Label for the player table
        Label playersLabel = new Label("Player Table");
        // Text area for displaying player data
        playersTextArea = loadTextArea();
        // Button for processing the player data file
        Button loadButton = loadButton();
        // Button for exiting the application
        Button exitButton = exitButton();

        // VBox to contain the GUI elements
        VBox vbox = new VBox(playersLabel, playersTextArea, loadButton, exitButton);
        // Set the padding and spacing for the VBox
        vbox.setPadding(new Insets(10, 10, 10, 10));
        // Set the spacing between the elements in the VBox
        vbox.setSpacing(10);

        return vbox;
    }

    /**
     * Loads the text area where the player data will be displayed for those who meet the recruitment criteria.
     *
     * @return a TextArea for displaying player data
     */
    private TextArea loadTextArea() {
        // Create the text area
        TextArea textArea = new TextArea();
        // Set the font and font size
        textArea.setFont(new Font("Courier New", 12));
        // Set the preferred number of rows for the text area
        textArea.setPrefRowCount(50);
        // Return the text area
        return textArea;
    }

    /**
     * Loads the button that will process the file and display the list of candidates in the text area.
     *
     * @return a Button for processing the file
     */
    private Button loadButton() {
        // Create the button
        Button button = new Button("Process File");
        // Set the action for the button to load the list of players
        button.setOnAction(event -> areYouSureYouWantToLoadDataAlert());
        // Return the button
        return button;
    }

    /**
     * Creates an alert to confirm if the user wants to load the data.
     */
    private void areYouSureYouWantToLoadDataAlert() {
        // Create an alert dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        // Set the title of the alert
        alert.setTitle("Load Data");
        // Set the header text of the alert
        alert.setHeaderText(null);
        // Set the message for the alert
        // Messing around with a fun alert message for Mr. Klingler.
        alert.setContentText("Are you sure you want to load the data Mr.Klingler?");
        // Wait for the user to close the alert and capture the result
        Optional<ButtonType> result = alert.showAndWait();
        // If the user confirms, load the list of players
        if (result.isPresent() && result.get() == ButtonType.OK) {
            loadList();
        }
    }

    /**
     * Loads the button that will exit the application.
     *
     * @return a Button for exiting the application
     */
    private Button exitButton() {
        // Create the button
        Button button = new Button("Exit");
        // Set the action for the button to exit the application
        button.setOnAction(event -> areYouSureExitAlert());
        // Return the button
        return button;
    }

    /**
     * Creates an alert to confirm if the user wants to exit the application.
     */
    private void areYouSureExitAlert() {
        // Create an alert dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        // Set the title of the alert
        alert.setTitle("Exit");
        // Set the header text of the alert
        alert.setHeaderText(null);
        // Set the message for the alert
        alert.setContentText("Are you sure you want to exit?");
        // Wait for the user to close the alert and capture the result
        Optional<ButtonType> result = alert.showAndWait();
        // If the user confirms, exit the application
        // AWESOME - I was able to get this to work.
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Platform.exit();
        }
    }

    /**
     * Loads the list of players from the file and displays the player data in the text area.
     */
    private void loadList() {
        try {
            // Read the player data from the file
            List<Player> players = loader.readPlayerData();
            // Sort the list of players by descending GPA
            displayPlayerData(players);
            // Catch any errors and display an error dialog
        } catch (IOException e) {
            showErrorDialog("Error processing file: " + e.getMessage());
        }
    }

    /**
     * Displays the player data in the text area.
     *
     * @param players the list of players to display
     */
    private void displayPlayerData(List<Player> players) {
        // Sort the players by descending GPA
        players.sort((p1, p2) -> Double.compare(p2.getGPA(), p1.getGPA()));

        // StringBuilder to store the player data
        StringBuilder playersData = new StringBuilder();

        // Append the header to the StringBuilder
        String headerFormat = "%-30s | %-15s | %-30s\n";
        playersData.append(String.format(headerFormat, "Full Name", "Sport", "Recruitment Status"));

        // Loop through the list of players and display the player data
        for (Player player : players) {
            // Check if the player is a candidate for recruitment
            if (player.isCandidate()) {
                // If the player is a candidate, display the player's name, sport, and recruitment status
                String playerFormat = "%-30s | %-15s | %-30s\n";
                playersData.append(String.format(playerFormat, player.getFullName(), player.getSport(), "Targeted for recruitment"));
                // If the player is not a candidate, display the player's name, sport, and recruitment status
            } else {
                String playerFormat = "%-30s | %-15s | %-30s\n";
                playersData.append(String.format(playerFormat, player.getFullName(), player.getSport(), "Not targeted for recruitment"));
            }
        }
        // Set the text of the text area to the player data
        playersTextArea.setText(playersData.toString());
    }

    /**
     * Shows an error dialog with the given message.
     *
     * @param message the message to display in the error dialog
     */
    // Trying this again.
    // Creating a singular area to capture errors with the file and output an alert.
    private void showErrorDialog(String message) {
        // Create an alert dialog
        Alert alert = new Alert(Alert.AlertType.ERROR);
        // Set the title of the alert
        alert.setTitle("Error");
        // Set the header text of the alert
        alert.setHeaderText(null);
        // Set the message for the alert
        alert.setContentText(message);
        // Wait for the user to close the alert
        alert.showAndWait();
    }
}