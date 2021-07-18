import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

import javax.naming.spi.InitialContextFactory;

public class TestShiro {
    public static void main(String[] args) {
        //获取安全管理器工厂
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //获取安全管理器实例
        SecurityManager instance = factory.getInstance();
        //给安全管理工具类设置安全管理器
        SecurityUtils.setSecurityManager(instance);
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //令牌
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");
        //主题携带令牌进行认证
        try{
            subject.login(token);
        }catch (AuthenticationException e){
            //IncorrectCredentialsException  密码错误
            //UnknownAccountException    //未知账号错误
        }
        //主体是否被认证
        boolean b = subject.isAuthenticated();
        System.out.println(b);
    }

}
