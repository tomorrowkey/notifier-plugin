package jp.tomorrowkey.gradle.notifier

import org.gradle.api.Project

public class NotifiersFactory {

    private static final String CONFIG_FILE_PATH = "notifier.groovy";

    public static Notifier[] create(Project project) {
        return create(project, getConfig(CONFIG_FILE_PATH))
    }

    static ConfigObject getConfig(String configFilePath) {
        def file = new File(configFilePath);
        if (file.exists()) {
            return new ConfigSlurper().parse(file.toURI().toURL());
        } else {
            return new ConfigObject();
        }
    }

    static Notifier[] create(Project project, ConfigObject config) {
        def notifiers = []

        if (config.voice.enabled) {
            notifiers.add(new VoiceNotifier(config.voice.name))
        }

        if (config.notificationCenter.enabled) {
            notifiers.add(new NotificationCenterNotifier())
        }

        if (config.sound.enabled) {
            notifiers.add(new SoundNotifier(project, config.sound.url))
        }

        if (config.beep.enabled) {
            if (config.beep.count instanceof Integer) {
                notifiers.add(new BeepNotifier(config.beep.count));
            } else {
                notifiers.add(new BeepNotifier());
            }

        }

        return notifiers;
    }
}
