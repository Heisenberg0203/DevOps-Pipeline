pipeline {
    agent any
    environment {
        image='rushikesh0203/spe_calculator'
        dockerImage = ''
        dockerImageLatest = ''
   }
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
        stage('Build executable jar') {
            steps {
                script{
                    sh 'mvn -Dmaven.test.skip=true package '
                }
            }
        }
        stage('Building image') {
          steps{
            script {
              dockerImage = docker.build "$image:${env.BUILD_NUMBER}"
              dockerImageLatest = docker.build "$image:latest"
            }
          }
        }
        stage('Deploy Image') {
          steps{
            script {
              docker.withRegistry( '', 'Docker' ) {
                dockerImage.push()
                dockerImageLatest.push()
              }
            }
          }
        }
        stage('Remove Unused docker image') {
          steps{
            script{
            sh "docker rmi $image:latest;docker rmi $image:${env.BUILD_NUMBER}";
          }
          }
        }
        stage('Deploy Containers to Hosts') {
          steps{
            script {
                ansiblePlaybook becomeUser: null, installation: 'Ansible', inventory: 'ansible-playbook/hosts', playbook: 'ansible-playbook/deploy-jar.yml', sudoUser: null
            }
          }
        }
    }
}

