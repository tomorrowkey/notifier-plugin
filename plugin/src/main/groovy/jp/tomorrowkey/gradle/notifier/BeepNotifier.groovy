package jp.tomorrowkey.gradle.notifier

import java.awt.*

class BeepNotifier implements Notifier {

    int count;

    public BeepNotifier(int count) {
        this.count = count;
    }

    @Override
    void performNotify(Object task, Object state) {
        def toolkit = Toolkit.getDefaultToolkit();
        count.times {
            toolkit.beep()
            sleep(100)
        }
    }
}