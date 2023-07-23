
public class Kamar {
	private String name;
	private int price;
	private String id;
	
	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public Kamar(String id) {
		this.id=id;
	}
	
	public Kamar(String id, String name, int price) {
		this.id = id;
		this.name=name;
		this.price=price;
	}
		
	public Kamar(int harga, String name) {
		this.name=name;
		this.price=harga;
	}
}
