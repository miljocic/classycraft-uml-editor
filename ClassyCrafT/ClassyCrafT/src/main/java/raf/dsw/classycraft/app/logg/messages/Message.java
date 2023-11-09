package raf.dsw.classycraft.app.logg.messages;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Message {

    private String text;
    private ErrorType errorType;
    private LocalDateTime timestamp;

    public Message(String text, ErrorType errorType) {
        this.text = text;
        this.errorType = errorType;
    }

    @Override
    public String toString() {
        return text+" ["+ errorType +"]";
    }
}
