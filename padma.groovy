pipeline {
    agent any
    stages {
        stage('build the ip') {
            steps {
                retry(3) {
                    echo "***display the host ip***"
                    sh "hostname -i"
                }

            }
        }
        stage('other build') {
            agent {
                label 'java-slave'
            }
            steps {
                cleanWs()
                echo "***disply the other host***"
                sh "hostname -i"
            }
        }
    }
}
