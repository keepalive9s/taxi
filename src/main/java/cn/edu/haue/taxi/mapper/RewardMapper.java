package cn.edu.haue.taxi.mapper;

import cn.edu.haue.taxi.entity.Reward;
import java.util.List;

public interface RewardMapper {
    int deleteByPrimaryKey(String id);

    int insert(Reward record);

    Reward selectByPrimaryKey(String id);

    List<Reward> selectAll();

    int updateByPrimaryKey(Reward record);
}