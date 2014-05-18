package jp.tomorrowkey.gradle.notifier

import org.junit.Test
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.TaskState

import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat
import static org.mockito.Mock.mock;

public class VoiceNotifierTest {

    @Test
    public void voiceIsAlexWhenMakeAInstanceWithNull() {
        VoiceNotifier notifier = new VoiceNotifier(null)
        assertThat(notifier.voice, is("Alex"))
    }

    @Test
    public void voiceIsGoodNewsWhenMakeAInstanceWithGoodNews() {
        VoiceNotifier notifier = new VoiceNotifier("Good News")
        assertThat(notifier.voice, is("Good News"))
    }

}
