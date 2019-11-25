import com.attendance.dao.EmployeeInfoMapper;
import com.attendance.dto.response.EmployeeDetail;
import com.attendance.entity.EmployeeInfo;
import com.attendance.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class EmployeeTest{

    @Autowired
    private EmployeeInfoMapper employeeInfoMapper;

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testQueryList(){
        List<EmployeeInfo> employeeInfos = employeeInfoMapper.queryAllEmployeeList();
        System.out.println("11"+employeeInfos.size());
    }

    @Test
    public void testInsertEmployee(){
       EmployeeInfo employeeInfo= employeeInfoMapper.selectByPrimaryKey(1768L);
       employeeInfo.setAge(100);
       employeeInfoMapper.updateByPrimaryKeySelective(employeeInfo);
    }

    @Test
    public void testEmployeeDetail(){
        EmployeeDetail result = employeeService.getEmployeeById(1768L);
        System.out.println(result.toString());
    }

}
