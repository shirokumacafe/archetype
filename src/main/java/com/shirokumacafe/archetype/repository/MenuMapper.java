package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.Menu;
import com.shirokumacafe.archetype.entity.MenuExample;
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

public interface MenuMapper {
    @SelectProvider(type=MenuSqlProvider.class, method="countByExample")
    int countByExample(MenuExample example);

    @DeleteProvider(type=MenuSqlProvider.class, method="deleteByExample")
    int deleteByExample(MenuExample example);

    @Delete({
        "delete from menu",
        "where menu_id = #{menuId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer menuId);

    @Insert({
        "insert into menu (menu_id, menu_name, ",
        "menu_code, p_id, link, ",
        "orderno, state, ",
        "btn, level, create_id, ",
        "update_id, create_time, ",
        "update_time)",
        "values (#{menuId,jdbcType=INTEGER}, #{menuName,jdbcType=VARCHAR}, ",
        "#{menuCode,jdbcType=VARCHAR}, #{pId,jdbcType=INTEGER}, #{link,jdbcType=VARCHAR}, ",
        "#{orderno,jdbcType=INTEGER}, #{state,jdbcType=INTEGER}, ",
        "#{btn,jdbcType=INTEGER}, #{level,jdbcType=INTEGER}, #{createId,jdbcType=INTEGER}, ",
        "#{updateId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Menu record);

    @InsertProvider(type=MenuSqlProvider.class, method="insertSelective")
    int insertSelective(Menu record);

    @SelectProvider(type=MenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_code", property="menuCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_id", property="pId", jdbcType=JdbcType.INTEGER),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="orderno", property="orderno", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="btn", property="btn", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="create_id", property="createId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_id", property="updateId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Menu> selectByExampleWithRowbounds(MenuExample example, RowBounds rowBounds);

    @SelectProvider(type=MenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_code", property="menuCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_id", property="pId", jdbcType=JdbcType.INTEGER),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="orderno", property="orderno", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="btn", property="btn", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="create_id", property="createId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_id", property="updateId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Menu> selectByExample(MenuExample example);

    @Select({
        "select",
        "menu_id, menu_name, menu_code, p_id, link, orderno, state, btn, level, create_id, ",
        "update_id, create_time, update_time",
        "from menu",
        "where menu_id = #{menuId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_code", property="menuCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_id", property="pId", jdbcType=JdbcType.INTEGER),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="orderno", property="orderno", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="btn", property="btn", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="create_id", property="createId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_id", property="updateId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Menu selectByPrimaryKey(Integer menuId);

    @UpdateProvider(type=MenuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    @UpdateProvider(type=MenuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    @UpdateProvider(type=MenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Menu record);

    @Update({
        "update menu",
        "set menu_name = #{menuName,jdbcType=VARCHAR},",
          "menu_code = #{menuCode,jdbcType=VARCHAR},",
          "p_id = #{pId,jdbcType=INTEGER},",
          "link = #{link,jdbcType=VARCHAR},",
          "orderno = #{orderno,jdbcType=INTEGER},",
          "state = #{state,jdbcType=INTEGER},",
          "btn = #{btn,jdbcType=INTEGER},",
          "level = #{level,jdbcType=INTEGER},",
          "create_id = #{createId,jdbcType=INTEGER},",
          "update_id = #{updateId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where menu_id = #{menuId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Menu record);
}