pipeline {
    agent any 

    environment {
        DOCKERHUB_PASS = credentials('dockerhub')
    }
    stages {
        stage("Creating *.war file and building docker image") {
            steps {
                script {
                    checkout scm 
                    sh 'rm -rf *.war'
                    sh 'jar -cvf SurveyHomework.war -C WebContent/ .'
                    sh 'docker login -u mulukenh -p ${DOCKERHUB_PASS}'
                    def surveyImage = docker.build("mulukenh/surveyhomework:${BUILD_TIMESTAMP}")
                    surveyImage.push()
                }
            }
        }   
        stage("Deploying to Rancher") {
            steps {
                echo 'Deploying to rancher'
            }        
        }         
    }
}