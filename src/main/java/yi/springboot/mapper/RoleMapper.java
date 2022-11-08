package yi.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import yi.springboot.pojo.Role;

/**
* @author YiRu
* @description 针对表【sys_role】的数据库操作Mapper
* @createDate 2022-10-29 20:07:03
* @Entity yi.springboot.pojo.Role
*/
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select id from sys_role where flag = #{flag}")
    Integer selectByFlag(@Param("flag") String flag);
}
