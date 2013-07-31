package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.Users;
import com.shirokumacafe.archetype.entity.UsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface UsersMapper {
    @SelectProvider(type=UsersSqlProvider.class, method="countByExample")
    int countByExample(UsersExample example);

    @DeleteProvider(type=UsersSqlProvider.class, method="deleteByExample")
    int deleteByExample(UsersExample example);

    @Delete({
        "delete from users",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
        "insert into users (user_id, user_code, ",
        "user_name, login_name, ",
        "password, salt, ",
        "sex, idcard_address, ",
        "idcard, home_address, ",
        "tel, contact_tel, ",
        "contact_name, bank_dict, ",
        "bank_account, birthday, ",
        "state, postion_level_dict, ",
        "salary, postion_state, ",
        "join_date, leave_date, regular_date, ",
        "nation_dict, photo, ",
        "remark, postion_dict, ",
        "major_dict, education_dict, ",
        "graduate, polity, ",
        "qq, email, create_id, ",
        "update_id, create_time, ",
        "update_time)",
        "values (#{userId,jdbcType=INTEGER}, #{userCode,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR}, #{loginName,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{salt,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=INTEGER}, #{idcardAddress,jdbcType=VARCHAR}, ",
        "#{idcard,jdbcType=VARCHAR}, #{homeAddress,jdbcType=VARCHAR}, ",
        "#{tel,jdbcType=VARCHAR}, #{contactTel,jdbcType=VARCHAR}, ",
        "#{contactName,jdbcType=VARCHAR}, #{bankDict,jdbcType=VARCHAR}, ",
        "#{bankAccount,jdbcType=VARCHAR}, #{birthday,jdbcType=DATE}, ",
        "#{state,jdbcType=INTEGER}, #{postionLevelDict,jdbcType=VARCHAR}, ",
        "#{salary,jdbcType=NUMERIC}, #{postionState,jdbcType=INTEGER}, ",
        "#{joinDate,jdbcType=DATE}, #{leaveDate,jdbcType=DATE}, #{regularDate,jdbcType=DATE}, ",
        "#{nationDict,jdbcType=VARCHAR}, #{photo,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{postionDict,jdbcType=VARCHAR}, ",
        "#{majorDict,jdbcType=VARCHAR}, #{educationDict,jdbcType=VARCHAR}, ",
        "#{graduate,jdbcType=VARCHAR}, #{polity,jdbcType=VARCHAR}, ",
        "#{qq,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{createId,jdbcType=INTEGER}, ",
        "#{updateId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Users record);

    @InsertProvider(type=UsersSqlProvider.class, method="insertSelective")
    int insertSelective(Users record);

    @SelectProvider(type=UsersSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="idcard_address", property="idcardAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="idcard", property="idcard", jdbcType=JdbcType.VARCHAR),
        @Result(column="home_address", property="homeAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_tel", property="contactTel", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_name", property="contactName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_dict", property="bankDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="postion_level_dict", property="postionLevelDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="salary", property="salary", jdbcType=JdbcType.NUMERIC),
        @Result(column="postion_state", property="postionState", jdbcType=JdbcType.INTEGER),
        @Result(column="join_date", property="joinDate", jdbcType=JdbcType.DATE),
        @Result(column="leave_date", property="leaveDate", jdbcType=JdbcType.DATE),
        @Result(column="regular_date", property="regularDate", jdbcType=JdbcType.DATE),
        @Result(column="nation_dict", property="nationDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="postion_dict", property="postionDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="major_dict", property="majorDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="education_dict", property="educationDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="graduate", property="graduate", jdbcType=JdbcType.VARCHAR),
        @Result(column="polity", property="polity", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_id", property="createId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_id", property="updateId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Users> selectByExampleWithRowbounds(UsersExample example, RowBounds rowBounds);

    @SelectProvider(type=UsersSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="idcard_address", property="idcardAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="idcard", property="idcard", jdbcType=JdbcType.VARCHAR),
        @Result(column="home_address", property="homeAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_tel", property="contactTel", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_name", property="contactName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_dict", property="bankDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="postion_level_dict", property="postionLevelDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="salary", property="salary", jdbcType=JdbcType.NUMERIC),
        @Result(column="postion_state", property="postionState", jdbcType=JdbcType.INTEGER),
        @Result(column="join_date", property="joinDate", jdbcType=JdbcType.DATE),
        @Result(column="leave_date", property="leaveDate", jdbcType=JdbcType.DATE),
        @Result(column="regular_date", property="regularDate", jdbcType=JdbcType.DATE),
        @Result(column="nation_dict", property="nationDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="postion_dict", property="postionDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="major_dict", property="majorDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="education_dict", property="educationDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="graduate", property="graduate", jdbcType=JdbcType.VARCHAR),
        @Result(column="polity", property="polity", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_id", property="createId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_id", property="updateId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Users> selectByExample(UsersExample example);

    @Select({
        "select",
        "user_id, user_code, user_name, login_name, password, salt, sex, idcard_address, ",
        "idcard, home_address, tel, contact_tel, contact_name, bank_dict, bank_account, ",
        "birthday, state, postion_level_dict, salary, postion_state, join_date, leave_date, ",
        "regular_date, nation_dict, photo, remark, postion_dict, major_dict, education_dict, ",
        "graduate, polity, qq, email, create_id, update_id, create_time, update_time",
        "from users",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="idcard_address", property="idcardAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="idcard", property="idcard", jdbcType=JdbcType.VARCHAR),
        @Result(column="home_address", property="homeAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_tel", property="contactTel", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_name", property="contactName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_dict", property="bankDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="postion_level_dict", property="postionLevelDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="salary", property="salary", jdbcType=JdbcType.NUMERIC),
        @Result(column="postion_state", property="postionState", jdbcType=JdbcType.INTEGER),
        @Result(column="join_date", property="joinDate", jdbcType=JdbcType.DATE),
        @Result(column="leave_date", property="leaveDate", jdbcType=JdbcType.DATE),
        @Result(column="regular_date", property="regularDate", jdbcType=JdbcType.DATE),
        @Result(column="nation_dict", property="nationDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="postion_dict", property="postionDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="major_dict", property="majorDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="education_dict", property="educationDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="graduate", property="graduate", jdbcType=JdbcType.VARCHAR),
        @Result(column="polity", property="polity", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_id", property="createId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_id", property="updateId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Users selectByPrimaryKey(Integer userId);

    @UpdateProvider(type=UsersSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    @UpdateProvider(type=UsersSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    @UpdateProvider(type=UsersSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Users record);

    @Update({
        "update users",
        "set user_code = #{userCode,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "login_name = #{loginName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "salt = #{salt,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=INTEGER},",
          "idcard_address = #{idcardAddress,jdbcType=VARCHAR},",
          "idcard = #{idcard,jdbcType=VARCHAR},",
          "home_address = #{homeAddress,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "contact_tel = #{contactTel,jdbcType=VARCHAR},",
          "contact_name = #{contactName,jdbcType=VARCHAR},",
          "bank_dict = #{bankDict,jdbcType=VARCHAR},",
          "bank_account = #{bankAccount,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=DATE},",
          "state = #{state,jdbcType=INTEGER},",
          "postion_level_dict = #{postionLevelDict,jdbcType=VARCHAR},",
          "salary = #{salary,jdbcType=NUMERIC},",
          "postion_state = #{postionState,jdbcType=INTEGER},",
          "join_date = #{joinDate,jdbcType=DATE},",
          "leave_date = #{leaveDate,jdbcType=DATE},",
          "regular_date = #{regularDate,jdbcType=DATE},",
          "nation_dict = #{nationDict,jdbcType=VARCHAR},",
          "photo = #{photo,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "postion_dict = #{postionDict,jdbcType=VARCHAR},",
          "major_dict = #{majorDict,jdbcType=VARCHAR},",
          "education_dict = #{educationDict,jdbcType=VARCHAR},",
          "graduate = #{graduate,jdbcType=VARCHAR},",
          "polity = #{polity,jdbcType=VARCHAR},",
          "qq = #{qq,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "create_id = #{createId,jdbcType=INTEGER},",
          "update_id = #{updateId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Users record);
}