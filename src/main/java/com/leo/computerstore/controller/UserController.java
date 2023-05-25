package com.leo.computerstore.controller;

import com.leo.computerstore.entity.User;
import com.leo.computerstore.service.IUserService;
import com.leo.computerstore.service.ex.InsertException;
import com.leo.computerstore.service.ex.UsernameDuplicatedException;
import com.leo.computerstore.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //其作用等同于@Controller+@ResponseBody
//@Controller
@RequestMapping("users")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    /*
    @RequestMapping("reg")
    //@ResponseBody //表示此方法的响应结果以json格式进行数据的响应给到前端
    //JsonResult<Void>表示reg方法返回一个JsonResult对象，该对象携带了一个没有具体类型的值，即Void类型。
    // 因此，在result.setData()方法中，你无法直接将user对象作为数据传递给JsonResult。
    public JsonResult<Void> reg(@RequestBody User user) {
        //创建响应结果对象即JsonResult对象
        JsonResult<Void> result = new JsonResult<>();
        try {
            //调用userService的reg方法时可能出现异常,所以需要捕获异常
            userService.reg(user);
            result.setState(200);
            result.setMessage("用户注册成功");
        } catch (UsernameDuplicatedException e) {
            result.setState(4000);
            result.setMessage("用户名被占用");
        } catch (InsertException e) {
            result.setState(5000);
            result.setMessage("注册时产生未知的异常");
        }
        return result;
    }
    */

    // 优化异常处理，代码复用，继承BaseController
    // 让UserController继承BaseController并重构UserController下的reg方法使该方法只需要关注请求处理而不再需要关注异常捕获:
    @RequestMapping("reg")
    public JsonResult<Void> reg(@RequestBody User user) {
        // 如果有 exception 会在 BaseController里被ExceptionHandler捕获并且直接返回result给前端
        userService.reg(user);
        // 如果没有 exception 返回 200
        return new JsonResult<>(OK);
    }
}