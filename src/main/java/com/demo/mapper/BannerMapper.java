package com.demo.mapper;

import com.demo.domain.Banner;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BannerMapper {

    @Delete("delete from t_banner where id = #{id}")
    int deleteByPrimaryKey(@Param("id") Integer id);

    @SelectKey(statement="select LAST_INSERT_ID() AS id" , before = false,   resultType=java.lang.Integer.class, keyProperty="id" )
    @Insert("insert into t_banner(direct_url,title,create_user_id) values (#{BANNER.directUrl},#{BANNER.title},#{BANNER.createUserId})")
    Integer insert(@Param("BANNER") Banner banner);

    int insertSelective(Banner banner);

    @Select("select * from t_banner where id = #{id}")
    Banner selectByPrimaryKey(Integer id);

   /* int updateByPrimaryKeySelective(Banner banner);

    int updateByPrimaryKey(Banner banner);*/
}