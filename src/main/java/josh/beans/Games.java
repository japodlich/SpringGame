package josh.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Games 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String type;
	private double price;
	
	public Games() {
		super();
	}

	public Games(String name) {
		super();
		this.name = name;
	}

	public Games(String name, String type, double price) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public Games(long id, String name, String type, double price) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Games [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + "]";
	}
	
	
}
