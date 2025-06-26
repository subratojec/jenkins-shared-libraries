def call(String Project, String ImageTag, String dockerhubuser) {
    withCredentials([usernamePassword(credentialsId: 'Dockerhub-login', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}"
        sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
    }
}
