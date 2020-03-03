package org.spring.springboot.service;

import com.user.model.User;

/**
 * 员工业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface UserService {

    /**
     * 根据员工姓名，查询信息
     * @param userName
     */
    User findUserByName(String userName);
    User selectByPrimaryKey(Long userId);
}
