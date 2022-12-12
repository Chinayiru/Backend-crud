package yi.springboot.service.impl;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import yi.springboot.mapper.UserMapper;
import yi.springboot.pojo.User;
import yi.springboot.service.UserService;

/**
 * @aythor yi
 * @data 2022/12/1   16:28:15
 * @Description 
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private static final  Log LOG = Log.get();
    public boolean saveUser(User user){

        return saveOrUpdate(user);
    }



}
