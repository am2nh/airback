/*Domain class of table m_prj_member*/
package com.airback.module.project.domain;

import com.airback.core.arguments.ValuedBean;
import com.airback.db.metadata.Column;
import com.airback.db.metadata.Table;
import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

@SuppressWarnings("ucd")
@Table("m_prj_member")
@Alias("ProjectMember")
public class ProjectMember extends ValuedBean {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_member.id
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    @Column("id")
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_member.username
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    @NotEmpty
    @Length(max=45, message="Field value is too long")
    @Column("username")
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_member.projectId
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    @NotNull
    @Column("projectId")
    private Integer projectid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_member.createdTime
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    @Column("createdTime")
    private LocalDateTime createdtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_member.projectRoleId
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    @Column("projectRoleId")
    private Integer projectroleid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_member.status
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    @NotEmpty
    @Length(max=45, message="Field value is too long")
    @Column("status")
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_member.sAccountId
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    @NotNull
    @Column("sAccountId")
    private Integer saccountid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_member.billingRate
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    @Column("billingRate")
    private Double billingrate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_member.overtimeBillingRate
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    @Column("overtimeBillingRate")
    private Double overtimebillingrate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_member.lastUpdatedTime
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    @Column("lastUpdatedTime")
    private LocalDateTime lastupdatedtime;

    private static final long serialVersionUID = 1;

    public final boolean equals(Object obj) {
        if (obj == null) { return false;}
        if (obj == this) { return true;}
        if (!obj.getClass().isAssignableFrom(getClass())) { return false;}
        ProjectMember item = (ProjectMember)obj;
        return new EqualsBuilder().append(id, item.id).build();
    }

    public final int hashCode() {
        return new HashCodeBuilder(1363, 1799).append(id).build();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_member.id
     *
     * @return the value of m_prj_member.id
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_prj_member
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public ProjectMember withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_member.id
     *
     * @param id the value for m_prj_member.id
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_member.username
     *
     * @return the value of m_prj_member.username
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_prj_member
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public ProjectMember withUsername(String username) {
        this.setUsername(username);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_member.username
     *
     * @param username the value for m_prj_member.username
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_member.projectId
     *
     * @return the value of m_prj_member.projectId
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public Integer getProjectid() {
        return projectid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_prj_member
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public ProjectMember withProjectid(Integer projectid) {
        this.setProjectid(projectid);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_member.projectId
     *
     * @param projectid the value for m_prj_member.projectId
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_member.createdTime
     *
     * @return the value of m_prj_member.createdTime
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public LocalDateTime getCreatedtime() {
        return createdtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_prj_member
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public ProjectMember withCreatedtime(LocalDateTime createdtime) {
        this.setCreatedtime(createdtime);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_member.createdTime
     *
     * @param createdtime the value for m_prj_member.createdTime
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public void setCreatedtime(LocalDateTime createdtime) {
        this.createdtime = createdtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_member.projectRoleId
     *
     * @return the value of m_prj_member.projectRoleId
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public Integer getProjectroleid() {
        return projectroleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_prj_member
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public ProjectMember withProjectroleid(Integer projectroleid) {
        this.setProjectroleid(projectroleid);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_member.projectRoleId
     *
     * @param projectroleid the value for m_prj_member.projectRoleId
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public void setProjectroleid(Integer projectroleid) {
        this.projectroleid = projectroleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_member.status
     *
     * @return the value of m_prj_member.status
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_prj_member
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public ProjectMember withStatus(String status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_member.status
     *
     * @param status the value for m_prj_member.status
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_member.sAccountId
     *
     * @return the value of m_prj_member.sAccountId
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public Integer getSaccountid() {
        return saccountid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_prj_member
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public ProjectMember withSaccountid(Integer saccountid) {
        this.setSaccountid(saccountid);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_member.sAccountId
     *
     * @param saccountid the value for m_prj_member.sAccountId
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public void setSaccountid(Integer saccountid) {
        this.saccountid = saccountid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_member.billingRate
     *
     * @return the value of m_prj_member.billingRate
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public Double getBillingrate() {
        return billingrate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_prj_member
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public ProjectMember withBillingrate(Double billingrate) {
        this.setBillingrate(billingrate);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_member.billingRate
     *
     * @param billingrate the value for m_prj_member.billingRate
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public void setBillingrate(Double billingrate) {
        this.billingrate = billingrate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_member.overtimeBillingRate
     *
     * @return the value of m_prj_member.overtimeBillingRate
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public Double getOvertimebillingrate() {
        return overtimebillingrate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_prj_member
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public ProjectMember withOvertimebillingrate(Double overtimebillingrate) {
        this.setOvertimebillingrate(overtimebillingrate);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_member.overtimeBillingRate
     *
     * @param overtimebillingrate the value for m_prj_member.overtimeBillingRate
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public void setOvertimebillingrate(Double overtimebillingrate) {
        this.overtimebillingrate = overtimebillingrate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_member.lastUpdatedTime
     *
     * @return the value of m_prj_member.lastUpdatedTime
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public LocalDateTime getLastupdatedtime() {
        return lastupdatedtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_prj_member
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public ProjectMember withLastupdatedtime(LocalDateTime lastupdatedtime) {
        this.setLastupdatedtime(lastupdatedtime);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_member.lastUpdatedTime
     *
     * @param lastupdatedtime the value for m_prj_member.lastUpdatedTime
     *
     * @mbg.generated Fri Apr 12 22:39:46 CDT 2019
     */
    public void setLastupdatedtime(LocalDateTime lastupdatedtime) {
        this.lastupdatedtime = lastupdatedtime;
    }

    public enum Field {
        id,
        username,
        projectid,
        createdtime,
        projectroleid,
        status,
        saccountid,
        billingrate,
        overtimebillingrate,
        lastupdatedtime;

        public boolean equalTo(Object value) {
            return name().equals(value);
        }
    }
}