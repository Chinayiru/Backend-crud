package yi.springboot.service.impl;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import yi.springboot.mapper.AccountMapper;
import yi.springboot.pojo.Account;
import yi.springboot.service.AccountService;

/**
 * @aythor yi
 * @data 2022/12/1   16:28:15
 * @Description
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    private static final Log LOG = Log.get();


    @Override
    public boolean login(Account account) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account.getAccount());
        queryWrapper.eq("password", account.getPassword());
        try {
            Account one = getOne(queryWrapper);
            return one != null;
        } catch (Exception e) {
            LOG.error(e);
            return false;
        }
    }


}
