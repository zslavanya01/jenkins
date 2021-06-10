folder('CI-Pipelines') {
    displayName('CI Pipelines')
    description('CI pipelines')
}


pipelineJob('CI-Pipelines/frontend-ci') {
    configure { flowdefination ->
      flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
        'triggers' {
           'hudson.triggers.SCMTrigger' {
             'spec'('* * * * 1-5')
             'ignorePostCommitHooks'(false)
            }
        }
      }

        flowdefination << delegate. 'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps'){
          'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
              'userRemoteConfigs' {
                  'hudson.plugins.git.UserRemoteConfig' {
                      'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
                      'url'('https://github.com/zslavanya01/frontend.git')
                    }
                }
               'branches' {
                  'hudson.plugins.git.BranchSpec' {
                      'name'('*/tags/*')
                    }
                }
            }
          'scriptPath'('Jenkinsfile')
          'lightweight'(true)
        }

    }
 }
}


pipelineJob('CI-Pipelines/login-ci') {
    configure { flowdefination ->
      flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
        'triggers' {
           'hudson.triggers.SCMTrigger' {
             'spec'('* * * * 1-5')
             'ignorePostCommitHooks'(false)
            }
        }
    }
    flowdefination << delegate. 'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps'){
          'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
              'userRemoteConfigs' {
                  'hudson.plugins.git.UserRemoteConfig' {
                      'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
                      'url'('https://github.com/zslavanya01/login.git')
                    }
                }
              'branches' {
                  'hudson.plugins.git.BranchSpec' {
                      'name'('*/tags/*')
                    }
                }
            }
          'scriptPath'('Jenkinsfile')
          'lightweight'(true)
        }

    }
 }
}
pipelineJob('CI-Pipelines/todo-ci') {
    configure { flowdefination ->
      flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
        'triggers' {
           'hudson.triggers.SCMTrigger' {
             'spec'('* * * * 1-5')
             'ignorePostCommitHooks'(false)
            }
        }
    }
    flowdefination << delegate. 'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps'){
          'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
              'userRemoteConfigs' {
                  'hudson.plugins.git.UserRemoteConfig' {
                      'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
                      'url'('https://github.com/zslavanya01/todo.git')
                    }
                }
              'branches' {
                  'hudson.plugins.git.BranchSpec' {
                      'name'('*/tags/*')
                    }
                }
            }
          'scriptPath'('Jenkinsfile')
          'lightweight'(true)
        }

    }
 }
}

pipelineJob('CI-Pipelines/users-ci') {
    configure { flowdefination ->
     flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
        'triggers' {
           'hudson.triggers.SCMTrigger' {
             'spec'('* * * * 1-5')
             'ignorePostCommitHooks'(false)
            }
        }
    }
    flowdefination << delegate. 'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps'){
          'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
              'userRemoteConfigs' {
                  'hudson.plugins.git.UserRemoteConfig' {
                      'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
                      'url'('https://github.com/zslavanya01/users.git')
                    }
                }
              'branches' {
                  'hudson.plugins.git.BranchSpec' {
                      'name'('*/tags/*')
                    }  
                }
            }
          'scriptPath'('Jenkinsfile')
          'lightweight'(true)
        }

    }
 }
}

pipelineJob('CI-Pipelines/redis-ci') {
    configure { flowdefination ->
       flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
        'triggers' {
           'hudson.triggers.SCMTrigger' {
             'spec'('* * * * 1-5')
             'ignorePostCommitHooks'(false)
            }
        }
    }
    flowdefination << delegate. 'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps'){
          'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
              'userRemoteConfigs' {
                  'hudson.plugins.git.UserRemoteConfig' {
                      'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
                      'url'('https://github.com/zslavanya01/redis.git')
                    }
                }
              'branches' {
                  'hudson.plugins.git.BranchSpec' {
                      'name'('*/tags/*')
                    }
                }
            }
          'scriptPath'('Jenkinsfile')
          'lightweight'(true)
        }

    }
 }
}