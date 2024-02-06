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
         stage('docker build') {
                            steps {
                            sh 'chmod -R 777 docker-compose.yml'
                            sh 'docker-compose up'
                            }
                        }
         stage('build') {
                    steps {
                    sh 'mvn -B -DskipTests clean package'
                    }
                }
             stage('Test') {
                        steps {
                        sh 'mvn clean test'
                        }
                    }
stage('email') {
                        steps {
                          emailext attachLog: true, body: 'PFA attached Report', compressLog: true, subject: 'Automation results', to: 'ankitbajaj1008@gmail.com'
                        }
                    }

    }
}
