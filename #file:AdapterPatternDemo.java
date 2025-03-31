/**
 * Demonstrates the Adapter Design Pattern by adapting a LegacyRectangle
 * to work with the Shape interface.
 */
public class AdapterPatternDemo {
  public static void main(String[] args) {
    // Create a Circle instance
    Shape circle = new Circle();

    // Create a RectangleAdapter instance to adapt LegacyRectangle
    Shape rectangle = new RectangleAdapter(new LegacyRectangle(), 10.0, 5.0);

    // Draw and calculate the area of the Circle
    circle.draw();
    System.out.println("Área del círculo: " + circle.area());

    // Draw and calculate the area of the Rectangle
    rectangle.draw();
    System.out.println("Área del rectángulo: " + rectangle.area());
  }
}

/**
 * Represents a generic shape with methods to draw and calculate its area.
 */
interface Shape {
  /**
   * Draws the shape.
   */
  void draw();

  /**
   * Calculates the area of the shape.
   * 
   * @return the area of the shape as a Double.
   */
  Double area();
}

/**
 * Represents a Circle that implements the Shape interface.
 */
class Circle implements Shape {
  @Override
  public void draw() {
    System.out.println("🔵 Dibujando un CÍRCULO");
  }

  @Override
  public Double area() {
    return Math.PI * 2; // Simplified area calculation for demonstration
  }
}

/**
 * Represents a legacy rectangle with its own drawing method.
 */
class LegacyRectangle {
  /**
   * Draws the rectangle using the legacy method.
   */
  public void drawRectangle() {
    System.out.println("🟦 Dibujando un RECTÁNGULO");
  }
}

/**
 * Adapts a LegacyRectangle to the Shape interface.
 */
class RectangleAdapter implements Shape {
  private LegacyRectangle rectangle;
  private Double longitud;
  private Double ancho;

  /**
   * Constructs a RectangleAdapter with a LegacyRectangle and dimensions.
   * 
   * @param rectangle the LegacyRectangle to adapt.
   * @param longitud  the length of the rectangle.
   * @param ancho     the width of the rectangle.
   */
  public RectangleAdapter(LegacyRectangle rectangle, Double longitud, Double ancho) {
    this.rectangle = rectangle;
    this.longitud = longitud;
    this.ancho = ancho;
  }

  @Override
  public void draw() {
    rectangle.drawRectangle();
  }

  @Override
  public Double area() {
    return longitud * ancho;
  }
}
