package com.codewave.demo.postgresql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.codewave.demo.postgresql.model.dto.mapper.UserPostDto;
import com.codewave.demo.postgresql.model.dto.request.UserRequestDto;
import com.codewave.demo.postgresql.model.dto.response.UserRespDto;

@Mapper // create bean into context, similar to Repository
public interface UserMapper {

  @Select("SELECT * FROM TUSERS")
  @Results({
      @Result(property = "id", column = "ID"),
      @Result(property = "fullName", column = "NAME"),
      @Result(property = "userName", column = "USER_NAME"),
      @Result(property = "email", column = "USER_EMAIL"),
      @Result(property = "phone", column = "USER_PHONE"),
      @Result(property = "website", column = "USER_WEBSITE"),
  })
  List<UserRespDto> getAll();


  @Select("SELECT U.ID, U.USER_NAME, P.ID, P.POST_TITLE FROM TUSERS U LEFT JOIN TPOSTS P ON P.USER_ID = U.ID")
  @Results({
    @Result(property = "userid", column = "USER_ID"),
    @Result(property = "userName", column = "USER_NAME"),
    @Result(property = "postId", column = "POST_ID"),
    @Result(property = "postTitle", column = "POST_TITLE"),

  })
  List<UserPostDto> getAllUserPost();



  // getById
 ////////
  @Select("SELECT * FROM TUSERS WHERE ID = #{id}")
  @Results({
      @Result(property = "id", column = "ID"),
      @Result(property = "fullName", column = "NAME"),
      @Result(property = "userName", column = "USER_NAME"),
      @Result(property = "email", column = "USER_EMAIL"),
      @Result(property = "phone", column = "USER_PHONE"),
      @Result(property = "website", column = "USER_WEBSITE"),
  })
  UserRespDto getById(Long id);
  ////////

  @Insert("INSERT INTO TUSERS (NAME, USER_NAME, USER_EMAIL, USER_PHONE, USER_WEBSITE) VALUES (#{fullName}, #{userName}, #{email}, #{phone}, #{website})")
  void insert(UserRequestDto userRequestDto);

  @Delete("DELETE FROM TUSERS WHERE USER_NAME = #{userName}")
  void delete(String userName);

  @Update("UPDATE TUSERS SET USER_EMAIL = #{email} WHERE ID = #{id}")
  void update(String email, Long id);
}

