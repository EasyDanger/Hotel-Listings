package co.EasyDanger.HotelsListing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.EasyDanger.HotelsListing.Dao.HotelsDao;
import co.EasyDanger.HotelsListing.Entity.Hotel;
import co.EasyDanger.HotelsListing.Entity.SortPrice;

//Comments! Remember my comments!? We're back!
//Frankly not much to say, though. Most of this stuff was just rote copying from previous projects.

@Controller
public class HotelListingController {

	// I don't know if it's distracting or not that I name my variables this way. To
	// me, it still points to the idea of what it is/does, but with slightly less
	// unnecessary typing.
	@Autowired
	private HotelsDao hotDao;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		// This was kind of neat. We can talk about it over in the HotelsDao, though,
		// because of ABSTRACTION!
		mv.addObject("Both", hotDao.findCityStates());
		return mv;
	}

	@RequestMapping("/hotels")
	// I set the city to not be required because I'm still considering adding other
	// parameters from which to organize the list. As is, there's no way around it.
	// Even navigating to "/hotels" will just spit out the whole list.
	public ModelAndView hotels(@RequestParam(name = "City", required = false) String city) {
		ModelAndView mv = new ModelAndView("hotelslist");
		List<Hotel> hotels = new ArrayList<Hotel>();
		if (city == null || city.equals("") || city.equals("All")) {
			hotels = hotDao.findAll();
			Collections.sort(hotels, new SortPrice());
		} else {
			hotels = hotDao.findByCity(city);
			Collections.sort(hotels, new SortPrice());
		}
		mv.addObject("Hotels", hotels);
		mv.addObject("Both", hotDao.findCityStates());
		return mv;
	}
}
