// def call(Map params = [:]) {
//   def args = [
//       NEXUS_IP  :  '172.31.13.117',
//   ]
//   args << params

//   pipeline {
//     agent {
//         label "${args.SLAVE_LABEL}"
//     }

//     triggers {
//         pollSCM('* * * * 1-5')
//     }

//     environment {
//         COMPONENT    = "${args.COMPONENT}"
//         NEXUS_IP     = "${args.NEXUS_IP}"
//         PROJECT_NAME = "${args.PROJECT_NAME}"
//         SLAVE_LABEL  = "${args.SLAVE_LABEL}"
//         APP_TYPE     = "${args.APP_TYPE}"
//     }

//     stages {

//         stage('Build code & Install Dependencies') {
//             steps {
//                 script {
//                     build = new nexus()
//                     prepare.code_build ("${APP_TYPE}" ,"${COMPONENT}")
//                 }
                
//             }
//         }

        
        
//         stage ('prepare artifacts') {
           
//             steps {
//                 script {
//                     prepare = new nexus()
//                     prepare.make_artifacts ("${APP_TYPE}" ,"${COMPONENT}")
//                 }
                
//             }
//         }

//         stage ('upload artifacts') {
//             steps {
//                 script {
//                     prepare = new nexus()
//                     prepare.nexus (COMPONENT)
                    
//                 }
//             }
//         }
//     }
//   }
// }

def call(Map params = [:]) {
    def args = [
        NEXUS_IP   :  '172.31.1.61',
    ]
    args  <<  params

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

            stage('Download dependencies') {
                when {
                    environment name: 'APP_TYPE', value: 'NODEJS'
                }
                steps {
                    sh '''
                      npm install
                    '''
                }
            }

            


            

            stage('Compile code') {
                when {
                    environment name: 'APP_TYPE', value: 'JAVA'
                }
                steps {
                    sh '''
                      mvn compile
                    '''
                }
            }

            stage('Make package') {
                when {
                    environment name: 'APP_TYPE', value: 'JAVA'
                }
                steps {
                    sh '''
                      mvn package
                    '''
                }
            }


            stage('prepare artifacts - NGINX') {
                steps {
                    script {
                        prepare = new nexus()
                        prepare.make_artifacts ("${APP_TYPE}","${COMPONENT}")
                    }
                    sh '''
                      ls
                    '''
                    }
                }
  

            stage('Upload Artifacts') {
                steps {
                    sh '''
                        curl -f -v -u admin:admin123 --upload-file /home/ubuntu/workspace/CI-Pipelines/todo.zip http://172.31.1.61:8081/repository/todo/todo.zip
                    '''
                }
            }
        }
    }

}