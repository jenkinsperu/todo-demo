pipeline {
    agent {
        label 'master'
    }
    
    parameters {
        booleanParam(defaultValue: false, description: 'Desplegar en producción?', name: 'RELEASE')
    }
    
    environment {
        SLACK_CHANNEL= '#ci'
        SLACK_TEAM = 'electro-obras'
    }
    
    stages {
        stage("SCM") {
            steps {
            checkout scm
            }
        }
        stage("compile") {
            steps {
                sh "./mvnw clean package"
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
                success {
                     archiveArtifacts artifacts: 'target/*.jar', onlyIfSuccessful: true
                }
            }
        }
        stage("Despliegue") {
            steps {
                echo "${params.RELEASE}"
                echo "${env.SLACK_TEAM}"
            }
        }
    }
    post {
        failure {
            slack('danger', 'This is not fine')
        }
        success {
            slack('good', "This is fine ${env.BUILD_NUMBER}")
        }
        unstable {
            slack('warning', 'This is unstable')
        }
    }
}

def slack(color, message) {
    slackSend channel: "${env.SLACK_CHANNEL}", color: color, message: message, teamDomain: "${env.SLACK_TEAM}", token: "${env.SLACK_TOKEN}"
}
