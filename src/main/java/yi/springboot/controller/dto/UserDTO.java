package yi.springboot.controller.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @aythor yi
 * @data 2022/10/27  23:48:38
 * @Description
 */

/**
 * 接收前端登录请求参数
 */
@Data
public class UserDTO {
    private String username;
    private String password;
    private String nickname;
    @ApiModelProperty("头像")
    @TableField(value = "avatar_url")
    private String avatar;
    private String token;
}
