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

        stage ('Build code & Install Dependencies') {
            steps{
                sh '''
                npm install
                '''
            }
        }

        
        
        stage ('prepare artifacts') {
           
            steps {
                script {
                    prepare = new nexus()
                    prepare.make_artifacts ("${APP_TYPE}" ,"${COMPONENT}")
                }
                
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