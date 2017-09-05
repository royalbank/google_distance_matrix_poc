package geo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.maps.GeoApiContext;

@Configuration
public class AppConfiguration {
	@Bean
	public GeoApiContext myService() { 
	    System.setProperty("http.proxyHost", "oproxy.fg.rbc.com");
	    System.setProperty("http.proxyPort", "8080");
	    System.setProperty("https.proxyHost", "oproxy.fg.rbc.com");
        System.setProperty("https.proxyPort", "8080");
		GeoApiContext context = new GeoApiContext().setApiKey(GeoConst.API_KEY);
		return context;
	}
}
