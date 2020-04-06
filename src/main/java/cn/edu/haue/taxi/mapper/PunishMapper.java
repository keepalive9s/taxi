package cn.edu.haue.taxi.mapper;

import cn.edu.haue.taxi.entity.Punish;
import java.util.List;

public interface PunishMapper {
    int deleteByPrimaryKey(String id);

    int insert(Punish record);

    Punish selectByPrimaryKey(String id);

    List<Punish> selectAll();

    int updateByPrimaryKey(Punish record);
}