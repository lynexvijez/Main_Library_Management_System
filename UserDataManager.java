import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserDataManager {

    private static final String FILE_PATH = "users.txt";

    public static void writeUserData(String name, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(name + "," + password);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while writing user data: " + e.getMessage());
        }
    }

    public static Map<String, String> readUserData() {
        Map<String, String> userData = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    userData.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading user data: " + e.getMessage());
        }
        return userData;
    }
}