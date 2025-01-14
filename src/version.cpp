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
