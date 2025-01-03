import com.levi.mapper.BrandMapper;
import com.levi.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class demo8 {
    public static void main(String[] args) throws IOException {
        int status = 1;
        String companyName = "欧珀w";
        String brandName="OPPO";
        String description="手机厂商、绿厂";
        int order = 100;

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
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setStatus(status);
        brand.setOrdered(order);
        brand.setId(18);
        int count = mapper.update(brand);
        System.out.println(count);

        sqlSession.close();
    }
}
