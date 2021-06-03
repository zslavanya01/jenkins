def nexus() {
    command = "curl -f -v -u admin:admin123 --upload-file /home/ubuntu/workspace/CI-Pipelines/frontend.zip http://${NEXUS_IP}:8081/repository/frontend/frontend1.zip"
    def execute_state=sh(returnStdout: true, script: command)
}

def make_artifacts(APP_TYPE,COMPONENT) {
    if(APP_TYPE == "NGINX") {
        command = "zip -r ../${COMPONENT}.zip *"
        def execute_com=sh(returnStdout: true, script: command)
        print execute_com
    } else if(APP_TYPE == "NODEJS") {
      command = "zip -r ../${COMPONENT}.zip *"
      def execute_com=sh(returnStdout: true, script: command)
      print execute_com
    } else if(APP_TYPE == "JAVA") {
      command = "zip -r ../${COMPONENT}.zip *"
      def execute_com=sh(returnStdout: true, script: command)
      print execute_com
    }
}