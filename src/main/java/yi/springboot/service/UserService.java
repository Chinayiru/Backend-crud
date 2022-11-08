package yi.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import yi.springboot.controller.dto.UserDTO;
import yi.springboot.pojo.User;

/**
 * @aythor yi
 * @data 2022/10/24  01:14:27
 * @Description
 */
public interface UserService extends IService<User> {
    boolean saveUser(User user);

    UserDTO login(UserDTO userDTO);

    User register(UserDTO userDTO);

}
