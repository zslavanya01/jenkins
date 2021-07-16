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

        triggers {
            pollSCM('* * * * 1-5')
        }
        
        environment {
            COMPONENT    = "${args.COMPONENT}"
            NEXUS_IP     = "${args.NEXUS_IP}"
            PROJECT_NAME = "${args.PROJECT_NAME}"
            SLAVE_LABEL  = "${args.SLAVE_LABEL}"
            APP_TYPE     = "${args.APP_TYPE}"
        }

        stages {

            stage('Build Code & Install Dependencies') {
                steps {
                    script {
                        build = new nexus()
                        build.code_build ("${APP_TYPE}","${COMPONENT}")
                    }  
                }
            }

            stage('prepare artifacts - NGINX') {
                steps {
                    script {
                        prepare = new nexus()
                        prepare.make_artifacts ("${APP_TYPE}","${COMPONENT}")
                    }

                }
            }
  

            stage('Upload Artifacts') {
                steps {
                    script {
                        prepare = new nexus()
                        prepare.nexus(COMPONENT)
                    }
                }        
            }

           stage('Deploy to Dev env') {
               steps {
                   build job: 'Deploypipeline', parameters: [string(name: 'ENV', value: 'dev'), string(name: 'COMPONENT',value: "${COMPONENT}"),string(name: 'VERSION',value: '0.0.0')]
               }
           }

        }

    }
}
