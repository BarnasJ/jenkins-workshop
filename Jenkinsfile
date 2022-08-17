pipeline {
    agent any

    tools {
        maven 'Maven386'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', 
                branches: [[name: 'develop']], 
                extensions: [], 
                userRemoteConfigs: [[
                    credentialsId: 'fca09add-fac4-4cf1-be3b-e0612867e7ef', 
                    url: 'https://github.com/BarnasJ/jenkins-workshop.git']]])
            }
        }
        
        stage('Build') {
            steps {
                sh "mvn install -DskipTests"
            }
        }
        
        stage('Test') {
            steps {
                sh "mvn test"
            }
        }
        
        stage('Generate cucumber report') {
            steps {
                cucumber reportTitle: 'My report', fileIncludePattern: 'target/cucumber-reports/*.json'
            }
        }

    }
    
    post {
        always {
            junit allowEmptyResults: true, skipMarkingBuildUnstable: true, testResults: 'target/surefire-reports/*.xml'
            cleanWs()
        }
    }
}
