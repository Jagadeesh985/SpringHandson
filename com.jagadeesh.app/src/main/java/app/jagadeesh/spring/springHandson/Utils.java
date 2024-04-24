package app.jagadeesh.spring.springHandson;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Utils {
    public String getRandomGeneratedUserId(){
        return UUID.randomUUID().toString();
    }
}
