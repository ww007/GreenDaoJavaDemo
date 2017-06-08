package de.greenrobot.daoexample;

import de.greenrobot.daoexample.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table GRADE.
 */
public class Grade {

    private Long GradeID;
    private Integer SchoolID;
    private String GradeCode;
    private String GradeName;
    private String Remark1;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient GradeDao myDao;

    private Class class;
    private Long class__resolvedKey;


    public Grade() {
    }

    public Grade(Long GradeID) {
        this.GradeID = GradeID;
    }

    public Grade(Long GradeID, Integer SchoolID, String GradeCode, String GradeName, String Remark1) {
        this.GradeID = GradeID;
        this.SchoolID = SchoolID;
        this.GradeCode = GradeCode;
        this.GradeName = GradeName;
        this.Remark1 = Remark1;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getGradeDao() : null;
    }

    public Long getGradeID() {
        return GradeID;
    }

    public void setGradeID(Long GradeID) {
        this.GradeID = GradeID;
    }

    public Integer getSchoolID() {
        return SchoolID;
    }

    public void setSchoolID(Integer SchoolID) {
        this.SchoolID = SchoolID;
    }

    public String getGradeCode() {
        return GradeCode;
    }

    public void setGradeCode(String GradeCode) {
        this.GradeCode = GradeCode;
    }

    public String getGradeName() {
        return GradeName;
    }

    public void setGradeName(String GradeName) {
        this.GradeName = GradeName;
    }

    public String getRemark1() {
        return Remark1;
    }

    public void setRemark1(String Remark1) {
        this.Remark1 = Remark1;
    }

    /** To-one relationship, resolved on first access. */
    public Class getClass() {
        Long __key = this.GradeID;
        if (class__resolvedKey == null || !class__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ClassDao targetDao = daoSession.getClassDao();
            Class classNew = targetDao.load(__key);
            synchronized (this) {
                class = classNew;
            	class__resolvedKey = __key;
            }
        }
        return class;
    }

    public void setClass(Class class) {
        synchronized (this) {
            this.class = class;
            GradeID = class == null ? null : class.getClassID();
            class__resolvedKey = GradeID;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}