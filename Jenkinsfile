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
                sh '''
                            sudo chmod 666 /var/run/docker.sock
                            docker info
                            docker version
                            docker compose version
                            curl --version
                            '''
                sh 'chmod -R 777 docker-compose.yml'
                sh 'docker compose up -d'
                echo 'Docker-compose-build Build Image Completed'
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
        stage('Archive Results') {
            steps {
                sh 'archiveArtifacts artifacts: \'target/Reports/*html\', followSymlinks: false'
            }
        }
    }
    post {
        always {
            sh 'docker compose down'
            emailext attachLog: true, body: 'PFA attached Report', compressLog: true, subject: 'Automation results', to: 'ankitbajaj1008@gmail.com'
        }
    }
}
