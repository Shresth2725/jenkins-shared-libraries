def call (String projectName , String projectTag) {
                 withCredentials([usernamePassword(
                    credentialsId: "dockerHubCred",
                    usernameVariable: "dockerHubUser",
                    passwordVariable: "dockerHubPass"
                )]) {
                    // Login
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"

                    // Tag image
                    sh "docker tag notes-app:latest ${env.dockerHubUser}/${projectName}:${projectTag}"

                    // Push image
                    sh "docker push ${env.dockerHubUser}/${projectName}:${projectTag}"
                 }
}
