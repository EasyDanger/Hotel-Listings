package co.EasyDanger.HotelsListing;

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

@Controller
public class HotelListingController {

	@Autowired
	private HotelsDao hotDao;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("Both", hotDao.findCityStates());
		return mv;
	}

	@RequestMapping("/hotels")
	public ModelAndView hotels(@RequestParam(name = "City", required = false) String city) {
		ModelAndView mv = new ModelAndView("hotelslist");
		if (city.equals("All")) {
			List<Hotel> hotels = hotDao.findAll();
			Collections.sort(hotels, new SortPrice());
			return mv;
		}
		List<Hotel> hotels = hotDao.findByCity(city);
		Collections.sort(hotels, new SortPrice());
		mv.addObject("Hotels", hotels);
		mv.addObject("Both", hotDao.findCityStates());
		return mv;
	}
}
