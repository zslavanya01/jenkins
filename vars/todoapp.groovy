def call(Map params = [:]) {
  def args = [
      NEXUS_IP  :  '172.31.13.117',
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