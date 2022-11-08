package yi.springboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @TableName sys_menu
 */
@TableName(value ="sys_menu")
@Data
@Getter
@Setter
@ApiModel(value = "Menu对象", description = "")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 路径
     */
    @ApiModelProperty("路径")
    private String path;

    /**
     * 图标
     */
    @ApiModelProperty("图标")
    private String icon;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;

    @TableField(exist = false)
    private List<Menu> children;

    private Integer pid;
}