package com.example.demo;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Connection {
    URL url;
    {
        try {
            url = new URL("https://api.api-ninjas.com/v1/exercises");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
