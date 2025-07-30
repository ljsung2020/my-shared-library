@Grab('org.yaml:snakeyaml:1.30')
import org.yaml.snakeyaml.Yaml

def call(String env, String customImage = null) {
    def configText = libraryResource('config.yaml')
    def config = new Yaml().load(configText)

    // steps 객체를 다시 전달
    def deployer = new com.mycompany.Deployment(this, config)
    deployer.run(env, customImage)
}

