package yi.springboot.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import yi.springboot.pojo.Files;

import java.util.Collection;
import java.util.List;

/**
 * @aythor yi
 * @data 2022/10/29  01:04:44
 * @Description
 */
public interface FileMapper extends BaseMapper<FileMapper> {
    int deleteBatchIds(Collection<?> idList);

    List<Files> selectList(QueryWrapper<Files> queryWrapper);
}
