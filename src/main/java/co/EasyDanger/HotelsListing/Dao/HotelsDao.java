package co.EasyDanger.HotelsListing.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.EasyDanger.HotelsListing.Entity.Hotel;

@Repository
@Transactional
public class HotelsDao {

	@PersistenceContext
	private EntityManager em;

	public List<Hotel> findAll() {
		return em.createQuery("FROM Hotel", Hotel.class).getResultList();
	}

	public List<Hotel> findByCity(String city) {
		return em.createQuery("FROM Hotel WHERE city = :City", Hotel.class).setParameter("City", city).getResultList();
	}

	// Step 1, create a list of unique city names to populate the menu, making it
	// scalable and automatic.
	// Step 2, realize that the city names look dumb without a state next to them.
	// Step 3, fail to realize that making the menu automatic also means the names
	// of the form options don't matter.
	// Step 4, fail at making a list of arrays or a list of lists in attempts to
	// combine city and state names into a single, transferable unit, organized by
	// city name, because Hibernate doesn't like that.
	// Step 5, spend half an hour ensuing a list of arrays, so that cities and
	// states can be separated after being transfered together.
	// Step 6, fail at realizing a map would've been just as useful to populate the
	// menu, but justify it by saying the list of arrays will be useful later for
	// something and mutter something about being less resource intensive.
	public List<String[]> findCityStates() {
		//This word "DISTINCT" is so very important! Here, we get a complete list of unique city names.
		List<String> cities = em.createQuery("SELECT DISTINCT city FROM Hotel", String.class).getResultList();
		//Let's prep alist of state names. There's a lopp a-comin'. 
		List<String> states = new ArrayList<String>();
		//Might as well create our returning list while we're at it.
		List<String[]> cityState = new ArrayList<String[]>();
		//This loop iterated though and populates the list of each state according to the same index as the corresponding city in the cities list. This is important, because some cities have the same state and only making the list of distinct state lists would make it difficult to realign them after this.
		for (String city : cities) {
			String state = em.createQuery("SELECT DISTINCT state FROM Hotel WHERE city = :City", String.class)
					.setParameter("City", city).getSingleResult();
			//Each state name is added to the list in the order of it's corresponding city.
			states.add(state);
		}
		//Now the fun part! We make an array that stores each city/state combo. Not we can call them separately in the menu, allowing us to only use the city names as names for the form! This was necessary, I'm sure of it!
		for (int i = 0; i < cities.size(); i++) {
			String[] both = new String[] { cities.get(i), states.get(i) };
			cityState.add(both);
		}
		return cityState;
	//After all that, and realizing halfway through that I was just making more work for myself than necessary, I tried to justify this method by saying I could always expand it out. Include the hotel name, and price, too. That way, I could use it to populate the other page's list, too. Then I realized I was trying to reinvent Objects and walked away from my computer.
	}
}
