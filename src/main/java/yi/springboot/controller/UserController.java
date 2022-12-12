package yi.springboot.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import yi.springboot.pojo.Account;
import yi.springboot.pojo.User;
import yi.springboot.service.AccountService;
import yi.springboot.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @aythor yi
 * @data 2022/12/1   16:36:43
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private AccountService accountService;

    @GetMapping
    public List<User> findAll() {
        return userService.list();
    }

    @PostMapping("/login")
    public boolean Login(@RequestBody Account account) {
        String account1 = account.getAccount();
        String password = account.getPassword();
        if (StrUtil.isBlank(account1) || StrUtil.isBlank(password)) {
            return false;
        }
        return accountService.login(account);
    }

//    @GetMapping("/a1")
//    public List<Account> findAll1() {
//        return accountService.list();
//    }

    //    添加和修改
    @PostMapping
    public boolean save(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }


    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return userService.removeById(id);
    }


    @GetMapping("/{id}")
    public User findOne(@PathVariable Integer id) {
        return userService.getById(id);
    }


    @GetMapping("/page")
    public IPage<User> page(@RequestParam Integer pageNum,
                            @RequestParam Integer pageSize,
                            @RequestParam(defaultValue = "") String username,
                            @RequestParam(defaultValue = "") String email,
                            @RequestParam(defaultValue = "") String address) {
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (!"".equals(username)) {
            queryWrapper.like("username", username);
        }
        if (!"".equals(email)) {
            queryWrapper.like("email", email);
        }
        if (!"".equals(address)) {
            queryWrapper.like("address", address);
        }
        return userService.page(page, queryWrapper);
    }

}
