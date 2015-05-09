package jp.tomorrowkey.gradle.notifier

import org.gradle.api.Project

public class NotifiersFactory {

    private static final String CONFIG_FILE_PATH = "notifier.properties";

    public static Notifier[] create(Project project) {
        Map config = getDefaultConfig()
        config.putAll(getConfig(new File(CONFIG_FILE_PATH)))
        create(project, config)
    }

    static Map getDefaultConfig() {
        def Map map = new HashMap()
        map.put('voice.enabled', false)
        map.put('voice.name', 'Alex')
        map.put('notificationCenter.enabled', false)
        map.put('sound.enabled', false)
        map.put('beep.enabled', false)
        map.put('beep.count', 3)
        return map
    }

    static Map getConfig(File configFile) {
        def props = new Properties();
        configFile.withInputStream {
            stream -> props.load(stream)
        }
        return props
    }

    static Notifier[] create(Project project, Map config) {
        def notifiers = []

        if (config.get('voice.enabled').toBoolean()) {
            notifiers.add(new VoiceNotifier(config.get('voice.name')))
        }

        if (config.get('notificationCenter.enabled').toBoolean()) {
            notifiers.add(new NotificationCenterNotifier())
        }

        if (config.get('sound.enabled').toBoolean()) {
            notifiers.add(new SoundNotifier(project, config.get('sound.url')))
        }

        if (config.get('beep.enabled').toBoolean()) {
            notifiers.add(new BeepNotifier(config.get('beep.count').toInteger()));
        }

        return notifiers;
    }
}
