def nexus() {
    command = "curl -f -v -u admin:admin123 --upload-file /home/ubuntu/workspace/CI-Pipelines/frontend.zip http://${NEXUS_IP}:8081/repository/frontend/frontend1.zip"
    def execute_state=sh(returnStdout: true, script: command)
}

def make_artifacts(component) {
    if(component == "frontend") {
        command = "zip -r ../${component}.zip *"
        def execute_com=sh(returnStdout: true, script: command)
        print execute_com
    }
}