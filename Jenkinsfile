pipeline {
    agent any
    
    tools {
        maven 'M3'
    }
    
    stages {
        stage('Build') {
            steps {
                sh 'mvn test'
            }
        }
        
         
          stage("SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('sonar') {
                sh 'mvn install sonar:sonar'
              }
            }
          }
        
     }
}
