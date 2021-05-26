folder('project-a') {
    displayName('Project A')
    description('Folder for project A')
}


pipelinejob('frontend-ci') {
    configure { flowdefination ->
      flowdefination << delegate. 'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps'){
          'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
              'userRemoteConfigs' {
                  'hudson.plugins.git.UserRemoteConfig' {
                      'url'('https://github.com/zslavanya01/frontend.git')
                  }
              }
              'branches' {
                  'hudson.plugins.git.BranchSpec' {
                      'name'('*/main')
                  }
              }
          }
          'scriptPath'('Jenkinsfile')
          'lightweight'(true)
        }

    }
}