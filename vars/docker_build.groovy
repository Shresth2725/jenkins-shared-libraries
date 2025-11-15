def call(String imageName , String imageTag , String DockerHubName) {
  sh "docker build -t ${DockerHubName}/${imageName}:${imageTag} ."
}
