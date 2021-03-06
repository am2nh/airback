package com.airback.module.user.dao;

import com.airback.db.persistence.ICrudGenericDAO;
import com.airback.module.user.domain.UserPermission;
import com.airback.module.user.domain.UserPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@SuppressWarnings({ "ucd", "rawtypes" })
@Mapper
public interface UserPermissionMapper extends ICrudGenericDAO {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user_permission
     *
     * @mbg.generated Sat Mar 16 20:37:45 CDT 2019
     */
    long countByExample(UserPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user_permission
     *
     * @mbg.generated Sat Mar 16 20:37:45 CDT 2019
     */
    int deleteByExample(UserPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user_permission
     *
     * @mbg.generated Sat Mar 16 20:37:45 CDT 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user_permission
     *
     * @mbg.generated Sat Mar 16 20:37:45 CDT 2019
     */
    int insert(UserPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user_permission
     *
     * @mbg.generated Sat Mar 16 20:37:45 CDT 2019
     */
    int insertSelective(UserPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user_permission
     *
     * @mbg.generated Sat Mar 16 20:37:45 CDT 2019
     */
    List<UserPermission> selectByExample(UserPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user_permission
     *
     * @mbg.generated Sat Mar 16 20:37:45 CDT 2019
     */
    UserPermission selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user_permission
     *
     * @mbg.generated Sat Mar 16 20:37:45 CDT 2019
     */
    int updateByExampleSelective(@Param("record") UserPermission record, @Param("example") UserPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user_permission
     *
     * @mbg.generated Sat Mar 16 20:37:45 CDT 2019
     */
    int updateByExample(@Param("record") UserPermission record, @Param("example") UserPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user_permission
     *
     * @mbg.generated Sat Mar 16 20:37:45 CDT 2019
     */
    int updateByPrimaryKeySelective(UserPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user_permission
     *
     * @mbg.generated Sat Mar 16 20:37:45 CDT 2019
     */
    int updateByPrimaryKey(UserPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user_permission
     *
     * @mbg.generated Sat Mar 16 20:37:45 CDT 2019
     */
    Integer insertAndReturnKey(UserPermission value);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user_permission
     *
     * @mbg.generated Sat Mar 16 20:37:45 CDT 2019
     */
    void removeKeysWithSession(List primaryKeys);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_user_permission
     *
     * @mbg.generated Sat Mar 16 20:37:45 CDT 2019
     */
    void massUpdateWithSession(@Param("record") UserPermission record, @Param("primaryKeys") List primaryKeys);
}