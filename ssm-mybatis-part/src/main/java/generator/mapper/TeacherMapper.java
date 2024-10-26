package generator.mapper;

import generator.com.xxx.pojo.Teacher;

/**
* @author 彭生
* @description 针对表【teacher】的数据库操作Mapper
* @createDate 2024-10-24 20:58:23
* @Entity generator.com.xxx.pojo.Teacher
*/
public interface TeacherMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

}
