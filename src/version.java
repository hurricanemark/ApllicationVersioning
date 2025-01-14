import java.io.BufferedReader;
import java.io.InputStreamReader;

public class version {

    public static String getGitVersion() {
        try {
            // Execute the Git command to get the version
            Process process = Runtime.getRuntime().exec("git describe --tags --abbrev=0");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String version = reader.readLine();
            return version != null ? version.trim() : "";
        } catch (Exception e) {
            System.out.println("Error getting Git tag version");
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
