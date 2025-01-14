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
