package jp.tomorrowkey.gradle.notifier

public class VoiceNotifier implements Notifier {

    Commander commander;

    String voice

    public VoiceNotifier(voice) {
        this.voice = voice
    }

    public void performNotify(task, state) {
        commander = new Commander(task.logger)

        def command
        if (state.failure) {
            commander.execute("say", "-v", "$voice", "'$task.name task is failed'")
        } else {
            commander.execute("say", "-v", "$voice", "'$task.name task is finished'")
        }
    }
}
