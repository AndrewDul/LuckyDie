package lib;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Test class to verify the functionality of ReadWriteUtility methods.
 */
public class ReadWriteUtilityTest {

    public static void main(String[] args) {
        ReadWriteUtility utility = new ReadWriteUtility();

        try {
            Path filePath = Paths.get("testFile.txt");
            Path directoryPath = Paths.get("testDirectory");
            Path copiedFilePath = Paths.get("testFileCopy.txt");
            Path filteredFilePath = Paths.get("filteredFile.txt");
            Path logPath = Paths.get("errorLog.txt");

            // Test file creation
            utility.createFile(filePath);

            // Test directory creation
            utility.createDirectory(directoryPath);

            // Test writing to file
            List<String> content = List.of("Short line", "This line is a bit longer", "Another short line");
            utility.writeToFile(filePath, content);

            // Test reading from file
            List<String> readContent = utility.readFromFile(filePath);
            readContent.forEach(System.out::println);

            // Test copying file
            utility.copyFile(filePath, copiedFilePath);

            // Test listing files in directory
            List<Path> filesInDirectory = utility.listFilesInDirectory(directoryPath);
            filesInDirectory.forEach(System.out::println);

            // Test filtering and writing to a new file
            utility.writeFilteredLinesToFile(filePath, filteredFilePath, 12);

            // Test searching files in directory with pattern
            List<Path> txtFiles = utility.searchFilesInDirectory(Paths.get("."), "*.txt");
            System.out.println("Text files found in directory:");
            txtFiles.forEach(System.out::println);

            // Test error logging by attempting to create an existing file
            try {
                utility.createFile(filePath); // This should fail if the file already exists
            } catch (IOException e) {
                utility.logErrorToFile("Failed to create file: " + e.getMessage(), logPath);
            }

            // Comment out deletion to observe files if necessary
            utility.deleteFile(filePath);
            utility.deleteFile(copiedFilePath);
            utility.deleteFile(filteredFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
