import com.levi.mapper.BrandMapper;
import com.levi.mapper.UserMapper;
import com.levi.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class demo11 {
    public static void main(String[] args) throws IOException {
        //1. 加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        System.out.println(sqlSessionFactory);

        //2. 获取对应的sqlSession对象，用它来执行sql
        /**
         *  autocommit：
         *      true：开启事务，需要手动提交（sqlSession.commit），否则会报Setting autocommit to false on JDBC Connection（回滚-提交失败）
         *      false：关闭事务，即自动提交事务
         */
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. 执行sql语句
        //3.1 获取UserMapper接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String username="zhangsan";
        String password="123";
        User user = mapper.select(username,password);
        System.out.println(user);

        User query1 = new User();
        query1.setId(1);
        User query2 = new User();
        query2.setId(2);
        User user1 = mapper.selectSecond(query1, query2);
        System.out.println(user1);
        sqlSession.close();
    }
}
