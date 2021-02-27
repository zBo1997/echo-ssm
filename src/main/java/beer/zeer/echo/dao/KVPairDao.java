package beer.zeer.echo.dao;

import beer.zeer.echo.entity.KVPair;
import org.springframework.data.repository.CrudRepository;

public interface KVPairDao extends CrudRepository<KVPair, String> {
}
