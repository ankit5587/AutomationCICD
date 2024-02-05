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
                    sh '''M2_HOME=\'/opt/apache-maven-3.6.3\'
                    PATH="$M2_HOME/bin:$PATH"
                    export PATH'''
                    sh 'mvn clean test'
                    }
                }
    }
}
