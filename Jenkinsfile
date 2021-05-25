pipeline {
    agent any

    environment {
        PROJECT_NAME = "ROBOSHOP"
    }
    options{
        disable concurrent builds()
    }
    parameters{
        string(name: 'COMPONENT', defaultValue: '', description: 'which component?')
    }

    stages {

        stage('ONE') {
            steps{
                sh "echo ${PROJECT_NAME}"
            }
        }
        stage('two') {

            environment {
                PROJECT_NAME = "TODO"
            }
            steps {
                sh "echo ${PROJECT_NAME}"
            }
        }
    }

}