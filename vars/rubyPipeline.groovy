def call(Map config) {
  pipeline {
    agent any

    //tools {  }

    stages {
      stage('Checkout') {
        steps {
          echo "HELLO FROM JENKINSFILE..."
          git 'https://github.com/colinsr/jenkins_stuff.git'
        }
      }
      stage('Build'){
        steps {
          echo "HELLO FROM JENKINSFILE..."
          //sh 'which docker'
        }
      }
      stage('Test') {
        parallel {
          stage('Unit Test') {
            steps {
              echo "running rspec unit tests"
            }
          }
          stage('Integration Test') {
            steps {
              echo "running integration tests"
            }
          }
        }
      }
      stage('Compliance Checking'){
        parallel {
          stage('Code Analysis') {
            steps {
              echo "running sonarruby"
            }
          }
          stage('Security Analysis') {
            steps {
              echo "running something anchore https://jenkins.io/blog/2018/06/20/anchore-image-scanning/"
            }
          }
          stage('Other Checks') {
            steps {
              echo "running something else for image security"
            }
          }
        }
      }
      stage('Push to ACR'){
        steps {
          echo "PUSHING TO AZURE CONTAINER REPO..."
        }
      }
      stage('Deploy to Development AKS'){
        steps {
          echo "THIS SHOULD BE DEPLOYED TO AKS..."
        }
      }
      stage('Dev AKS Smoketest'){
        steps {
          echo "doing fancy smoketests here"
        }
      }
      stage('Deploy to Integration AKS'){
        steps {
          echo "THIS SHOULD BE DEPLOYED TO AKS..."
        }
      }
      stage('Integration AKS Smoketest'){
        steps {
          echo "doing fancy smoketests here"
        }
      }
      stage('Production Deploy Approval'){
        steps {
          input "Deploy to prod?"
        }
      }
      stage('Deploy to Production AKS'){
        steps {
          echo "THIS SHOULD BE DEPLOYED TO AKS..."
        }
      }
      stage('Production AKS Smoketest'){
        steps {
          echo "doing fancy smoketests here"
        }
      }
    }
  }
}
