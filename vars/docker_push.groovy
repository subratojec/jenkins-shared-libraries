def call(String Project, String ImageTag, String dockerhubuser) {
    withCredentials([usernamePassword(credentialsId: 'Dockerhub-login', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh "echo \$DOCKER_PASSWORD | docker login -u \$DOCKER_USERNAME --password-stdin"
        sh "docker tag ${Project}:${ImageTag} ${dockerhubuser}/${Project}:${ImageTag}"
        sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
    }
}
