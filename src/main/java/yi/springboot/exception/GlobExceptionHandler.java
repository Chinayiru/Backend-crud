package yi.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import yi.springboot.common.Result;

/**
 * @aythor yi
 * @data 2022/10/28  01:06:21
 * @Description
 */
@ControllerAdvice
class GlobalExceptionHandler {

    /**
     * @ExceptionHandler相当于controller的@RequestMapping
     * @param se 业务异常
     * @return
     *
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result handle(ServiceException se){
        return Result.error(se.getCode(),se.getMessage());
    }
}
