package beer.zeer.mapper;

import org.apache.ibatis.annotations.Select;

public interface KVPairMapper {
    @Select("select v from pair where k = #{0}")
    String echo(String key);
}
