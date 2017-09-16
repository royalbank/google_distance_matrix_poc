package geo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;

@RestController
@RequestMapping("/geo")
public class GeoController{

	@Autowired
	GeoService geoService;

	@RequestMapping(value = "/branches?search=distances", method = RequestMethod.POST)
	public @ResponseBody DistanceMatrix getDistances(@RequestBody DistanceDTO distanceDTO) {

		return geoService.getDistances(distanceDTO.getSrcCoord().toModel(),
				LatLngDTO.toModels(distanceDTO.getDestCoords()));
	}

	@RequestMapping(value = "/branches?search=nearby", method = RequestMethod.POST)
	public @ResponseBody List<BranchDTO> getNearbyBranches(@RequestParam double srcLat, @RequestParam double srcLng,
			@RequestBody List<BranchDTO> branches) {

		return geoService.getDistances(new LatLng(srcLat, srcLng), branches);
	}

	@RequestMapping(value = "/branches?search=coordinates", method = RequestMethod.GET)
	public @ResponseBody LatLng getDistances(@RequestParam String address) {
		return geoService.getLatLng(address);
	}

	@RequestMapping(value = "/branches?search=enrich", method = RequestMethod.POST)
	public @ResponseBody List<BranchDTO> getDistances(@RequestBody List<BranchDTO> branches) {
		return geoService.enrichAddress(branches);
	}

	public GeoService getGeoService() {
		return geoService;
	}

	public void setGeoService(GeoService geoService) {
		this.geoService = geoService;
	}

	

}
