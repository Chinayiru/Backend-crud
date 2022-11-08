package yi.springboot.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import yi.springboot.pojo.Role;
import yi.springboot.service.RoleService;
import yi.springboot.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author YiRu
* @description 针对表【sys_role】的数据库操作Service实现
* @createDate 2022-10-29 20:07:03
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
