def nexus() {
    command = "curl -f -v -u admin:admin123 --upload-file /home/ubuntu/workspace/CI-Pipelines/frontend.zip http://172.31.13.117:8081/repository/frontend/frontend1.zip"
}