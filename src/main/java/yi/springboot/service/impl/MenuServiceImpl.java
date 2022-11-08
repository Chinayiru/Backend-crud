package yi.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import yi.springboot.pojo.Menu;
import yi.springboot.service.MenuService;
import yi.springboot.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author YiRu
* @description 针对表【sys_menu】的数据库操作Service实现
* @createDate 2022-10-29 20:55:56
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService{

}
