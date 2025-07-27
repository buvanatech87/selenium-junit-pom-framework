pipeline {
    agent any

    tools {
        maven 'Maven 3.8.8'   // Update if your Jenkins config uses a different name
        jdk 'Java 11'         // Update to your actual JDK version in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/buvanatech87/selenium-junit-pom-framework.git', branch: 'main'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML(target: [
                    reportDir: 'test-output/ExtentReports',
                    reportFiles: 'index.html',
                    reportName: 'Extent Report'
                ])
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
