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
                archiveArtifacts artifacts: '**/*report.*'
            }
        }
        stage('cucumber reports') {
            steps {
                cucumber buildStatus: 'UNCHANGED', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', jsonReportDirectory: 'target/Reports/report.json', pendingStepsNumber: -1, reportTitle: 'Automation Reports', skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
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
