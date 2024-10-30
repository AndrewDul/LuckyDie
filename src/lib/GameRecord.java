package lib;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class responsible for recording game results to a file.
 * Each record includes the player's name, score, date, time, and total game duration.
 */
public class GameRecord {

    private Path filePath;

    /**
     * Constructor for GameRecord, initializing the file path for storing game records.
     * 
     * @param filePath the path of the file where game records will be stored
     */
    public GameRecord(Path filePath) {
        this.filePath = filePath;
        createFileIfNotExists();
    }

    /**
     * Creates the record file if it does not already exist.
     */
    private void createFileIfNotExists() {
        try {
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            System.err.println("Error creating record file: " + e.getMessage());
        }
    }

    /**
     * Adds a new game record with the player's name, score, date, time, and total game duration.
     * 
     * @param playerName the name of the player
     * @param score      the score achieved by the player
     * @param totalTime  the total time taken to reach the score in seconds
     */
    public void addRecord(String playerName, int score, double totalTime) {
        String record = formatRecord(playerName, score, totalTime);

        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(filePath, StandardOpenOption.APPEND))) {
            writer.println(record);
            System.out.println("Record saved for player: " + playerName);
        } catch (IOException e) {
            System.err.println("Error saving record: " + e.getMessage());
        }
    }

    /**
     * Formats the record to include the player's name, score, date, time, and game duration.
     * 
     * @param playerName the name of the player
     * @param score      the score achieved by the player
     * @param totalTime  the total time taken to reach the score in seconds
     * @return a formatted string containing the game record
     */
    private String formatRecord(String playerName, int score, double totalTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        return String.format("Player: %s | Score: %d | Date: %s | Time: %s | ScoreTime: Total time: %.3f seconds",
                playerName, score, now.format(dateFormatter), now.format(timeFormatter), totalTime);
    }

    /**
     * Reads all records from the record file.
     * 
     * @return a list of strings where each string is a line from the record file
     * @throws IOException if an I/O error occurs while reading from the file
     */
    public String readAllRecords() {
        StringBuilder records = new StringBuilder("Game Records:\n");

        try {
            Files.lines(filePath).forEach(line -> records.append(line).append("\n"));
        } catch (IOException e) {
            System.err.println("Error reading records: " + e.getMessage());
        }

        return records.toString();
    }
}
