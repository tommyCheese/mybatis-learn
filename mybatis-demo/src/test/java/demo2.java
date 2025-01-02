import com.levi.mapper.UserMapper;
import com.levi.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis代理开发
 */
public class demo2 {
    /**
     * 使用demo1方法直接创建sqlSession并执行sql有两个缺点，首先是硬编码，其次是无法使用IDE进行补全，解决的方法是使用代理开发
     * 1. 定义与SQL映射文件同名的Mapper接口，并将Mapper接口与映射文件放在同一个目录下（编译后在同一个目录下即可）
     * 2. 设置sql映射文件中的namespace属性为Mapper的接口全限定名
     * 3.在Mapper接口中定义方法，方法名就是SQL映射文件中的sql语句唯一id，并保持参数类型和返回值类型一致
     * 4.编码：
     *  4.1 通过SqlSession的getMapper方法获取Mapper接口的代理对象
     *  4.2 调用对应的方法执行sql
     * 注意，当使用代理模式时，可以在mybatis-config.xml使用package包扫描标签快速加载指定位置下的所有mapper xml文件
     */
    public static void main(String[] args) throws IOException {
        //1. 加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        System.out.println(sqlSessionFactory);

        //2. 获取对应的sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 执行sql语句
        //3.1 获取UserMapper接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
        users.forEach(System.out::println);
        sqlSession.close();
    }
}
