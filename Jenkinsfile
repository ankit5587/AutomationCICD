pipeline {
    agent any

    stages {
        stage('Git Pull') {
            steps {
                git branch: 'main', credentialsId: 'JenkinsDemo', url: 'https://github.com/ankit5587/AutomationCICD.git'
            }
        }
         stage('Run Tests') {
                    steps {
                        sh 'mvn clean test'
                    }
                }
    }
}
