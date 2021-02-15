package beer.zeer.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KVPair {
    @Value("ping")
    private String key;
    @Value("pong")
    private String val;

    @Override
    public String toString() {
        return "KVPair{" +
                "key='" + key + '\'' +
                ", val='" + val + '\'' +
                '}';
    }

    public String getVal() {
        return val;
    }
}
