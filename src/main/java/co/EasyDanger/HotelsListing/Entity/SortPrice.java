package co.EasyDanger.HotelsListing.Entity;

import java.util.Comparator;

public class SortPrice implements Comparator<Hotel> {

	// Used for sorting in ascending order of year
	public int compare(Hotel a, Hotel b) {
		return a.getPricePerNight() - b.getPricePerNight();
	}

}