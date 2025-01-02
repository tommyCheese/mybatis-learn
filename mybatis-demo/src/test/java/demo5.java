import com.levi.mapper.BrandMapper;
import com.levi.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class demo5 {
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
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int status = 1;
        String companyName="华为";
        String brandName = "华为";

        // 处理模糊参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";

        Brand brandCondition = new Brand();
//        brandCondition.setStatus(status);
        List<Brand> brands1 = mapper.selectBySingleCondition(brandCondition);
        System.out.println(brands1);
    }
}
