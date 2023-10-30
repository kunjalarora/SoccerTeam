// Powered by Infostretch 

timestamps {

node () {

	stage ('JavaSoccerTeam - Checkout') {
 	 checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'ee24e61d-bb21-47f0-81e1-a9cc76484f1a', url: 'https://github.com/kunjalarora/SoccerTeam']]]) 
	}
	stage ('JavaSoccerTeam - Build') {
 			// Shell build step
sh """ 
echo $PATH
mvn clean install
mvn package 
 """		// Shell build step
sh """ 
java -cp target/SoccerTeam-1.0-SNAPSHOT.jar Main 
 """ 
	}
}
}