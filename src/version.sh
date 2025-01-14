#!/bin/bash

get_git_version() {
    # Execute the Git command to get the version
    version=$(git describe --tags --abbrev=0 2>/dev/null)
    
    if [ $? -eq 0 ]; then
        # If git command succeeded, print the version
        echo "Current Version: $version"
    else
        # If git command failed, print an error message
        echo "Error: Version not found or git command failed."
    fi
}

get_git_version
