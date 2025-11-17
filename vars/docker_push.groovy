def call (String projectName , String projectTag) {
    withCredentials([usernamePassword(
        credentialsId: "dockerHubCred",
        usernameVariable: "dockerHubUser",
        passwordVariable: "dockerHubPass"
    )]) {

        // Login safely
        sh "echo ${dockerHubPass} | docker login -u ${dockerHubUser} --password-stdin"

        // Push the image that was already built by docker_build()
        sh "docker push ${dockerHubUser}/${projectName}:${projectTag}"
    }
}
