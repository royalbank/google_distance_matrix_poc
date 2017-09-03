package geo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.maps.GeoApiContext;

@Configuration
public class AppConfiguration {
	@Bean
	public GeoApiContext myService() { 

		GeoApiContext context = new GeoApiContext().setApiKey(GeoConst.API_KEY);
		return context;
	}
}
