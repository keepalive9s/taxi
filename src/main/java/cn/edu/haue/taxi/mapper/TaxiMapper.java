package cn.edu.haue.taxi.mapper;

import cn.edu.haue.taxi.entity.Taxi;
import java.util.List;

public interface TaxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Taxi record);

    Taxi selectByPrimaryKey(Integer id);

    List<Taxi> selectAll();

    int updateByPrimaryKey(Taxi record);
}