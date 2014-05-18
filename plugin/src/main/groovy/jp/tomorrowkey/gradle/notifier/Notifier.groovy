package jp.tomorrowkey.gradle.notifier

public interface Notifier {
  void performNotify(task, state)
}
