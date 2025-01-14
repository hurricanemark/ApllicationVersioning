# Apllication Versioning

To implement versioning using Git tags and the semantic versioning system (major, minor, patch) in multiple programming languages, let's first define the following approach:

1. **Git Tagging**: We will extract the Git tag (e.g., `v1.2.3`) from the Git repository.
2. **Versioning Scheme**: The version will follow the Semantic Versioning scheme: `major.minor.patch`.
3. **Implementation**: For simplicity, I'll assume that the program can read the version from a file or Git tag, then parse it and display it.

Here's how you might implement this in C++, C#, Python, and Java:

### 1. **C++ Program**

To integrate Git tags in C++, we'll use a system call to execute Git commands from within the program.

```cpp
#include <iostream>
#include <cstdlib>
#include <sstream>

std::string get_git_version() {
    // Use a system call to get the current Git tag
    const char* command = "git describe --tags --abbrev=0"; 
    char buffer[128];
    std::string result = "";
    
    FILE* fp = popen(command, "r");
    if (fp == nullptr) {
        std::cerr << "Error getting Git tag version" << std::endl;
        return "";
    }
    
    while (fgets(buffer, sizeof(buffer), fp) != nullptr) {
        result += buffer;
    }
    fclose(fp);

    // Remove the newline character
    result.erase(result.find_last_not_of("\n") + 1);
    return result;
}

int main() {
    std::string version = get_git_version();
    
    if (!version.empty()) {
        std::cout << "Current Version: " << version << std::endl;
    } else {
        std::cerr << "Error: Version not found." << std::endl;
    }
    
    return 0;
}
```

### 2. **C# Program**

In C#, you can use the `System.Diagnostics` namespace to run Git commands.

```csharp
using System;
using System.Diagnostics;

class Program
{
    static string GetGitVersion()
    {
        ProcessStartInfo startInfo = new ProcessStartInfo
        {
            FileName = "git",
            Arguments = "describe --tags --abbrev=0",
            RedirectStandardOutput = true,
            UseShellExecute = false,
            CreateNoWindow = true
        };

        using (Process process = Process.Start(startInfo))
        using (var reader = process.StandardOutput)
        {
            return reader.ReadToEnd().Trim();
        }
    }

    static void Main()
    {
        string version = GetGitVersion();
        
        if (!string.IsNullOrEmpty(version))
        {
            Console.WriteLine("Current Version: " + version);
        }
        else
        {
            Console.WriteLine("Error: Version not found.");
        }
    }
}
```

### 3. **Python Program**

Python's `subprocess` module allows you to run Git commands.

```python
import subprocess

def get_git_version():
    try:
        # Run the Git command to get the version
        version = subprocess.check_output(["git", "describe", "--tags", "--abbrev=0"]).decode("utf-8").strip()
        return version
    except subprocess.CalledProcessError as e:
        print("Error getting Git tag version")
        return ""

if __name__ == "__main__":
    version = get_git_version()
    
    if version:
        print(f"Current Version: {version}")
    else:
        print("Error: Version not found.")
```

### 4. **Java Program**

In Java, you can use `Runtime.getRuntime().exec()` to run external commands.

```java
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
```

### Explanation:

- **Git Command**: All programs execute `git describe --tags --abbrev=0` to fetch the most recent Git tag.
- **Version Format**: The Git tag should be in the format `v<major>.<minor>.<patch>` (e.g., `v1.2.3`).
- **Error Handling**: If the Git tag is not found, the programs will display an error message.

### Notes:

- These programs assume that Git is installed on the system and that the program is executed inside a Git repository.
- The programs display the version retrieved from the Git tag, which is typically managed by the developer during the release process.
