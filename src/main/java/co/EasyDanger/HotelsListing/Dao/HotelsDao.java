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
	
//	public List<Hotel> findByPrice(String city) {
//		return em.createQuery("FROM Hotel WHERE city = :City", Hotel.class).setParameter("City", city).getResultList();
//	}

	public List<String[]> findCityStates() {
		List<String> cities = em.createQuery("SELECT DISTINCT city FROM Hotel", String.class).getResultList();
		List<String> states = new ArrayList<String>();
		List<String[]> cityState = new ArrayList<String[]>();
		for (String city : cities) {
			String state = em.createQuery("SELECT DISTINCT state FROM Hotel WHERE city = :City", String.class)
					.setParameter("City", city).getSingleResult();
			states.add(state);
		}
		for (int i = 0; i < cities.size(); i++) {
			String[] both = new String[] {cities.get(i), states.get(i)};
			cityState.add(both);
		}
		return cityState;
	}
}
