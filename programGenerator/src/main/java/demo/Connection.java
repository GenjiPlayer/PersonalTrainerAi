package demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class Connection {

    private static final String API_KEY = "sWmCsF8THa9NbTHeceZSIw==1iZ4GiP2bL4gDJfp";
    private static final String BASE_URL = "https://api.api-ninjas.com/v1/exercises";


    public String getExercises(String muscle) {
        ResponseEntity<String> response = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = BASE_URL + "?muscle=" + muscle;

            HttpHeaders headers = new HttpHeaders();
            headers.set("X-Api-Key", API_KEY);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            response = restTemplate.exchange(
                    url, HttpMethod.GET, entity, String.class);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to fetch exercises for muscle: " + muscle);
        }
        return response.getBody();
    }
}

