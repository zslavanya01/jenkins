// pipeline {
//     agent any

//     environment {
//         PROJECT_NAME = "ROBOSHOP"
//     }
//     parameters{
//         string(name: 'COMPONENT', defaultValue: '', description: 'which component?')
//     }

//     stages {

//         stage('ONE') {
//             steps{
//                 sh "echo ${PROJECT_NAME}"
//             }
//         }
//         stage('two') {

//             environment {
//                 PROJECT_NAME = "TODO"
//             }
//             steps {
//                 sh "echo ${PROJECT_NAME}"
//             }
//         }
//     }

// }

// pipeline {

//     agent {
//         node {
//             label 'agent1'
//         }
//     }

//     stages {
//         stage('Hello') {
//             steps {
//                 echo "Hello"
//             }
//         }
//     }

//     post {
//         always {
//             echo "Post Action"
//         }
//     }
// }

pipeline {
    agent any

    options {
        disableConcurrentBuilds()
    }

    environment {
        PROJECT_NAME = "TODOAPP"
        UBUNTU_SSH_CRED = credentials('UBUNTU-SSH')
    }

    parameters {
        string(name: 'COMPONENT', defaultValue: '', description: 'Which Component?')
        text(name: 'COMMENT', defaultValue: '', description: 'Comment on why are you running it.')
        booleanParam(name: 'FORCE_DEPLOY', defaultValue: true, description: 'Check this for force deployment')
        choice(name: 'ENV', choices: ['dev', 'qa', 'prod'], description: 'Pick Environment')
        password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
    }

    stages {
        stage('One') {
            steps {
                sh "echo ${PROJECT_NAME}"
                sh "env"
            }
        }

        stage('Two') {
            environment {
                PROJECT_NAME = "TODO"
            }

            steps {
                sh "echo ${PROJECT_NAME}"
            }

        }
    }
}




