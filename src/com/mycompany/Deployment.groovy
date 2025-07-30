package com.mycompany

class Deployment {
	def steps
	def config

	Deployment(steps) {
	    this.steps = steps
	    this.config = config
	}
	
	def run(String env, String customImage = null) {
	    def envConfig = config[env]
	    if(!envvConfig) {
		steps.error("No configuration found for environment: ${env}")
	    }
	    def imageToUse = customImage ?: envConfig.image

	    steps.echo "Deploying ${env} with image ${imageToUse}"
	    steps.sh "docker rm -f ${env}-container || true"
	    steps.sh "docker run -d --name ${env}-container -e ENV=${env} ${imageToUse}"
	}
}
