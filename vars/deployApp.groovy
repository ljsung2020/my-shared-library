def call(String env) {
	def deployer = new com.mycompany.Deployment(this)
	deployer.run(env)
}
