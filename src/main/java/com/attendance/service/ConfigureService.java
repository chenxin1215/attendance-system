package com.attendance.service;/**
                                * @author cx
                                * @since 2019/12/8 17:18
                                */

import com.attendance.dto.response.ConfigDetail;
import com.attendance.entity.ConfigureInfo;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author cx
 * @create 2019/12/8
 * @since 1.0.0
 */
public interface ConfigureService {

    void updateConfig(ConfigureInfo configureInfo);

    ConfigDetail getConfig();

}
