pipeline {
  agent any

  tools {

  }

  stages {
    stage('Clone repo') {
      steps {
        echo "HELLO FROM JENKINSFILE..."
        git 'https://github.com/colinsr/jenkins_stuff.git'
        sh 'ls -la'
      }
    }
    stage('Build Image'){
      steps {
        echo "NEED TO BOOTSTRAP DOCKER..."
        sh 'which docker'
      }
    }
    stage('Start Container'){
      steps {
        echo "CHECKING FOR Dockerfile"
        sh 'echo "docker build . -t "foo"'
      }
    }
    stage('Run Tests'){
      steps {
        echo "RUNNING TESTS..."
        echo "DISPLAYING RESULTS..."
      }
    }
    stage('Push to ACR'){
      steps {
        echo "NEED TO BOOTSTRAP azcli SO I CAN PUSH TO AZURE CONTAINER REPO..."
      }
    }
    stage('Deploy to AKS'){
      steps {
        echo "THIS SHOULD DEPLOY TO AKS VIA HELM..."
      }
    }
  }
}
