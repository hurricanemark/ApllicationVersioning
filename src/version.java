import java.io.BufferedReader;
import java.io.InputStreamReader;

public class version {

    public static String getGitVersion() {
        try {
            // Execute the Git command to get the version
            ProcessBuilder processBuilder = new ProcessBuilder("git", "describe", "--tags", "--abbrev=0");
            processBuilder.redirectErrorStream(true);  // Combine standard and error output streams
            Process process = processBuilder.start();

            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String version = reader.readLine();
            
            // Wait for the process to exit and check the exit value
            int exitCode = process.waitFor();
            
            if (exitCode == 0) {
                return version != null ? version.trim() : "";
            } else {
                System.out.println("Git command failed with exit code: " + exitCode);
                return "";
            }

        } catch (Exception e) {
            System.out.println("Error getting Git tag version: " + e.getMessage());
            return "";
        }
    }

    public static void main(String[] args) {
        String version = getGitVersion();
        
        if (version != null && !version.isEmpty()) {
            System.out.println("Current Version: " + version);
        } else {
            System.out.println("Error: Version not found.");
        }
    }
}

