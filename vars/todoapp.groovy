def call(Map params = [:]) {
  def args = [
      NEXUS_IP  :  '172.31.13.117',
  ]
  args << params

  pipeline {
    agent {
        label "${args.SLAVE_LABEL}"
    }
    environment {
        COMPONENT    = "${args.COMPONENT}"
        NEXUS_IP     = "${args.NEXUS_IP}"
        PROJECT_NAME = "${args.PROJECT_NAME}"
        SLAVE_LABEL  = "${args.SLAVE_LABEL}"
    }

    stages {
        
        stage ('prepare artifacts') {
            when {
                environment name: 'APP_TYPE', value: 'NGINX'
            }
            steps {
                sh '''
                  echo ${COMPONENT}
                  zip -r ../${COMPONENT}.zip *
                '''

            }
        }

         stage ('prepare artifacts') {
             when {
                environment name: 'APP_TYPE', value: 'NODEJS'
            }
            steps {
                sh '''
        
                  zip -r ../users.zip *
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