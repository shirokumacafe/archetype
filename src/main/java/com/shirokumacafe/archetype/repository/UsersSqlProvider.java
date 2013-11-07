package com.shirokumacafe.archetype.repository;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.shirokumacafe.archetype.entity.Users;
import com.shirokumacafe.archetype.entity.UsersExample.Criteria;
import com.shirokumacafe.archetype.entity.UsersExample.Criterion;
import com.shirokumacafe.archetype.entity.UsersExample;
import java.util.List;
import java.util.Map;

public class UsersSqlProvider {

    public String countByExample(UsersExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("users");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(UsersExample example) {
        BEGIN();
        DELETE_FROM("users");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Users record) {
        BEGIN();
        INSERT_INTO("users");
        
        if (record.getUserCode() != null) {
            VALUES("user_code", "#{userCode,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginName() != null) {
            VALUES("login_name", "#{loginName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getSalt() != null) {
            VALUES("salt", "#{salt,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            VALUES("sex", "#{sex,jdbcType=INTEGER}");
        }
        
        if (record.getIdcardAddress() != null) {
            VALUES("idcard_address", "#{idcardAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getIdcard() != null) {
            VALUES("idcard", "#{idcard,jdbcType=VARCHAR}");
        }
        
        if (record.getHomeAddress() != null) {
            VALUES("home_address", "#{homeAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            VALUES("tel", "#{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getContactTel() != null) {
            VALUES("contact_tel", "#{contactTel,jdbcType=VARCHAR}");
        }
        
        if (record.getContactName() != null) {
            VALUES("contact_name", "#{contactName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankDict() != null) {
            VALUES("bank_dict", "#{bankDict,jdbcType=VARCHAR}");
        }
        
        if (record.getBankAccount() != null) {
            VALUES("bank_account", "#{bankAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            VALUES("birthday", "#{birthday,jdbcType=DATE}");
        }
        
        if (record.getState() != null) {
            VALUES("state", "#{state,jdbcType=INTEGER}");
        }
        
        if (record.getPostionLevelDict() != null) {
            VALUES("postion_level_dict", "#{postionLevelDict,jdbcType=VARCHAR}");
        }
        
        if (record.getSalary() != null) {
            VALUES("salary", "#{salary,jdbcType=NUMERIC}");
        }
        
        if (record.getPostionState() != null) {
            VALUES("postion_state", "#{postionState,jdbcType=INTEGER}");
        }
        
        if (record.getJoinDate() != null) {
            VALUES("join_date", "#{joinDate,jdbcType=DATE}");
        }
        
        if (record.getLeaveDate() != null) {
            VALUES("leave_date", "#{leaveDate,jdbcType=DATE}");
        }
        
        if (record.getRegularDate() != null) {
            VALUES("regular_date", "#{regularDate,jdbcType=DATE}");
        }
        
        if (record.getNationDict() != null) {
            VALUES("nation_dict", "#{nationDict,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoto() != null) {
            VALUES("photo", "#{photo,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getPostionDict() != null) {
            VALUES("postion_dict", "#{postionDict,jdbcType=VARCHAR}");
        }
        
        if (record.getMajorDict() != null) {
            VALUES("major_dict", "#{majorDict,jdbcType=VARCHAR}");
        }
        
        if (record.getEducationDict() != null) {
            VALUES("education_dict", "#{educationDict,jdbcType=VARCHAR}");
        }
        
        if (record.getGraduate() != null) {
            VALUES("graduate", "#{graduate,jdbcType=VARCHAR}");
        }
        
        if (record.getPolity() != null) {
            VALUES("polity", "#{polity,jdbcType=VARCHAR}");
        }
        
        if (record.getQq() != null) {
            VALUES("qq", "#{qq,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateId() != null) {
            VALUES("create_id", "#{createId,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateId() != null) {
            VALUES("update_id", "#{updateId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String selectByExample(UsersExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("user_id");
        } else {
            SELECT("user_id");
        }
        SELECT("user_code");
        SELECT("user_name");
        SELECT("login_name");
        SELECT("password");
        SELECT("salt");
        SELECT("sex");
        SELECT("idcard_address");
        SELECT("idcard");
        SELECT("home_address");
        SELECT("tel");
        SELECT("contact_tel");
        SELECT("contact_name");
        SELECT("bank_dict");
        SELECT("bank_account");
        SELECT("birthday");
        SELECT("state");
        SELECT("postion_level_dict");
        SELECT("salary");
        SELECT("postion_state");
        SELECT("join_date");
        SELECT("leave_date");
        SELECT("regular_date");
        SELECT("nation_dict");
        SELECT("photo");
        SELECT("remark");
        SELECT("postion_dict");
        SELECT("major_dict");
        SELECT("education_dict");
        SELECT("graduate");
        SELECT("polity");
        SELECT("qq");
        SELECT("email");
        SELECT("create_id");
        SELECT("update_id");
        SELECT("create_time");
        SELECT("update_time");
        FROM("users");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Users record = (Users) parameter.get("record");
        UsersExample example = (UsersExample) parameter.get("example");
        
        BEGIN();
        UPDATE("users");
        
        if (record.getUserId() != null) {
            SET("user_id = #{record.userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserCode() != null) {
            SET("user_code = #{record.userCode,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginName() != null) {
            SET("login_name = #{record.loginName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getSalt() != null) {
            SET("salt = #{record.salt,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            SET("sex = #{record.sex,jdbcType=INTEGER}");
        }
        
        if (record.getIdcardAddress() != null) {
            SET("idcard_address = #{record.idcardAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getIdcard() != null) {
            SET("idcard = #{record.idcard,jdbcType=VARCHAR}");
        }
        
        if (record.getHomeAddress() != null) {
            SET("home_address = #{record.homeAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            SET("tel = #{record.tel,jdbcType=VARCHAR}");
        }
        
        if (record.getContactTel() != null) {
            SET("contact_tel = #{record.contactTel,jdbcType=VARCHAR}");
        }
        
        if (record.getContactName() != null) {
            SET("contact_name = #{record.contactName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankDict() != null) {
            SET("bank_dict = #{record.bankDict,jdbcType=VARCHAR}");
        }
        
        if (record.getBankAccount() != null) {
            SET("bank_account = #{record.bankAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            SET("birthday = #{record.birthday,jdbcType=DATE}");
        }
        
        if (record.getState() != null) {
            SET("state = #{record.state,jdbcType=INTEGER}");
        }
        
        if (record.getPostionLevelDict() != null) {
            SET("postion_level_dict = #{record.postionLevelDict,jdbcType=VARCHAR}");
        }
        
        if (record.getSalary() != null) {
            SET("salary = #{record.salary,jdbcType=NUMERIC}");
        }
        
        if (record.getPostionState() != null) {
            SET("postion_state = #{record.postionState,jdbcType=INTEGER}");
        }
        
        if (record.getJoinDate() != null) {
            SET("join_date = #{record.joinDate,jdbcType=DATE}");
        }
        
        if (record.getLeaveDate() != null) {
            SET("leave_date = #{record.leaveDate,jdbcType=DATE}");
        }
        
        if (record.getRegularDate() != null) {
            SET("regular_date = #{record.regularDate,jdbcType=DATE}");
        }
        
        if (record.getNationDict() != null) {
            SET("nation_dict = #{record.nationDict,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoto() != null) {
            SET("photo = #{record.photo,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getPostionDict() != null) {
            SET("postion_dict = #{record.postionDict,jdbcType=VARCHAR}");
        }
        
        if (record.getMajorDict() != null) {
            SET("major_dict = #{record.majorDict,jdbcType=VARCHAR}");
        }
        
        if (record.getEducationDict() != null) {
            SET("education_dict = #{record.educationDict,jdbcType=VARCHAR}");
        }
        
        if (record.getGraduate() != null) {
            SET("graduate = #{record.graduate,jdbcType=VARCHAR}");
        }
        
        if (record.getPolity() != null) {
            SET("polity = #{record.polity,jdbcType=VARCHAR}");
        }
        
        if (record.getQq() != null) {
            SET("qq = #{record.qq,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateId() != null) {
            SET("create_id = #{record.createId,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateId() != null) {
            SET("update_id = #{record.updateId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("users");
        
        SET("user_id = #{record.userId,jdbcType=INTEGER}");
        SET("user_code = #{record.userCode,jdbcType=VARCHAR}");
        SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        SET("login_name = #{record.loginName,jdbcType=VARCHAR}");
        SET("password = #{record.password,jdbcType=VARCHAR}");
        SET("salt = #{record.salt,jdbcType=VARCHAR}");
        SET("sex = #{record.sex,jdbcType=INTEGER}");
        SET("idcard_address = #{record.idcardAddress,jdbcType=VARCHAR}");
        SET("idcard = #{record.idcard,jdbcType=VARCHAR}");
        SET("home_address = #{record.homeAddress,jdbcType=VARCHAR}");
        SET("tel = #{record.tel,jdbcType=VARCHAR}");
        SET("contact_tel = #{record.contactTel,jdbcType=VARCHAR}");
        SET("contact_name = #{record.contactName,jdbcType=VARCHAR}");
        SET("bank_dict = #{record.bankDict,jdbcType=VARCHAR}");
        SET("bank_account = #{record.bankAccount,jdbcType=VARCHAR}");
        SET("birthday = #{record.birthday,jdbcType=DATE}");
        SET("state = #{record.state,jdbcType=INTEGER}");
        SET("postion_level_dict = #{record.postionLevelDict,jdbcType=VARCHAR}");
        SET("salary = #{record.salary,jdbcType=NUMERIC}");
        SET("postion_state = #{record.postionState,jdbcType=INTEGER}");
        SET("join_date = #{record.joinDate,jdbcType=DATE}");
        SET("leave_date = #{record.leaveDate,jdbcType=DATE}");
        SET("regular_date = #{record.regularDate,jdbcType=DATE}");
        SET("nation_dict = #{record.nationDict,jdbcType=VARCHAR}");
        SET("photo = #{record.photo,jdbcType=VARCHAR}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("postion_dict = #{record.postionDict,jdbcType=VARCHAR}");
        SET("major_dict = #{record.majorDict,jdbcType=VARCHAR}");
        SET("education_dict = #{record.educationDict,jdbcType=VARCHAR}");
        SET("graduate = #{record.graduate,jdbcType=VARCHAR}");
        SET("polity = #{record.polity,jdbcType=VARCHAR}");
        SET("qq = #{record.qq,jdbcType=VARCHAR}");
        SET("email = #{record.email,jdbcType=VARCHAR}");
        SET("create_id = #{record.createId,jdbcType=INTEGER}");
        SET("update_id = #{record.updateId,jdbcType=INTEGER}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        UsersExample example = (UsersExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Users record) {
        BEGIN();
        UPDATE("users");
        
        if (record.getUserCode() != null) {
            SET("user_code = #{userCode,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginName() != null) {
            SET("login_name = #{loginName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getSalt() != null) {
            SET("salt = #{salt,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            SET("sex = #{sex,jdbcType=INTEGER}");
        }
        
        if (record.getIdcardAddress() != null) {
            SET("idcard_address = #{idcardAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getIdcard() != null) {
            SET("idcard = #{idcard,jdbcType=VARCHAR}");
        }
        
        if (record.getHomeAddress() != null) {
            SET("home_address = #{homeAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            SET("tel = #{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getContactTel() != null) {
            SET("contact_tel = #{contactTel,jdbcType=VARCHAR}");
        }
        
        if (record.getContactName() != null) {
            SET("contact_name = #{contactName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankDict() != null) {
            SET("bank_dict = #{bankDict,jdbcType=VARCHAR}");
        }
        
        if (record.getBankAccount() != null) {
            SET("bank_account = #{bankAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            SET("birthday = #{birthday,jdbcType=DATE}");
        }
        
        if (record.getState() != null) {
            SET("state = #{state,jdbcType=INTEGER}");
        }
        
        if (record.getPostionLevelDict() != null) {
            SET("postion_level_dict = #{postionLevelDict,jdbcType=VARCHAR}");
        }
        
        if (record.getSalary() != null) {
            SET("salary = #{salary,jdbcType=NUMERIC}");
        }
        
        if (record.getPostionState() != null) {
            SET("postion_state = #{postionState,jdbcType=INTEGER}");
        }
        
        if (record.getJoinDate() != null) {
            SET("join_date = #{joinDate,jdbcType=DATE}");
        }
        
        if (record.getLeaveDate() != null) {
            SET("leave_date = #{leaveDate,jdbcType=DATE}");
        }
        
        if (record.getRegularDate() != null) {
            SET("regular_date = #{regularDate,jdbcType=DATE}");
        }
        
        if (record.getNationDict() != null) {
            SET("nation_dict = #{nationDict,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoto() != null) {
            SET("photo = #{photo,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getPostionDict() != null) {
            SET("postion_dict = #{postionDict,jdbcType=VARCHAR}");
        }
        
        if (record.getMajorDict() != null) {
            SET("major_dict = #{majorDict,jdbcType=VARCHAR}");
        }
        
        if (record.getEducationDict() != null) {
            SET("education_dict = #{educationDict,jdbcType=VARCHAR}");
        }
        
        if (record.getGraduate() != null) {
            SET("graduate = #{graduate,jdbcType=VARCHAR}");
        }
        
        if (record.getPolity() != null) {
            SET("polity = #{polity,jdbcType=VARCHAR}");
        }
        
        if (record.getQq() != null) {
            SET("qq = #{qq,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateId() != null) {
            SET("create_id = #{createId,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateId() != null) {
            SET("update_id = #{updateId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("user_id = #{userId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(UsersExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}