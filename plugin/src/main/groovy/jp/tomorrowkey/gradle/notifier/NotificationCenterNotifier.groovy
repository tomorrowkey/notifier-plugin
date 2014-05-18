package jp.tomorrowkey.gradle.notifier

public class NotificationCenterNotifier implements Notifier {

    Commander commander;

    public void performNotify(task, state) {
        commander = new Commander(task.logger)

        def title = "Gradle task"

        if (state.failure) {
            growl(title, "$task.name task is failed")
        } else {
            growl(title, "$task.name task is finished")
        }
    }

    void growl(String title, String message) {
        commander.execute("osascript", "-e", "display notification \"${message}\" with title \"${title}\"")
    }

}
