@Grab('org.yaml:snakeyaml:1.30')
import org.yaml.snakeyaml.Yaml

def call(String env) {
	def configText = libraryResource('config.yaml')
	def yaml = new Yaml()
	def config = yaml.load(configText)
	
	def envConfig = config[env]
	echo "Deploying ${env} with image ${envConfig.image}"
	sh "docker rm -f ${env}-container || true"
	sh "docker run -d --name ${env}-container -e ENV=${env} ${envConfig.image}"
//	def deployer = new com.mycompany.Deployment(this)
//	deployer.run(env)
}
