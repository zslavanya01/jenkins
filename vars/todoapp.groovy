def call(Map params = [:]) {
  def args = [
      NEXUS  :  'some',
  ]
  args << params

  pipeline {
    agent {
        label "java"
    }
    environment {
        COMPONENT = "${args.COMPONENT}"
    }

    stages {
        
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