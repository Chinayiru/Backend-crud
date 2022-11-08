package yi.springboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.*;
import yi.springboot.mapper.FileMapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @aythor yi
 * @data 2022/10/29  01:01:33
 * @Description
 */
@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_file")
public class Files implements FileMapper {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String type;
    private Long size;
    private String url;
    private Boolean isDelete;
    private Boolean enable;
    private String md5;

    @Override
    public int insert(FileMapper entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteById(FileMapper entity) {
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return 0;
    }

    @Override
    public int delete(Wrapper<FileMapper> queryWrapper) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<?> idList) {
        return 0;
    }

    @Override
    public int updateById(FileMapper entity) {
        return 0;
    }

    @Override
    public int update(FileMapper entity, Wrapper<FileMapper> updateWrapper) {
        return 0;
    }

    @Override
    public FileMapper selectById(Serializable id) {
        return null;
    }

    @Override
    public List<FileMapper> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<FileMapper> selectByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public Long selectCount(Wrapper<FileMapper> queryWrapper) {
        return null;
    }

    @Override
    public List<FileMapper> selectList(Wrapper<FileMapper> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<FileMapper> queryWrapper) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<FileMapper> queryWrapper) {
        return null;
    }

    @Override
    public <P extends IPage<FileMapper>> P selectPage(P page, Wrapper<FileMapper> queryWrapper) {
        return null;
    }

    @Override
    public <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, Wrapper<FileMapper> queryWrapper) {
        return null;
    }

    @Override
    public List<Files> selectList(QueryWrapper<Files> queryWrapper) {
        return null;
    }
}
