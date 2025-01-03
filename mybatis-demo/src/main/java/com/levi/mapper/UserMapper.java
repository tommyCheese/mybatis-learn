package com.levi.mapper;

import com.levi.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();
    User selectUserById(int id);

    /**
     *  MyBatis参数封装
     *  * 单个参数：
     *  1. POJO类型：不会封装为map,直接使用，属性名和参数占位符名称一致
     *  2. Map集合：直接使用，键名和参数占位符名称一致
     *  3. Collection：封装成map集合，默认名称为collection和arg0
     *  4. List：默认名称为collection、list和arg0
     *  5. Array：默认名称为array和arg0
     *  6. 其他类型：直接使用，随便名称，mybatis会自动按照位置进行接收
     *
     *  *多个参数：Mybatis将多个参数封装成Map集合
     *  map.put(“arg0”,参数值1)
     *  map.put("param1",参数值1)
     *  map.put("arg1",参数值2)
     *  map.put("param2",参数值2)
     *  ...
     *  @Param 可以替换集合中默认的arg键
     *  同理可知，如果多个参数中包含的参数是对象类型，则在sql中要通过name.field来引用对应的属性
     *
     * 可以使用默认的arg0和param1来获取指定的参数，但是不建议使用，因为代码可读性很差，建议使用@Param
     * 因此，必须使用@Param的类型是Collection、list、array和多个参数的情况
     *
     */
    User select(@Param("username") String username, @Param("password") String password);

    User selectSecond(@Param("user1") User user1, @Param("user2") User user2);
}
