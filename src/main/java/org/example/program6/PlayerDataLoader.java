package org.example.program6;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * PlayerDataLoader Class
 * This class is used to read the player data from the file
 */
public class PlayerDataLoader {
    // The name of the file to read the player data from
    final String FILE_NAME="players.txt";

    public List<Player> readPlayerData() throws IOException {
        // Create a list to store the players
        List<Player> players = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into an array of strings
                String[] data = line.trim().split("\\s+");
                // Extract the player's sport
                char sport = data[0].charAt(0);
                // Extract the player's first and last name
                String[] names = data[1].split("_");
                String firstName = names[0];
                String lastName = names[1];
                // Extract the player's height
                int height = Integer.parseInt(data[2]);
                // Extract the player's weight
                int weight = Integer.parseInt(data[3]);
                // Extract the player's GPA
                double gpa = Double.parseDouble(data[4]);

                switch (sport) {
                    // Create a new player object based on the sport
                    // Hockey player
                    case 'H':
                        int goalsPerGame = Integer.parseInt(data[5]);
                        int penaltyMinutesPerSeason = Integer.parseInt(data[6]);
                        int plusMinusNumber = Integer.parseInt(data[7]);
                        players.add(new HockeyPlayer(sport, firstName, lastName, height, weight, gpa, goalsPerGame, penaltyMinutesPerSeason, plusMinusNumber));
                        break;
                    // Football player
                    case 'F':
                        double dashTime = Double.parseDouble(data[5]);
                        players.add(new FootballPlayer(sport, firstName, lastName, height, weight, gpa, dashTime));
                        break;
                    // Volleyball player
                    case 'V':
                        int serviceAcesPerGame = Integer.parseInt(data[5]);
                        int killsPerGame = Integer.parseInt(data[6]);
                        players.add(new VolleyballPlayer(sport, firstName, lastName, height, weight, gpa, serviceAcesPerGame, killsPerGame));
                        break;
                }
            }
        }
        return players;
    }
}