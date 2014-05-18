package jp.tomorrowkey.gradle.notifier

import org.gradle.api.Project

public class NotifiersFactory {

    private static final String CONFIG_FILE_PATH = "notifier.groovy";

    public static Notifier[] create(Project project) {
        return create(project, getConfig(CONFIG_FILE_PATH))
    }

    static ConfigObject getConfig(String configFilePath) {
        return new ConfigSlurper().parse(new File(configFilePath).toURL())
    }

    static Notifier[] create(Project project, ConfigObject config) {
        def notifiers = []

        if(config.voice.enabled) {
            notifiers.add(new VoiceNotifier(config.voice.name))
        }

        if(config.notificationCenter.enabled) {
            notifiers.add(new NotificationCenterNotifier())
        }

        if(config.sound.enabled) {
            notifiers.add(new SoundNotifier(project, config.sound.url))
        }

        return notifiers;
    }
}
