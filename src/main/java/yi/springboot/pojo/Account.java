package yi.springboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @aythor yi
 * @data 2022/12/3  17:34:04
 * @Description
 */
@TableName(value ="sys_account")
@Data
public class Account implements Serializable {
    @ApiModelProperty("id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String account;
    private String password;
}
