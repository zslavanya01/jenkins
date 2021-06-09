folder('CI-Pipelines') {
    displayName('CI Pipelines')
    description('CI pipelines')
}


pipelineJob('CI-Pipelines/frontend-ci') {
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

pipelineJob("CI-Pipelines/frontend-ci") {
	description()
	keepDependencies(false)
	definition {
		cpsScm {
			scm {
				git {
					remote {
						github("zslavanya01/frontend", "https")
					}
					branch("*/main")
					branch("**/tags/**")
				}
			}
			scriptPath("Jenkinsfile")
		}
	}
	disabled(false)
}


pipelineJob('CI-Pipelines/login-ci') {
    configure { flowdefination ->
      flowdefination << delegate. 'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps'){
          'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
              'userRemoteConfigs' {
                  'hudson.plugins.git.UserRemoteConfig' {
                      'url'('https://github.com/zslavanya01/login.git')
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

pipelineJob('CI-Pipelines/todo-ci') {
    configure { flowdefination ->
      flowdefination << delegate. 'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps'){
          'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
              'userRemoteConfigs' {
                  'hudson.plugins.git.UserRemoteConfig' {
                      'url'('https://github.com/zslavanya01/todo.git')
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

pipelineJob('CI-Pipelines/users-ci') {
    configure { flowdefination ->
      flowdefination << delegate. 'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps'){
          'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
              'userRemoteConfigs' {
                  'hudson.plugins.git.UserRemoteConfig' {
                      'url'('https://github.com/zslavanya01/users.git')
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

pipelineJob('CI-Pipelines/redis-ci') {
    configure { flowdefination ->
      flowdefination << delegate. 'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps'){
          'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
              'userRemoteConfigs' {
                  'hudson.plugins.git.UserRemoteConfig' {
                      'url'('https://github.com/zslavanya01/redis.git')
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