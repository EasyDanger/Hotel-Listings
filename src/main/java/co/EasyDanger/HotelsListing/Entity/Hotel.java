package co.EasyDanger.HotelsListing.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotel_listing")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hotel_id")
	private Long id;
	@Column(name = "hotel_name")
	private String name;
	private String city;
	// Personally, i just kind of think city names look silly by themselves on
	// things like this without a state next to them. So, I added a state field. But
	// wait ... why not just add it to the city name field? That could get a bit
	// unwieldy later on when all I want is a short variable, ya know? Like in a
	// JSP?
	private String state;
	private Integer pricePerNight;

	public Hotel() {

	}

	public Long getId() {
		return id;
	}

	public Hotel(Long id, String name, String city, String state, Integer pricePerNight) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.state = state;
		this.pricePerNight = pricePerNight;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(Integer pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
