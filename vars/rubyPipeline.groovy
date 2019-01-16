def call(Map config) {
  pipeline {
    agent any

    //tools {  }

    stages {
      stage('Clone repo') {
        steps {
          echo "HELLO FROM JENKINSFILE..."
          git 'https://github.com/colinsr/jenkins_stuff.git'
        }
      }
      stage('Build Image'){
        steps {
          echo "HELLO FROM JENKINSFILE..."
          //sh 'which docker'
        }
      }
      stage('Start Container'){
        steps {
          echo "CHECKING FOR Dockerfile"
          //sh 'docker build . -t "foo"'
        }
      }
      stage('Run Tests'){
        steps {
          echo "RUNNING TESTS..."
        }
      }
      stage('Push to ACR'){
        steps {
          echo "PUSHING TO AZURE CONTAINER REPO..."
        }
      }
      stage('Deploy to AKS'){
        steps {
          echo "THIS SHOULD BE DEPLOYED TO AKS..."
        }
      }
      stage('Print a config value') {
        steps {
          echo "$config.name"
        }
      }
    }
  }
}
