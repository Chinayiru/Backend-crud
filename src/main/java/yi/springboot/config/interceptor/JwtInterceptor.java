package yi.springboot.config.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import yi.springboot.common.Constants;
import yi.springboot.pojo.User;
import yi.springboot.service.UserService;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @aythor yi
 * @data 2022/10/28  23:21:45
 * @Description
 */

public class JwtInterceptor implements HandlerInterceptor {
    @Resource
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
//        如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
//        执行认证
        if (StrUtil.isBlank(token)){
            throw new ServletException(Constants.CODE_401);
        }
//        获取token的user id
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw  new ServletException(Constants.CODE_401);
        }
//        根据token的userid查询数据库
        User user = userService.getById(userId);
        if (user == null){
            throw new ServletException(Constants.CODE_401);
        }
//        验证token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);//验证token
        } catch (JWTVerificationException e) {
            throw new ServletException(Constants.CODE_401);
        }
        return true;
    }
}
