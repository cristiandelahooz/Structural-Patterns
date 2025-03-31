import java.util.ArrayList;
import java.util.List;

/**
 * Component: Defines the interface for all objects in the composition.
 */
interface Graphic {
    void draw();
}

/**
 * Leaf: Represents leaf objects in the composition that do not have children.
 */
class Triangle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }
}

class Square implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

/**
 * Composite: Defines a complex component that can have children.
 */

class CompositeGraphic implements Graphic {
    private List<Graphic> children = new ArrayList<>();

    public void add(Graphic graphic) {
        children.add(graphic);
    }

    public void remove(Graphic graphic) {
        children.remove(graphic);
    }

    @Override
    public void draw() {
        for (Graphic graphic : children) {
            graphic.draw();
        }
    }
}

/**
 * Client: Uses the composite structure.
 */
public class CompositePatternDemo {
    public static void main(String[] args) {
        // Create leaf objects
        Graphic triangle1 = new Triangle();
        Graphic square1 = new Square();
        Graphic triangle2 = new Triangle();

        // Create a composite object
        CompositeGraphic composite = new CompositeGraphic();
        composite.add(triangle1);
        composite.add(square1);
        composite.add(triangle2);

        // Draw all components
        System.out.println("Drawing composite graphic:");
        composite.draw();
    }
}

