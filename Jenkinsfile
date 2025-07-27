pipeline {
    agent any

    tools {
        maven 'Maven_3.8.6'   // Update if your Jenkins config uses a different name
        jdk 'jdk-21'         // Update to your actual JDK version in Jenkins
    }
    environment {
        CHROME_BIN = '/usr/bin/google-chrome'
        CHROMEDRIVER_BIN = '/usr/bin/chromedriver'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/buvanatech87/selenium-junit-pom-framework.git', branch: 'main'
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean test' //windows used bat 
            }
        }

        stage('Verify Environment') {
            steps {
                bat 'google-chrome --version'
                bat 'chromedriver --version'
                bat 'java -version'
                bat 'mvn -v'
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
