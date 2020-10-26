pipeline {
    agent any 

    stages {
        stage("Creating *.war file and building docker image") {
            steps {
                script {
                    checkout scm 
                    sh 'rm -rf *.war'
                    sh 'jar -cvf SurveyHomework.war -C SurveyHomework/WebContent/ .'
                    def surveyImage = docker.build("mulukenh/surveyhomework:${env.BUILD_ID}")
                    surveyImage.inside {
                        sh 'make test'
                    }
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                        surveyImage.push()
                    }   
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