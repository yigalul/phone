pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git url: 'https://github.com/yigul/PhoneBill-.git', branch: 'master'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}