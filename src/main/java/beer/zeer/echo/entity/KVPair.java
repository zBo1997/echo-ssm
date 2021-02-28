package beer.zeer.echo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table("pair")
public class KVPair implements Serializable {
    @Column("k") private @Id String key;
    @Column("v") private String val;

    public KVPair() {
        this.val = "failed";
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
