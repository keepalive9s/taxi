import cn.edu.haue.taxi.entity.Admin;
import cn.edu.haue.taxi.entity.Contract;
import cn.edu.haue.taxi.entity.Driver;
import cn.edu.haue.taxi.mapper.AdminMapper;
import cn.edu.haue.taxi.mapper.ContractMapper;
import cn.edu.haue.taxi.mapper.DriverMapper;
import cn.edu.haue.taxi.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private DriverMapper driverMapper;

    @Autowired
    private ContractMapper contractMapper;

    @Test
    public void t0() {
        Admin admin = new Admin();
        admin.setUsername("root");
        admin.setPassword(MD5Util.MD5EncodeUtf8("root"));
        adminMapper.insert(admin);
    }

    @Test
    public void t1() {
        List<Driver> drivers = driverMapper.selectAll();
        for (Driver item : drivers) {
            System.out.println(item);
        }
    }

    @Test
    public void t2() {
        Driver driver = driverMapper.selectByPrimaryKey("196970");
        System.out.println(driver.getEndTime());
    }

}
