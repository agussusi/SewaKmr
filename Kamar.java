
public class Kamar {
	private String name;
	private int price;
	
	
	public String getName() {
		return name;
	}

	public void SetName(String name) {
		this.name= name;
	}

	public int getPrice() {
		return price;
	}

	public void SetPrice(int price) {
		this.price= price;
	}
	
	//inisialisasi artibut dengan method constructor
	public Kamar(String name, int price) {
		this.name=name;
		this.price=price;
	}
	
	//overloading	
	public Kamar(int harga, String name) {
		this.name=name;
		this.price=harga;
	}
	
	public Kamar () {
		
	}	
}
