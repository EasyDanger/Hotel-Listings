package co.EasyDanger.HotelsListing.Entity;

import java.util.Comparator;

public class SortPrice implements Comparator<Hotel> {

	// Last project where I had to sort lists, I started out by writing the method
	// to make that happen. 17,000 null pointer exceptions later, I remembered that
	// somebody else already did that, so I never have to do it again. Standing on
	// the shoulders of giants.
	public int compare(Hotel a, Hotel b) {
		return a.getPricePerNight() - b.getPricePerNight();
	}

}