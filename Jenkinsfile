pipeline{
    agent any

    tools{
    maven 'maven3.6'
    jdk 'jdk8'

    }

    stages{
        stage('sensedia clean'){
            steps{
                sh "mvn clean"
            }
        }
        stage('sensedia clean'){
            steps{
                sh "mvn test"
            }
        }
    }
}