pipeline {
    agent any

        tools {
            maven "M3"
        }

    stages {
        stage('Git Pull') {
            steps {
                git branch: 'main', credentialsId: 'JenkinsDemo', url: 'https://github.com/ankit5587/AutomationCICD.git'
            }
        }
         stage('build') {
                    steps {
                    sh 'mvn -B -DskipTests clean package'
                    }
                }
                stage('docker compose up') {
                                    steps {
                                    sh 'docker-compose up'
                                    }
                                }
             stage('Test') {
                        steps {
                        sh 'mvn clean test'
                        }
                    }
    }
}
