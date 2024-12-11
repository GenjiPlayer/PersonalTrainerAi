package demo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Connection {

    public String muscle = "biceps";

    public void getTestResponse(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.api-ninjas.com/v1/exercises?" + "muscle=" + muscle;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", "sWmCsF8THa9NbTHeceZSIw==1iZ4GiP2bL4gDJfp");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, String.class);

        System.out.println(response.getBody());

    }
}

