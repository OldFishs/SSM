package generator.mapper;

import generator.com.xxx.pojo.User;

/**
* @author 彭生
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-10-24 20:58:23
* @Entity generator.com.xxx.pojo.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
