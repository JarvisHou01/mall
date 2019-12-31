package com.qdu.controller;

import com.qdu.bean.Page;
import com.qdu.bean.Result;
import com.qdu.bean.User;
import com.qdu.exception.LoginException;
import com.qdu.exception.RegisterException;
import com.qdu.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("to_list")
    public String to_list(){
        return "user/list";
    }

    @RequestMapping("to_login")
    public String to_login(){
        return "login";
    }

    @RequestMapping("to_order")
    public String to_order(){
        return "user/order";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Page<User> queryList(@RequestParam(required = false,defaultValue = "1") int pageNum,
                                @RequestParam(required = false,defaultValue = "3") int pageSize){
        return userService.queryList(pageNum,pageSize);
    }

    /**
     * 登陆
     * @param request
     * @param user
     * @param verifyCode
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, //
                        User user, //
                        @RequestParam String verifyCode) {

        // 判断验证码
        HttpSession session = request.getSession();
        String code = String.valueOf(session.getAttribute("verifyCode"));
        if (!StringUtils.equalsIgnoreCase(verifyCode, code)) {
            throw new LoginException("验证码错误");
            // return "redirect:/user/to_login";
        }
        //
        if (StringUtils.isEmpty(user.getUsername()) //
                || StringUtils.isEmpty(user.getPassword())) {
            throw new LoginException("用户名或密码不能为空");
        }

        String password = DigestUtils.md5Hex(user.getPassword());

        //调用service
        //数据库操作
        user = userService.queryUser(user.getUsername(), password);


        if (ObjectUtils.isEmpty(user)) {
            throw new LoginException("用户名或密码错误");
            // return "redirect:/user/to_login";
        }
        session.setAttribute("user", user);
        return "redirect:/";
    }

    /**
     * 登出
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");

        // 销毁session，这样的话，session中所有的数据都会被清空
        session.invalidate();
        return "redirect:/user/to_login";
    }

    /**
     * 找到注册页面
     * @return
     */
    @RequestMapping("to_register")
    public String to_register(){
        return "register";
    }

    /**
     * 注册
     * @param username
     * @param password
     * @param password2
     * @param email
     * @param phone
     * @return
     */
    @RequestMapping("register")
    public String register(@RequestParam String username,
                           @RequestParam String password ,
                           @RequestParam String password2,
                           @RequestParam String email ,
                           @RequestParam String phone) {

        if (StringUtils.isEmpty(password)||StringUtils.isEmpty(username)||StringUtils.isEmpty(password2)||StringUtils.isEmpty(email)||StringUtils.isEmpty(phone)){
            throw new RegisterException("请填写信息");
        }

        if (!password.equals(password2)){
            throw new RegisterException("请两次密码输入一致");
        }
        //username不能重复
        User user = userService.queryUserByName(username);


        if (user!=null&&user.getUsername()!=null&&!"".equals(user.getUsername())){
            throw new RegisterException("用户已经存在");
        }
        User user1 = new User();
        user1.setStatus(0);
        String s = DigestUtils.md5Hex(password);
        user1.setPassword(s);
        user1.setUsername(username);
        user1.setEmail(email);
        user1.setPhone(phone);

        //添加用户
        int a = userService.addUser(user1);

        return "redirect:/user/to_login";
    }

    /**
     * 删除用户，其实是修改状态
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Result deleteUser(@RequestParam int id){
        int res = userService.deleteUserById(id);
        if (res>0){
            return new Result(200,"成功");
        }
        return new Result(500,"失败");
    }

    /**
     * 更新用户,修改用户
     * @param id
     * @param email
     * @param phone
     * @return
     */
    @RequestMapping("update")
    public String update(@RequestParam int id,@RequestParam String email,@RequestParam String phone){
        User user = new User();
        user.setId(id);
        user.setPhone(phone);
        user.setEmail(email);

        userService.updateUser(user);
        return "user/list";
    }

}
