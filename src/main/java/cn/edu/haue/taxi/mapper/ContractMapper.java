package cn.edu.haue.taxi.mapper;

import cn.edu.haue.taxi.entity.Contract;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractMapper {
    int deleteByPrimaryKey(@Param("taxiId") Integer taxiId, @Param("driverId") String driverId);

    int insert(Contract record);

    Contract selectByPrimaryKey(@Param("taxiId") Integer taxiId, @Param("driverId") String driverId);

    List<Contract> selectAll();

    int updateByPrimaryKey(Contract record);
}