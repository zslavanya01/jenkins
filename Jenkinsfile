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

pipeline {

    agent {
        node {
            label 'agent1'
        }
    }

    stages {
        stage('Hello') {
            steps {
                echo "Hello"
            }
        }
    }
}



