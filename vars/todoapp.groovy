def call() {
  pipeline {
    agent {
        label "java"
    }

    stages {
        stage ('Download Dependencies') {
            steps{
                sh '''
                  npm install
                '''
            }
        }

        stage ('prepare artifacts') {
            steps {
                sh '''
        
                  zip -r ../frontend.zip *
                '''

            }
        }
        stage ('upload artifacts') {
            steps {
                script {
                    nexus
                }
            }
        }
    }
   
}