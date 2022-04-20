pipeline {
    agent any
    
    tools {
        maven 'M3'
    }
    
    stages {
         stage('Test') {
            steps {
                sh 'mvn test'
            }
          
          stage("SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('sonar') {
                sh 'mvn sonar:sonar'
              }
            }
          }
        
     }
}
