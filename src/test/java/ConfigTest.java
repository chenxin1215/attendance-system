import com.attendance.utils.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.attendance.dao.ConfigureInfoMapper;
import com.attendance.entity.ConfigureInfo;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试〉
 *
 * @author xx
 * @create 2019/12/1
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ConfigTest {

    @Autowired
    ConfigureInfoMapper configureInfoMapper;

    // 获取配置信息 ID：1
    @Test
    public void getConfigInfo() {
        ConfigureInfo configureInfo = configureInfoMapper.selectByPrimaryKey(1L);
        System.out.println("上班时间" + DateUtil.dateToString(configureInfo.getWorkHours(), DateUtil.TIME_BASE));
    }

}