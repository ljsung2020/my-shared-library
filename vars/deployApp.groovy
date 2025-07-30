@Grab('org.yaml:snakeyaml:1.30')
import org.yaml.snakeyaml.Yaml

def call(String env, String customImage = null) {
    def configText = libraryResource('config.yaml')
    def config = new Yaml().load(configText)

    // steps 넘기지 않고 Deployment 호출
    def deployer = new com.mycompany.Deployment()
    deployer.run(env, config, customImage)
}

