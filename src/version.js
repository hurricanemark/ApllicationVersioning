const { exec } = require('child_process');

function getGitVersion() {
    return new Promise((resolve, reject) => {
        // Execute the Git command to get the version
        exec('git describe --tags --abbrev=0', (error, stdout, stderr) => {
            if (error) {
                reject(`Error executing Git command: ${error.message}`);
                return;
            }
            if (stderr) {
                reject(`Error: ${stderr}`);
                return;
            }
            // Trim the output to get the version
            const version = stdout.trim();
            if (version) {
                resolve(version);
            } else {
                reject('Error: Version not found.');
            }
        });
    });
}

getGitVersion()
    .then(version => {
        console.log(`Current Version: ${version}`);
    })
    .catch(error => {
        console.log(error);
    });
