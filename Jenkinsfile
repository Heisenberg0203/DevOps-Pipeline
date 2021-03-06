pipeline {
    agent any

    stages {
        stage('Git Checkout') {
            steps {
                script{
                    git credentialsId: 'Github', url: 'https://github.com/Heisenberg0203/Spe_Devops_Calculator'
                }
            }
        }
        stage('Unit Test') {
            steps {
                script{
                    sh 'mvn clean test'
                }
            }
        }
    }
}
