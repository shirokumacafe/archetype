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
        "where menu_code = #{menuCode,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String menuCode);

    @Insert({
        "insert into menu (menu_code, menu_parent, ",
        "menu_name, link, ",
        "sort, state, btn)",
        "values (#{menuCode,jdbcType=VARCHAR}, #{menuParent,jdbcType=VARCHAR}, ",
        "#{menuName,jdbcType=VARCHAR}, #{link,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=INTEGER}, #{state,jdbcType=INTEGER}, #{btn,jdbcType=INTEGER})"
    })
    int insert(Menu record);

    @InsertProvider(type=MenuSqlProvider.class, method="insertSelective")
    int insertSelective(Menu record);

    @SelectProvider(type=MenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="menu_code", property="menuCode", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="menu_parent", property="menuParent", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="btn", property="btn", jdbcType=JdbcType.INTEGER)
    })
    List<Menu> selectByExampleWithRowbounds(MenuExample example, RowBounds rowBounds);

    @SelectProvider(type=MenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="menu_code", property="menuCode", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="menu_parent", property="menuParent", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="btn", property="btn", jdbcType=JdbcType.INTEGER)
    })
    List<Menu> selectByExample(MenuExample example);

    @Select({
        "select",
        "menu_code, menu_parent, menu_name, link, sort, state, btn",
        "from menu",
        "where menu_code = #{menuCode,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="menu_code", property="menuCode", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="menu_parent", property="menuParent", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="btn", property="btn", jdbcType=JdbcType.INTEGER)
    })
    Menu selectByPrimaryKey(String menuCode);

    @UpdateProvider(type=MenuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    @UpdateProvider(type=MenuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    @UpdateProvider(type=MenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Menu record);

    @Update({
        "update menu",
        "set menu_parent = #{menuParent,jdbcType=VARCHAR},",
          "menu_name = #{menuName,jdbcType=VARCHAR},",
          "link = #{link,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "state = #{state,jdbcType=INTEGER},",
          "btn = #{btn,jdbcType=INTEGER}",
        "where menu_code = #{menuCode,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Menu record);
}