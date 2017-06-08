package de.greenrobot.daoexample;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

import de.greenrobot.daoexample.Grade;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table GRADE.
*/
public class GradeDao extends AbstractDao<Grade, Long> {

    public static final String TABLENAME = "GRADE";

    /**
     * Properties of entity Grade.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property GradeID = new Property(0, Long.class, "GradeID", true, "GRADE_ID");
        public final static Property SchoolID = new Property(1, Integer.class, "SchoolID", false, "SCHOOL_ID");
        public final static Property GradeCode = new Property(2, String.class, "GradeCode", false, "GRADE_CODE");
        public final static Property GradeName = new Property(3, String.class, "GradeName", false, "GRADE_NAME");
        public final static Property Remark1 = new Property(4, String.class, "Remark1", false, "REMARK1");
    };

    private DaoSession daoSession;


    public GradeDao(DaoConfig config) {
        super(config);
    }
    
    public GradeDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'GRADE' (" + //
                "'GRADE_ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: GradeID
                "'SCHOOL_ID' INTEGER," + // 1: SchoolID
                "'GRADE_CODE' TEXT," + // 2: GradeCode
                "'GRADE_NAME' TEXT," + // 3: GradeName
                "'REMARK1' TEXT);"); // 4: Remark1
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'GRADE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Grade entity) {
        stmt.clearBindings();
 
        Long GradeID = entity.getGradeID();
        if (GradeID != null) {
            stmt.bindLong(1, GradeID);
        }
 
        Integer SchoolID = entity.getSchoolID();
        if (SchoolID != null) {
            stmt.bindLong(2, SchoolID);
        }
 
        String GradeCode = entity.getGradeCode();
        if (GradeCode != null) {
            stmt.bindString(3, GradeCode);
        }
 
        String GradeName = entity.getGradeName();
        if (GradeName != null) {
            stmt.bindString(4, GradeName);
        }
 
        String Remark1 = entity.getRemark1();
        if (Remark1 != null) {
            stmt.bindString(5, Remark1);
        }
    }

    @Override
    protected void attachEntity(Grade entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Grade readEntity(Cursor cursor, int offset) {
        Grade entity = new Grade( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // GradeID
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // SchoolID
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // GradeCode
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // GradeName
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // Remark1
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Grade entity, int offset) {
        entity.setGradeID(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSchoolID(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setGradeCode(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setGradeName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setRemark1(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Grade entity, long rowId) {
        entity.setGradeID(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Grade entity) {
        if(entity != null) {
            return entity.getGradeID();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getClassDao().getAllColumns());
            builder.append(" FROM GRADE T");
            builder.append(" LEFT JOIN CLASS T0 ON T.'GRADE_ID'=T0.'CLASS_ID'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Grade loadCurrentDeep(Cursor cursor, boolean lock) {
        Grade entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Class class = loadCurrentOther(daoSession.getClassDao(), cursor, offset);
        entity.setClass(class);

        return entity;    
    }

    public Grade loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Grade> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Grade> list = new ArrayList<Grade>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Grade> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Grade> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}