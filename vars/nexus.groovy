def nexus(COMPONENT) {
    get_branch = "env | grep GIT_BRANCH | awk -F / '{print \$NF}' | xargs echo -n"
    def get_branch_exec=sh(returnStdout: true, script: get_branch)
    def FILENAME=COMPONENT+'-'+get_branch_exec+'.zip'
    
    command = "curl -f -v -u admin:admin123 --upload-file ${FILENAME} http://172.31.13.117:8081/repository/${COMPONENT}/${FILENAME}"
    def execute_state=sh(returnStdout: true, script: command)
    manager.addShortText("deployed")
}

def make_artifacts(APP_TYPE, COMPONENT) {
    get_branch = "env | grep GIT_BRANCH | awk -F / '{print \$NF}' | xargs echo -n"
    def get_branch_exec=sh(returnStdout: true, script: get_branch)
    def FILENAME=COMPONENT+'-'+get_branch_exec+'.zip'
    if(APP_TYPE == "NGINX") {
        command = "zip -r ${FILENAME} ."
        def execute_com=sh(returnStdout:true, script: command)
        print execute_com
    } else if(APP_TYPE == "NODEJS") {
      command = "zip -r ${FILENAME} *"
      def execute_com=sh(returnStdout: true, script: command)
      print execute_com
    } else if(APP_TYPE == "JAVA") {
      command = "zip -r ${FILENAME} *"
      def execute_com=sh(returnStdout: true, script: command)
      print execute_com
    }
}


def code_build(APP_TYPE, COMPONENT) {
    if(APP_TYPE == "NGINX") {
        command = "npm install && sudo npm install -g npm@latest && npm run build"
        command = "env"
        def execute_com=sh(returnStdout:true, script: command)
        print execute_com
    } else if(APP_TYPE == "JAVA") {
      command = "mvn clean package"
      def execute_com=sh(returnStdout: true, script: command)
      print execute_com
    }
}