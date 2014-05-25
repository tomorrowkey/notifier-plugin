package jp.tomorrowkey.gradle.notifier.player

import javax.sound.sampled.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

public class WavePlayer implements Player {

    @Override
    void play(String filePath) {
        CountDownLatch countDownLatch = new CountDownLatch(1)
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            final Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);
            clip.addLineListener(new LineListener() {
                @Override
                void update(LineEvent event) {
                    if (event.type == LineEvent.Type.STOP) {
                        clip.stop()
                        countDownLatch.countDown()
                    }
                }
            })
            clip.start()
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        countDownLatch.await(10, TimeUnit.SECONDS);
    }
}
