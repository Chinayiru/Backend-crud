package yi.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import yi.springboot.pojo.User;

/**
 * @aythor yi
 * @data 2022/10/24  01:04:41
 * @Description
 */

public interface UserMapper extends BaseMapper<User> {

//    @Select("SELECT * from t_user")
//    List<User> findAll();
//
//
////    @Select("select * from t_user limit #{pageNum}，#{pageSize}")
////    List<User> SelectPage(Integer pageNum, Integer pageSize);
////
////    @Select("select count(*) from t_user")
////    Integer selectTotal();
//    /**
//     * 分页查询
//     * @param begin
//     * @param size
//     * @return
//     */
//    @Select("select * from t_user limit #{pageNum},#{pageSize}")
//    List<User> selectByPage(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
//
//    /**
//     * 查询总记录数
//     * @return
//     */
//    @Select("select count(*) from t_user")
//    int selectTotal();
//
//    /**
//     * 分页条件查询
//     * @param begin
//     * @param size
//     * @return
//     */
//    List<User> selectByPageAndCondition(@Param("pageNum") Integer pageNum,@Param("pageSize") int pageSize,@Param("user") User user);
}
