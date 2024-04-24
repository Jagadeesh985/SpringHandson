package app.jagadeesh.spring.springHandson.ui.model.response;

import java.time.LocalDateTime;

public class ErrorMessage {
    private LocalDateTime timeStamp;
    private String message;

    public ErrorMessage(LocalDateTime timeStamp, String message) {

        this.timeStamp = timeStamp;
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
