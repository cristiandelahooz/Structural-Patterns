public class AdapterPatternDemo {
  public static void main(String[] args) {
    Shape circle = new Circle();

    Shape rectangle = new RectangleAdapter(new LegacyRectangle(), 10.0, 5.0);

    circle.draw();
    System.out.println("Área del círculo: " + circle.area());
    rectangle.draw();
    System.out.println("Área del rectángulo: " + rectangle.area());
  }
}

interface Shape {
  void draw();

  Double area();
}

class Circle implements Shape {
  @Override
  public void draw() {
    System.out.println("🔵 Dibujando un CÍRCULO");
  }

  @Override
  public Double area() {
    return Math.PI * 2;
  }
}

class LegacyRectangle {
  public void drawRectangle() {
    System.out.println("🟦 Dibujando un RECTÁNGULO");
  }
}

class RectangleAdapter implements Shape {
  private LegacyRectangle rectangle;
  private Double longitud;
  private Double ancho;

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
