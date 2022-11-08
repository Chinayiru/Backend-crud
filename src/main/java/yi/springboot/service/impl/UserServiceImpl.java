package yi.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import yi.springboot.common.Constants;
import yi.springboot.controller.dto.UserDTO;
import yi.springboot.exception.ServiceException;
import yi.springboot.mapper.UserMapper;
import yi.springboot.pojo.User;
import yi.springboot.service.UserService;
import yi.springboot.utils.TokenUtils;

import java.util.List;

/**
 * @aythor yi
 * @data 2022/10/24  01:15:56
 * @Description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private static final  Log LOG = Log.get();
    public boolean saveUser(User user){
//        if (user.getId() == null){
//          return save(user);
//        }else {
//            return updateById(user);
//        }
        return saveOrUpdate(user);
    }

    @Override
    public UserDTO login(UserDTO userDTO) {
//        第二种请求
//        List<User> list = list(queryWrapper);
//        return list.size() !=0;
//        第一种请求
        User one = getUserInfo(userDTO);
        if (one != null){
            BeanUtil.copyProperties(one,userDTO,true);
//            设置token
            String token = TokenUtils.genToken(one.getId().toString(), one.getPassword());
            userDTO.setToken(token);
            return userDTO;
        } else {
            throw new ServiceException(Constants.CODE_600,"用户名密码错误");
        }
    }

    @Override
    public User register(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if (one == null){
            one = new User();
            BeanUtil.copyProperties(userDTO,one,true);
            save(one);
        }else {
            throw new ServiceException(Constants.CODE_600,"用户存在");
        }
        return null;
    }


    private User getUserInfo(UserDTO userDTO){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDTO.getUsername());
        queryWrapper.eq("password",userDTO.getPassword());
        User one;
        try {
            one = getOne(queryWrapper);//数据库查询用户信息

        } catch (Exception e){
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
        return one;
    }
}
