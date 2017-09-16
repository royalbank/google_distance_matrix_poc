package geo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.maps.GeoApiContext;

@Configuration
@ConfigurationProperties(prefix="geo")
public class AppConfiguration {

	@Value("${geo.key.matrix}")
	String API_KEY_MATRIX;
	
	public AppConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Bean
	public GeoApiContext myService() { 

		GeoApiContext context = new GeoApiContext().setApiKey(API_KEY_MATRIX);
		return context;
	}

	public String getAPI_KEY_MATRIX() {
		return API_KEY_MATRIX;
	}

	public void setAPI_KEY_MATRIX(String aPI_KEY_MATRIX) {
		API_KEY_MATRIX = aPI_KEY_MATRIX;
	}
	
	
}
