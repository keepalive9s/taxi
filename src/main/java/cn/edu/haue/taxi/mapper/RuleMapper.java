package cn.edu.haue.taxi.mapper;

import cn.edu.haue.taxi.entity.Rule;
import java.util.List;

public interface RuleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Rule record);

    Rule selectByPrimaryKey(String id);

    List<Rule> selectByDriverId(String id);

    List<Rule> selectAll();

    int updateByPrimaryKey(Rule record);
}