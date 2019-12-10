package com.attendance.service;

/**
 * @author cx
 * @since 2019/12/8 17:18
 */

import com.attendance.entity.ConfigureInfo;
import com.attendance.dto.response.ConfigDetail;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author cx
 * @create 2019/12/8
 * @since 1.0.0
 */
public interface ConfigureService {

    void updateConfig(ConfigureInfo configureInfo, Long userId);

    ConfigDetail getConfig();

    Integer getTime();

}
