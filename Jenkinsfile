node{
    
     stage('Initialize')
    {
        def dockerHome = tool 'docker'
        def mavenHome  = tool 'maven'
        env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
    }
       stage('SCM Checkout'){
           git 'https://github.com/JayeshKHazari/springbootswagger.git'
       }
       stage('MVN Package'){
           def mvnHome = tool name: 'maven', type: 'maven'
           def mvnCMD = "${mvnHome}/bin/mvn"
           sh "${mvnCMD} clean package"
           def dockerHome = tool 'docker'
           env.PATH = "${dockerHome}/bin:${mvnHome}/bin:${env.PATH}"
       }
stage('Build Docker Image'){
     sh 'docker build -t jayukhazari/my-app:2.0.0 .'
   }
}
