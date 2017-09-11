package geo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

	public List<BranchDTO> getDistances(LatLng departure, List<BranchDTO> branches) {
		try {
			DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);

			List<LatLng> arrivals = branches.stream().map(branch -> {
				LatLng result = new LatLng(branch.getLat(), branch.getLng());
				return result;
			}).collect(Collectors.toList());
			LatLng[] ar = new LatLng[arrivals.size()];
			ar = arrivals.toArray(ar);
			DistanceMatrix trix = req.origins(departure).destinations(ar).mode(TravelMode.DRIVING).language("en-US")
					.await();
			for (int i = 0; i < trix.destinationAddresses.length; i++) {
				branches.get(i).setDistance(trix.rows[0].elements[i].distance.inMeters);
			}
			Collections.sort(branches, (b1, b2) -> new Long(b1.getDistance()).compareTo(new Long(b2.getDistance())));
			return branches.subList(0, 5);

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

	public List<BranchDTO> enrichAddress(List<BranchDTO> branches) {
		try {
			for (BranchDTO branch : branches) {

				GeocodingResult[] results = GeocodingApi.geocode(context, branch.getAddress()).await();
				LatLng latLng = results[0].geometry.location;
				branch.setLat(latLng.lat);
				branch.setLng(latLng.lng);
			}
			return branches;

		} catch (ApiException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
