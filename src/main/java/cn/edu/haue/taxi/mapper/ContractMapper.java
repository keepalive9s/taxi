package cn.edu.haue.taxi.mapper;

import cn.edu.haue.taxi.entity.Contract;
import java.util.List;

public interface ContractMapper {
    int deleteByPrimaryKey(String id);

    int insert(Contract record);

    Contract selectByPrimaryKey(String id);

    List<Contract> selectByTaxiId(Integer id);

    List<Contract> selectByDriverId(String id);

    List<Contract> selectByPlateNum(String num);

    List<Contract> selectAll();

    int updateByPrimaryKey(Contract record);


}