package geo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;

@Service
public class GeoService {

	@Autowired
	GeoApiContext context;

	public DistanceMatrix getDistances(LatLng departure, LatLng... arrivals) {
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

	public LatLng getLatLng(String address) {
		try {
			GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
			return results[0].geometry.location;

		} catch (ApiException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
