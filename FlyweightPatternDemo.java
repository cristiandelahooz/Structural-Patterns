/**
 * Flyweight pattern example in a video game scenario.
 * This example optimizes memory usage by sharing intrinsic state between particles.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight interface: Defines the common interface for all flyweight objects.
 */
interface Particle {
    void render(int x, int y, String direction, int speed);
}

/**
 * Concrete Flyweight: Implements the Flyweight interface and stores intrinsic state.
 */
class Bullet implements Particle {
    private final String color = "Yellow";
    private final String sprite = "Bullet Sprite";

    @Override
    public void render(int x, int y, String direction, int speed) {
        System.out.println("Rendering Bullet at (" + x + ", " + y + ") "
                + "Direction: " + direction + " Speed: " + speed);
    }
}

class Missile implements Particle {
    private final String color = "Red";
    private final String sprite = "Missile Sprite";

    @Override
    public void render(int x, int y, String direction, int speed) {
        System.out.println("Rendering Missile at (" + x + ", " + y + ") "
                + "Direction: " + direction + " Speed: " + speed);
    }
}

class Shrapnel implements Particle {
    private final String color = "Gray";
    private final String sprite = "Shrapnel Sprite";

    @Override
    public void render(int x, int y, String direction, int speed) {
        System.out.println("Rendering Shrapnel at (" + x + ", " + y + ") "
                + "Direction: " + direction + " Speed: " + speed);
    }
}

/**
 * Flyweight Factory: Manages a pool of flyweight objects.
 */
class ParticleFactory {
    private static final Map<String, Particle> particleMap = new HashMap<>();

    public static Particle getParticle(String type) {
        Particle particle = particleMap.get(type);

        if (particle == null) {
            switch (type) {
                case "Bullet":
                    particle = new Bullet();
                    break;
                case "Missile":
                    particle = new Missile();
                    break;
                case "Shrapnel":
                    particle = new Shrapnel();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown particle type: " + type);
            }
            particleMap.put(type, particle);
            System.out.println("Creating a new " + type);
        }
        return particle;
    }
}

/**
 * Client: Uses the Flyweight Factory to create and render particles efficiently.
 */
public class FlyweightPatternDemo {
    public static void main(String[] args) {
        String[] particleTypes = {"Bullet", "Missile", "Shrapnel", "Bullet", "Missile", "Shrapnel"};
        int[][] positions = {{10, 20}, {30, 40}, {50, 60}, {70, 80}, {90, 100}, {110, 120}};
        String[] directions = {"North", "South", "East", "West", "North-East", "South-West"};
        int[] speeds = {10, 20, 30, 40, 50, 60};
        for (int i = 0; i < particleTypes.length; i++) {
            Particle particle = ParticleFactory.getParticle(particleTypes[i]);
            particle.render(positions[i][0], positions[i][1], directions[i], speeds[i]);
        }
    }
}
