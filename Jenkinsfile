pipeline {
    agent any 

    stages {
        stage("Creating *.war file and building docker image") {
            steps {
                script {
                    checkout scm 
                    sh 'rm -rf *.war'
                    sh 'jar -cvf SurveyHomework.war -C SurveyHomework/WebContent/ .'
                    def surveyImage = docker.build("mulukenh/surveyhomework")
                }
            }
        }   
        stage('Test image') {
            steps {
                surveyImage.inside {
                    sh 'make test'
                }
            }
        }
        stage('Push image') {
            steps {
                docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                    surveyImage.push("${env.BUILD_NUMBER}")
                    surveyImage.push("latest")
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