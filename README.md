# uiautomator-gradle
Android uiautomator script project with gradle build system sample.

`build.gradle`

```
project.ext {
    // output jar file dir
    outDir = new File('build/bin')
}

jar {
    dependsOn configurations.runtime
    from {
        (configurations.compile - configurations.provided).collect {
            it.isDirectory() ? it : zipTree(it)
        }
    } {
        exclude "META-INF/*.SF"
        exclude "META-INF/*.DSA"
        exclude "META-INF/*.RSA"
    }
    doLast {
        println 'dex exec...'
        project.outDir.mkdir()
        tasks.dex.execute()
    }
}

task dex(dependsOn: jar, type:Exec) {
    println 'Building dex...'
    workingDir '.'
    commandLine ANDROID_HOME + '\\build-tools\\'+ BUILD_TOOL_VERSION + '\\' + 'dx.bat', '--dex', '--no-strict', '--multi-dex', '--output=' + project.outDir + '\\' + project.name + '.jar', jar.archivePath
}

```
