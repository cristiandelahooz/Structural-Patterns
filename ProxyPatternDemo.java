public class ProxyPatternDemo {
	public static void main(String[] args) {
		Image image1 = new ProxyImage("photo1.jpg");
		Image image2 = new ProxyImage("photo2.jpg");

		// Image is loaded only when display() is called
		System.out.println(">>> First request to display image1:");
		image1.display();

		System.out.println("\n>>> Second request to display image1:");
		image1.display();  // No reloading required

		System.out.println("\n>>> First request to display image2:");
		image2.display();
	}
}
// 🔹 1. Subject: Common interface for real and proxy objects
interface Image {
	void display();
}

// 🔹 2. Real Subject: Loads an image from disk
class RealImage implements Image {
	private String filename;

	public RealImage(String filename) {
		this.filename = filename;
		loadFromDisk();  // Simulates a costly operation
	}

	private void loadFromDisk() {
		System.out.println("🔄 Loading image: " + filename);
	}

	@Override
	public void display() {
		System.out.println("🖼️ Displaying image: " + filename);
	}
}

// 🔹 3. Proxy: Controls access to RealImage (Lazy Loading)
class ProxyImage implements Image {
	private RealImage realImage;
	private String filename;

	public ProxyImage(String filename) {
		this.filename = filename;
	}

	@Override
	public void display() {
		if (realImage == null) {
			realImage = new RealImage(filename);  // Loads image only when needed
		}
		realImage.display();
	}
}

// 🔹 4. Client Code
