package jp.tomorrowkey.gradle.notifier

import org.gradle.api.Plugin
import org.gradle.api.Project

// see http://www.gradle.org/docs/current/userguide/custom_plugins.html

public class NotifierPlugin implements Plugin<Project> {

    def notifiers = []

    @Override
    void apply(Project project) {
        notifiers = NotifiersFactory.create(project)

        project.gradle.taskGraph.afterTask { task, state ->
            def tasks = project.gradle.taskGraph.allTasks

            if (tasks.isEmpty()) {
                return;
            }

            def lastTask = tasks.last()
            if (!lastTask.equals(task)) {
                return;
            }

            performNotify(task, state)
        }
    }

    void performNotify(task, state){
        notifiers.each() { notifier ->
            notifier.performNotify(task, state)
        }
    }
}
