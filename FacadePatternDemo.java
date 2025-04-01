// Cliente usa la fachada en vez de interactuar con las clases internas
/**
 * Main class to demonstrate the Facade Pattern.
 * The client interacts with the MusicFacade to play music
 * without needing to know the details of the subsystems.
 */
public class Main {
  public static void main(String[] args) {
    MusicFacade music = new MusicFacade();
    music.playMusic("song.mp3", "Rock");
  }
}

// Facade que simplifica el acceso
/**
 * MusicFacade provides a simplified interface to interact with
 * the audio subsystems (AudioDecoder, AudioPlayer, and Equalizer).
 */
class MusicFacade {
  private AudioDecoder decoder = new AudioDecoder();
  private AudioPlayer player = new AudioPlayer();
  private Equalizer equalizer = new Equalizer();

  /**
   * Plays music by decoding the file, setting the equalizer preset,
   * and then playing the file.
   * 
   * @param file   The name of the audio file to play.
   * @param preset The equalizer preset to use.
   */
  void playMusic(String file, String preset) {
    decoder.decode(file);
    equalizer.setPreset(preset);
    player.play(file);
  }
}

// Subsistema 1
/**
 * AudioDecoder is responsible for decoding audio files.
 */
class AudioDecoder {
  /**
   * Decodes the given audio file.
   * 
   * @param file The name of the audio file to decode.
   */
  void decode(String file) {
    System.out.println("Decodificando archivo: " + file);
  }
}

// Subsistema 2
/**
 * AudioPlayer is responsible for playing audio files.
 */
class AudioPlayer {
  /**
   * Plays the given audio file.
   * 
   * @param file The name of the audio file to play.
   */
  void play(String file) {
    System.out.println("Reproduciendo: " + file);
  }
}

// Subsistema 3
/**
 * Equalizer is responsible for setting audio presets.
 */
class Equalizer {
  /**
   * Sets the equalizer preset.
   * 
   * @param preset The name of the preset to configure.
   */
  void setPreset(String preset) {
    System.out.println("Configurando ecualizador: " + preset);
  }
}
