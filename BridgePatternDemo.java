public class BridgePatternDemo {
    public static void main(String[] args) {
        // Usando BasicRemote con un TV
        Device tv = new TV();
        RemoteControl basicRemote = new BasicRemote(tv);
        basicRemote.togglePower();
        basicRemote.volumeUp();
        basicRemote.channelUp();

        System.out.println("\n---\n");

        // Usando AdvancedRemote con una Radio
        Device radio = new Radio();
        AdvancedRemote advancedRemote = new AdvancedRemote(radio);
        advancedRemote.togglePower();
        advancedRemote.volumeDown();
        advancedRemote.mute();
        advancedRemote.channelDown();
    }
}

interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int volume);
    int getVolume();
    void setChannel(int channel);
    int getChannel();
}

// Implementación concreta: TV
class TV implements Device {
    private boolean on = false;
    private int volume = 10;
    private int channel = 1;

    @Override
    public void turnOn() {
        on = true;
        System.out.println("TV: Encendida");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("TV: Apagada");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("TV: Volumen establecido a " + volume);
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("TV: Canal cambiado a " + channel);
    }

    @Override
    public int getChannel() {
        return channel;
    }
}

class Radio implements Device {
    private boolean on = false;
    private int volume = 5;
    private int channel = 101;

    @Override
    public void turnOn() {
        on = true;
        System.out.println("Radio: Encendida");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("Radio: Apagada");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Radio: Volumen establecido a " + volume);
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("Radio: Frecuencia cambiada a " + channel);
    }

    @Override
    public int getChannel() {
        return channel;
    }
}

// Abstracción: RemoteControl
abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void togglePower();

    public void volumeUp() {
        int volume = device.getVolume();
        device.setVolume(volume + 1);
    }

    public void volumeDown() {
        int volume = device.getVolume();
        device.setVolume(volume - 1);
    }

    public void channelUp() {
        int channel = device.getChannel();
        device.setChannel(channel + 1);
    }

    public void channelDown() {
        int channel = device.getChannel();
        device.setChannel(channel - 1);
    }
}

// Refinamiento de la abstracción: Control remoto básico
class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void togglePower() {
        System.out.println("BasicRemote: Alternando el estado de poder");
        // Para simplificar, simulamos encendido siempre
        device.turnOn();
    }
}

// Refinamiento de la abstracción: Control remoto avanzado
class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    @Override
    public void togglePower() {
        System.out.println("AdvancedRemote: Alternando el estado de poder");
        // Para simplificar, simulamos encendido siempre
        device.turnOn();
    }

    public void mute() {
        System.out.println("AdvancedRemote: Silenciando dispositivo");
        device.setVolume(0);
    }
}


