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
        COMPONENT    = "${args.COMPONENT}"
        NEXUS_IP     = "${args.NEXUS_IP}"
        PROJECT_NAME = "${args.PROJECT_NAME}"
        SLAVE_LABEL  = "${args.SLAVE_LABEL}"
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