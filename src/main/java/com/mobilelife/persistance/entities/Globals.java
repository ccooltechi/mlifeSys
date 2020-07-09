package com.mobilelife.persistance.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@javax.persistence.Table(name = "globals", catalog = "")
public class Globals implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;

    @Id
    @Column(name = "id", nullable = false, length = 20)

    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

    private String appId;

	@Basic
    @Column(name = "app_id", nullable = false, length = 20)
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    private Timestamp creationDatetime;

    @Basic
    @Column(name = "creation_datetime", nullable = false, length = 19)
    public Timestamp getCreationDatetime() {
        return creationDatetime;
    }

    public void setCreationDatetime(Timestamp creationDatetime) {
        this.creationDatetime = creationDatetime;
    }

    private Timestamp lastModDatetime;

    @Basic
    @Column(name = "last_mod_datetime", nullable = false, length = 19)
    public Timestamp getLastModDatetime() {
        return lastModDatetime;
    }

    public void setLastModDatetime(Timestamp lastModDatetime) {
        this.lastModDatetime = lastModDatetime;
    }

    private boolean isActive;

    @Basic
    @Column(name = "is_active")

    /**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

    private String keyName;

	@Basic
    @Column(name = "key_name", nullable = false, length = 100)
    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    private String keyValue;

    @Basic
    @Column(name = "key_value", nullable = false, length = 300)
    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    private String module;

    @Basic
    @Column(name = "module", nullable = false, length = 100)
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    private String remarks;

    @Basic
    @Column(name = "remarks", nullable = false, length = 500)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

//	private String htmlValue;
//	@Column(name = "htmlValue")
//	@Basic
//	public String getHtmlValue() {
//		return htmlValue;
//	}
//
//	public void setHtmlValue(String htmlValue) {
//		this.htmlValue = htmlValue;
//	}

	
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Globals that = (Globals) o;

        if (appId != null ? !appId.equals(that.appId) : that.appId != null) return false;
        if (creationDatetime != null ? !creationDatetime.equals(that.creationDatetime) : that.creationDatetime != null)
            return false;
        if (keyName != null ? !keyName.equals(that.keyName) : that.keyName != null) return false;
        if (keyValue != null ? !keyValue.equals(that.keyValue) : that.keyValue != null) return false;
        if (lastModDatetime != null ? !lastModDatetime.equals(that.lastModDatetime) : that.lastModDatetime != null)
            return false;
        if (module != null ? !module.equals(that.module) : that.module != null) return false;
        if (remarks != null ? !remarks.equals(that.remarks) : that.remarks != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }


	@Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (appId != null ? appId.hashCode() : 0);
        result = 31 * result + (creationDatetime != null ? creationDatetime.hashCode() : 0);
        result = 31 * result + (lastModDatetime != null ? lastModDatetime.hashCode() : 0);
        result = 31 * result + (keyName != null ? keyName.hashCode() : 0);
        result = 31 * result + (keyValue != null ? keyValue.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        return result;
    }
}
