package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;

@RestController
public class HelloController {

	@RequestMapping("/")
	@ResponseBody
	public DistanceMatrix index() {

		return estimateRouteTime(new LatLng(43.64111, -79.378664), new LatLng(43.646419, -79.379817),
				new LatLng(43.653331, -79.396731));
	}

	private static final String API_KEY = "AIzaSyDOq3LHENlQbt-6LS-wsQVY1m7vuyRqD5s";

	GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);

	public DistanceMatrix estimateRouteTime(LatLng departure, LatLng... arrivals) {
		try {
			DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);

			DistanceMatrix trix = req.origins(departure).destinations(arrivals).mode(TravelMode.DRIVING)
					.language("en-US").await();
			return trix;

		} catch (ApiException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
