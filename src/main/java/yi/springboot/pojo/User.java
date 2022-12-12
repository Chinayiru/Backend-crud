package yi.springboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @TableName sys_user
 */
@TableName(value = "sys_user")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty("id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;


    /**
     * 地址
     */
    @ApiModelProperty("地址")
    private String address;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @TableField("create_time")
    @JsonIgnore
    private Date time;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}