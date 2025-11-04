pipeline {
  agent any
  environment {
    MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
  }
  stages {
    stage('Pre-Build') {
      steps {
        echo 'Cleaning workspace'
        sh 'mvn -B -q clean'
      }
    }
    stage('Build & Test') {
      steps {
        echo 'Running tests and verification (with JaCoCo check)'
        // prepare-agent + verify will run jacoco check configured in pom.xml
        sh 'mvn -B -q verify'
      }
      post {
        always {
          echo 'Archiving surefire reports and jacoco'
          archiveArtifacts artifacts: 'target/surefire-reports/**/*.xml', allowEmptyArchive: true
          archiveArtifacts artifacts: 'target/site/jacoco/**', allowEmptyArchive: true
          archiveArtifacts artifacts: 'target/site/pmd/**', allowEmptyArchive: true
        }
        success {
          junit 'target/surefire-reports/*.xml'
        }
        failure {
          echo 'Build or tests failed — coverage gate not reached or tests failing.'
        }
      }
    }
    stage('Quality Gate -> Trigger Image Build') {
      when {
        expression { return currentBuild.currentResult == 'SUCCESS' }
      }
      steps {
        echo 'Triggering Image_Docker job because coverage gate passed and build succeeded'
        build job: 'Image_Docker', wait: false
      }
    }
  }
  post {
    always {
      echo 'DEV pipeline finished'
    }
  }
}