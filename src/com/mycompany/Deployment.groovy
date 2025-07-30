package com.mycompany

class Deployment {
	def steps

	Deployment(steps) {
	    this.steps = steps
	}
	
	def run(String env) {
	    steps.echo "Running Deployment for ${env}"
	    steps.sh "docker run -d --name ${env}-container -e ENV=${env} nginx:alpine"
	}
}
