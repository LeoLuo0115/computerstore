package com.leo.computerstore.service;

import com.leo.computerstore.entity.User;
import com.leo.computerstore.mapper.UserMapper;
import com.leo.computerstore.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
/**
 * 1.@RunWith表示启动这个单元测试类,否则这个单元测试类是不能运行的,需要传递
 * 一个参数,该参数必须是SpringRunner.class即SpringRunner的实例类型
 * 2.敲完@RunWith(SpringRunner.class)后鼠标分别放在SpringRunner和@RunWith上按alt+enter分别导入包
 * 3.单元测试类中出现的方法必须是单元测试方法
 * 4.单元测试方法的特点:必须被@Test注解修饰;返回值类型必须是void;方法的参数列表不指定任何类型;方法的访问修饰符必须是public
 */

public class UserServiceTests {
    /**
     * 进行插入时可能会出错抛出异常,这时需要捕获异常:
     * 1.选中    User user = new User();
     *           user.setUsername("张7");
     *           user.setPassword("123456");
     *           userService.reg(user);
     *           System.out.println("OK");
     * 2.点击导航栏的Code,然后依次点击SurroundWith->try/catch就可以捕获异常了
     * 3.Exception e没有问题,但这里我们知道是Service层的异常,所以可以改为ServiceException e
     * 4.System.out.println(e.getClass().getSimpleName());获取异常对象再获取类的名称然后输出
     * 5.System.out.println(e.getMessage());输出异常信息(是自己在ServiceException的子类类具体设置的信息)
     */

    @Autowired
    private IUserService userService;

    @Test
    public void insertTest() {
        try {
            User user = new User();
            user.setUsername("Bryan");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("注册成功");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }

    }
}
