package geo;

public class DistanceDTO {
	private LatLngDTO srcCoord;
	private LatLngDTO[] destCoords;

	public DistanceDTO() {
	}

	public DistanceDTO(LatLngDTO srcCoord, LatLngDTO[] destCoords) {
		super();
		this.srcCoord = srcCoord;
		this.destCoords = destCoords;
	}

	public LatLngDTO getSrcCoord() {
		return srcCoord;
	}

	public void setSrcCoord(LatLngDTO srcCoord) {
		this.srcCoord = srcCoord;
	}

	public LatLngDTO[] getDestCoords() {
		return destCoords;
	}

	public void setDestCoords(LatLngDTO[] destCoords) {
		this.destCoords = destCoords;
	}

}
