package zeer.beer.echo.entity;

import beer.zeer.echo.entity.KVPair;
import org.junit.jupiter.api.Test;

public class KVPairTest {
    @Test public void forTest() {
        KVPair kvPair = new KVPair();
        kvPair.setKey("key");
        kvPair.setVal("val");
        System.out.println(kvPair.getKey() + kvPair.getVal());
    }
}
