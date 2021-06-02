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
        APP_TYPE     = "${args.APP_TYPE}"
    }

    stages {
        
        stage ('prepare artifacts - NGINX') {
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

        stage ('prepare artifacts - NODEJS') {
             when {
                environment name: 'APP_TYPE', value: 'NODEJS'
            }
            steps {
                sh '''
        
                  zip -r ../${COMPONENT}.zip *
                '''

            }
        }

        stage ('prepare artifacts') {
            steps {
                sh '''
        
                  zip -r ../${COMPONENT}.zip *
                '''

            }
        }

        stage ('prepare artifacts') {
            steps {
                sh '''
        
                  zip -r ../${COMPONENT}.zip *
                '''

            }
        }

        stage ('prepare artifacts') {
            steps {
                sh '''
        
                  zip -r ../${COMPONENT}.zip *
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