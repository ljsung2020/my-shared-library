package com.mycompany

class Deployment {

    def run(String env, def config, String customImage = null) {
        def envConfig = config[env]
        if (!envConfig) {
            error("❌ No configuration found for environment: ${env}")
        }

        // customImage 있으면 우선, 없으면 config.yaml 값
        def imageToUse = customImage ?: envConfig.image

        echo "▶️ Deploying ${env} with image ${imageToUse}"
        sh "docker rm -f ${env}-container || true"
        sh "docker run -d --name ${env}-container -e ENV=${env} ${imageToUse}"
    }
}

