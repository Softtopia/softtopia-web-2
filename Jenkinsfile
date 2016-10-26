node {
    def nodeHome = tool name: 'node-4.4.5', type: 'jenkins.plugins.nodejs.tools.NodeJSInstallation'
    env.PATH = "${nodeHome}/bin:${env.PATH}"

    def javaHome = tool name: 'Java8', type: 'jdk'
    env.PATH = "${javaHome}/bin:${env.PATH}"

    stage 'check environment'
    sh "node -v"
    sh "npm -v"
    sh "bower -v"
    sh "gulp -v"

    stage 'checkout'
    checkout scm

    stage 'npm install'
    sh "npm install"

    stage 'clean'
    sh "./mvnw clean"

//    stage 'backend tests'
//    sh "./mvnw test"
//
//    stage 'frontend tests'
//    sh "gulp test"

//    stage 'packaging'
//    sh "./mvnw package -DskipTests=true -B -Pprod"

    stage 'deploy to Heroku'
    sh "HEROKU_API_KEY=\"5437f2e9-34b2-42a0-9670-638e4bc078f9\" ./mvnw -B -Pprod -DskipTests=true heroku:deploy"
}
