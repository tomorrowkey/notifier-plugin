package jp.tomorrowkey.gradle.notifier

public class SoundNotifier implements Notifier {

    Commander commander

    def downloadFilePath

    def url

    public SoundNotifier(project, url) {
        this.downloadFilePath = "${project.buildDir}/notify_sound"
        this.url = url
    }

    public void performNotify(task, state) {
        commander = new Commander(task.logger)

        def url = new URL(this.url)
        def filePath

        if (url.protocol == "file") {
            filePath = url.path
        } else {
            filePath = download(url, downloadFilePath)
        }

        play(filePath)
    }

    def download(url, filePath) {
        def file = new File(filePath)
        file.parentFile.mkdirs()

        if(!file.exists()) {
            url.withInputStream { input ->
                file.bytes = input.bytes
            }
        }

        return filePath
    }

    def play(filePath) {
        commander.execute("afplay", filePath)
    }

}
