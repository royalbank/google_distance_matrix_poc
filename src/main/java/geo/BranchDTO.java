package geo;

public class BranchDTO {
	private String name;
	private String address;
	private String postalCode;
	private String phone;
	private String transit;
	private long distanceInMeters;
	private double lat;
	private double lng;

	public BranchDTO(String name, String address, String postalCode, String phone, String transit, long distance,
			double lat, double lng) {
		super();
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
		this.phone = phone;
		this.transit = transit;
		this.distanceInMeters = distance;
		this.lat = lat;
		this.lng = lng;
	}

	public BranchDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTransit() {
		return transit;
	}

	public void setTransit(String transit) {
		this.transit = transit;
	}

	public long getDistance() {
		return distanceInMeters;
	}

	public void setDistance(long distance) {
		this.distanceInMeters = distance;
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
