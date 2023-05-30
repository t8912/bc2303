package com.codewave.demo.demopostgresql.mapper;

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

  // getById

  @Insert("INSERT INTO TUSERS (ID, NAME, USER_NAME, USER_EMAIL, USER_PHONE_USER_WEBSITE) VALUES (#{fullNAme},#{userName},#{userEmail},#{userPhone},#{userWebsite})")
  void insert(UserRequestDto userRequestDto);

  @Delect("DELETE FROM TUSERS WHERE USER_NAME = #{userName}")
  void delect(String username);
  
  @Update("UPDATE TUSERS SET USER_EMAIL = #{email} WHERE ID = #{id}")
  void update(String email, Long id);
  
}
