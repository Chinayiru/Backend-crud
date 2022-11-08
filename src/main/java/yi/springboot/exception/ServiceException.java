package yi.springboot.exception;

import lombok.Getter;

/**
 * @aythor yi
 * @data 2022/10/28  01:09:36
 * @Description
 */
@Getter
public class ServiceException extends RuntimeException{
    private final String code;
    public ServiceException(String code,String msg){
        super(msg);
        this.code = code;
    }
}
