def call() {
	def artifactoryUrl = 'http://100.26.167.226:8082/artifactory/example-repo-local/'
	// def jarPath = "/var/lib/jenkins/workspace/Jfrog_pipeline/target/kubernetes-configmap-reload-0.0.1-SNAPSHOT.jar"
	def jarPath = "/home/ubuntu/Java_app_3.0/target/kubernetes-configmap-reload-0.0.1-SNAPSHOT.jar"
	def username='admin'
	def password='Admin@123' // Replace with your Artifactory password

	def curlCommand = """
		curl -X PUT -u $username: $password -T $jarPath $artifactoryUrl
	"""

	def process = curlCommand.execute()
	process.waitFor()


	if (process.exitValue() == 0) {
		println "Artifactory deployment successful!"
		} else {
			println "Artifactory deployment failed. Exit code: ${process.exitValue()}"
			println "Error Output: ${process.err.text}"
		}
	}
