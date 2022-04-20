pipeline {
    agent any
    
    tools {
        maven 'M3'
    }
    
    stages {
           stage("SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('sonar') {
                sh 'mvn install sonar:sonar'
              }
            }
          }
     stage('Build') {
            steps {
                sh 'mvn test'
            }
        }
     }
}
