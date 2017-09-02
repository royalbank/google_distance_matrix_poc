package geo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;

@RestController
@RequestMapping("/geo")
public class GeoController {

	@Autowired
	GeoService geoService;

	@RequestMapping(value = "/distances", method = RequestMethod.POST)
	public @ResponseBody DistanceMatrix getDistances(@RequestBody DistanceDTO distanceDTO) {

		return geoService.getDistances(distanceDTO.getSrcCoord().toModel(),
				LatLngDTO.toModels(distanceDTO.getDestCoords()));
	}
	
	@RequestMapping(value = "/coordinates", method = RequestMethod.GET)
	public @ResponseBody GeocodingResult[] getDistances(@RequestParam String address) {
		return geoService.getLatLng(address);
	}

	public GeoService getGeoService() {
		return geoService;
	}

	public void setGeoService(GeoService geoService) {
		this.geoService = geoService;
	}

}
