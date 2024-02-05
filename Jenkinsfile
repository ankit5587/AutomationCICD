pipeline {
    agent any

        tools {
            // Install the Maven version configured as "M3" and add it to the path.
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
    }
}
