package cn.edu.haue.taxi.mapper;

import cn.edu.haue.taxi.entity.Complain;
import java.util.List;

public interface ComplainMapper {
    int deleteByPrimaryKey(String id);

    int insert(Complain record);

    Complain selectByPrimaryKey(String id);

    List<Complain> selectAll();

    int updateByPrimaryKey(Complain record);
}