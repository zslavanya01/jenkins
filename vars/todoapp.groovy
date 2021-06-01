def call(String COMPONENT) {
  pipeline {
    agent {
        label "java"
    }
    environment {
        COMPONENT = COMPONENT
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
                  echo ${COMPONENT}
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