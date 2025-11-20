pipeline {
    agent any
    stages {
        stage('display the stage') {
            steps {
                retry(2) {
                echo "*****Display the ip got executed****"
                sh "hostname -i"

                }
            }
        }
        stage('other build')
        agent {
            label 'java-slave'
        }
        steps {
            echo "***display the ip "
            sh "hostname -i"
        }
    }
}
