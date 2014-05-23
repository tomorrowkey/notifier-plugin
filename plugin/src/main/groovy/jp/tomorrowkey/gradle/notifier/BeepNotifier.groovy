package jp.tomorrowkey.gradle.notifier

import java.awt.*

class BeepNotifier implements Notifier {

    def count;

    public BeepNotifier(count = 3) {
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