package yi.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import yi.springboot.pojo.Account;

/**
 * @aythor yi
 * @data 2022/12/1  01:14:27
 * @Description
 */
public interface AccountService extends IService<Account> {

    boolean login(Account account);

}
