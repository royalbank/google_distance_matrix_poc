package geo;

import com.google.maps.model.LatLng;

public class LatLngDTO {
	private double lat;
	private double lng;

	public LatLngDTO() {
		super();
	}

	public LatLngDTO(double lat, double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}

	public LatLng toModel() {
		return new LatLng(this.getLat(), this.getLng());
	}

	public static LatLng[] toModels(LatLngDTO[] dtoArray) {
		LatLng[] results = new LatLng[dtoArray.length];
		for (int i = 0; i < dtoArray.length; i++) {
			results[i] = new LatLng(dtoArray[i].getLat(), dtoArray[i].getLng());
		}
		return results;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

}
