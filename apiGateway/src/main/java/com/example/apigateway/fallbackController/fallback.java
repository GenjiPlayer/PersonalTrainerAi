package com.example.apigateway.fallbackController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class fallback {
    @GetMapping("/fallback")
    public ResponseEntity<String> fallback(){
        return ResponseEntity.ok("womp womp no worky :,(");
    }
}
