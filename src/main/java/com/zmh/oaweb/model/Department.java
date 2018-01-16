package com.zmh.oaweb.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Department extends DepartmentKey implements Serializable {
    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 职位名称
     */
    private String jobName;

    /**
     * 岗位职能
     */
    private String postFunction;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getPostFunction() {
        return postFunction;
    }

    public void setPostFunction(String postFunction) {
        this.postFunction = postFunction;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Department other = (Department) that;
        return (this.getJobId() == null ? other.getJobId() == null : this.getJobId().equals(other.getJobId()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getDepartmentName() == null ? other.getDepartmentName() == null : this.getDepartmentName().equals(other.getDepartmentName()))
            && (this.getJobName() == null ? other.getJobName() == null : this.getJobName().equals(other.getJobName()))
            && (this.getPostFunction() == null ? other.getPostFunction() == null : this.getPostFunction().equals(other.getPostFunction()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getJobId() == null) ? 0 : getJobId().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getDepartmentName() == null) ? 0 : getDepartmentName().hashCode());
        result = prime * result + ((getJobName() == null) ? 0 : getJobName().hashCode());
        result = prime * result + ((getPostFunction() == null) ? 0 : getPostFunction().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", departmentName=").append(departmentName);
        sb.append(", jobName=").append(jobName);
        sb.append(", postFunction=").append(postFunction);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}