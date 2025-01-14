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
