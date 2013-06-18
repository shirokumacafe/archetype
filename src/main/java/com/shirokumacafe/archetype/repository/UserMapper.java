package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.User;
import com.shirokumacafe.archetype.entity.UserExample;
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

public interface UserMapper {
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    int countByExample(UserExample example);

    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    @Delete({
        "delete from user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
        "insert into user (user_id, user_code, ",
        "user_name, login_name, ",
        "password, salt, ",
        "sex, idcard_address, ",
        "idcard, home_address, ",
        "tel, contact_tel, ",
        "contact_name, bank_id, ",
        "bank_account, birthday, ",
        "state, postion_level_id, ",
        "salary, postion_state, ",
        "join_date, leave_date, regular_date, ",
        "nation_id, photo, ",
        "remark, postion_id, ",
        "major_id, education_id, ",
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
        "#{contactName,jdbcType=VARCHAR}, #{bankId,jdbcType=INTEGER}, ",
        "#{bankAccount,jdbcType=VARCHAR}, #{birthday,jdbcType=DATE}, ",
        "#{state,jdbcType=INTEGER}, #{postionLevelId,jdbcType=INTEGER}, ",
        "#{salary,jdbcType=NUMERIC}, #{postionState,jdbcType=INTEGER}, ",
        "#{joinDate,jdbcType=DATE}, #{leaveDate,jdbcType=DATE}, #{regularDate,jdbcType=DATE}, ",
        "#{nationId,jdbcType=INTEGER}, #{photo,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{postionId,jdbcType=INTEGER}, ",
        "#{majorId,jdbcType=INTEGER}, #{educationId,jdbcType=INTEGER}, ",
        "#{graduate,jdbcType=VARCHAR}, #{polity,jdbcType=VARCHAR}, ",
        "#{qq,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{createId,jdbcType=INTEGER}, ",
        "#{updateId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
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
        @Result(column="bank_id", property="bankId", jdbcType=JdbcType.INTEGER),
        @Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="postion_level_id", property="postionLevelId", jdbcType=JdbcType.INTEGER),
        @Result(column="salary", property="salary", jdbcType=JdbcType.NUMERIC),
        @Result(column="postion_state", property="postionState", jdbcType=JdbcType.INTEGER),
        @Result(column="join_date", property="joinDate", jdbcType=JdbcType.DATE),
        @Result(column="leave_date", property="leaveDate", jdbcType=JdbcType.DATE),
        @Result(column="regular_date", property="regularDate", jdbcType=JdbcType.DATE),
        @Result(column="nation_id", property="nationId", jdbcType=JdbcType.INTEGER),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="postion_id", property="postionId", jdbcType=JdbcType.INTEGER),
        @Result(column="major_id", property="majorId", jdbcType=JdbcType.INTEGER),
        @Result(column="education_id", property="educationId", jdbcType=JdbcType.INTEGER),
        @Result(column="graduate", property="graduate", jdbcType=JdbcType.VARCHAR),
        @Result(column="polity", property="polity", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_id", property="createId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_id", property="updateId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<User> selectByExampleWithRowbounds(UserExample example, RowBounds rowBounds);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
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
        @Result(column="bank_id", property="bankId", jdbcType=JdbcType.INTEGER),
        @Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="postion_level_id", property="postionLevelId", jdbcType=JdbcType.INTEGER),
        @Result(column="salary", property="salary", jdbcType=JdbcType.NUMERIC),
        @Result(column="postion_state", property="postionState", jdbcType=JdbcType.INTEGER),
        @Result(column="join_date", property="joinDate", jdbcType=JdbcType.DATE),
        @Result(column="leave_date", property="leaveDate", jdbcType=JdbcType.DATE),
        @Result(column="regular_date", property="regularDate", jdbcType=JdbcType.DATE),
        @Result(column="nation_id", property="nationId", jdbcType=JdbcType.INTEGER),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="postion_id", property="postionId", jdbcType=JdbcType.INTEGER),
        @Result(column="major_id", property="majorId", jdbcType=JdbcType.INTEGER),
        @Result(column="education_id", property="educationId", jdbcType=JdbcType.INTEGER),
        @Result(column="graduate", property="graduate", jdbcType=JdbcType.VARCHAR),
        @Result(column="polity", property="polity", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_id", property="createId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_id", property="updateId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "user_id, user_code, user_name, login_name, password, salt, sex, idcard_address, ",
        "idcard, home_address, tel, contact_tel, contact_name, bank_id, bank_account, ",
        "birthday, state, postion_level_id, salary, postion_state, join_date, leave_date, ",
        "regular_date, nation_id, photo, remark, postion_id, major_id, education_id, ",
        "graduate, polity, qq, email, create_id, update_id, create_time, update_time",
        "from user",
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
        @Result(column="bank_id", property="bankId", jdbcType=JdbcType.INTEGER),
        @Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="postion_level_id", property="postionLevelId", jdbcType=JdbcType.INTEGER),
        @Result(column="salary", property="salary", jdbcType=JdbcType.NUMERIC),
        @Result(column="postion_state", property="postionState", jdbcType=JdbcType.INTEGER),
        @Result(column="join_date", property="joinDate", jdbcType=JdbcType.DATE),
        @Result(column="leave_date", property="leaveDate", jdbcType=JdbcType.DATE),
        @Result(column="regular_date", property="regularDate", jdbcType=JdbcType.DATE),
        @Result(column="nation_id", property="nationId", jdbcType=JdbcType.INTEGER),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="postion_id", property="postionId", jdbcType=JdbcType.INTEGER),
        @Result(column="major_id", property="majorId", jdbcType=JdbcType.INTEGER),
        @Result(column="education_id", property="educationId", jdbcType=JdbcType.INTEGER),
        @Result(column="graduate", property="graduate", jdbcType=JdbcType.VARCHAR),
        @Result(column="polity", property="polity", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_id", property="createId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_id", property="updateId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(Integer userId);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
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
          "bank_id = #{bankId,jdbcType=INTEGER},",
          "bank_account = #{bankAccount,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=DATE},",
          "state = #{state,jdbcType=INTEGER},",
          "postion_level_id = #{postionLevelId,jdbcType=INTEGER},",
          "salary = #{salary,jdbcType=NUMERIC},",
          "postion_state = #{postionState,jdbcType=INTEGER},",
          "join_date = #{joinDate,jdbcType=DATE},",
          "leave_date = #{leaveDate,jdbcType=DATE},",
          "regular_date = #{regularDate,jdbcType=DATE},",
          "nation_id = #{nationId,jdbcType=INTEGER},",
          "photo = #{photo,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "postion_id = #{postionId,jdbcType=INTEGER},",
          "major_id = #{majorId,jdbcType=INTEGER},",
          "education_id = #{educationId,jdbcType=INTEGER},",
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
    int updateByPrimaryKey(User record);
}