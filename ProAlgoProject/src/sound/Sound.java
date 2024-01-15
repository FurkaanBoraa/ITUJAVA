package sound;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class Sound {
	private final URL shoot;
	private final URL damage;
	private final URL destroy;

	public Sound() {
		this.shoot = this.getClass().getClassLoader().getResource("sound/Shoot.wav");
		this.damage = this.getClass().getClassLoader().getResource("sound/damage.wav");
		this.destroy = this.getClass().getClassLoader().getResource("sound/destroy.wav");
	}

	public void soundShoot() {
		play(shoot);
	}

	public void soundDamage() {
		play(damage);
	}

	public void soundDestroy() {
		play(destroy);
	}

	private void play(URL url) {
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(url);
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			clip.addLineListener(new LineListener() {
				@Override
				public void update(LineEvent event) {
					if (event.getType() == LineEvent.Type.STOP) {
						clip.close();
					}
				}
			});
			audio.close();
			clip.start();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
