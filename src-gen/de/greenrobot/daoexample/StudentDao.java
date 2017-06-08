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

import de.greenrobot.daoexample.Student;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table STUDENT.
*/
public class StudentDao extends AbstractDao<Student, Long> {

    public static final String TABLENAME = "STUDENT";

    /**
     * Properties of entity Student.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property StudentID = new Property(0, Long.class, "StudentID", true, "STUDENT_ID");
        public final static Property StudentCode = new Property(1, String.class, "StudentCode", false, "STUDENT_CODE");
        public final static Property StudentName = new Property(2, String.class, "StudentName", false, "STUDENT_NAME");
        public final static Property Sex = new Property(3, Integer.class, "Sex", false, "SEX");
        public final static Property ClassID = new Property(4, Integer.class, "ClassID", false, "CLASS_ID");
        public final static Property GradeID = new Property(5, Integer.class, "GradeID", false, "GRADE_ID");
        public final static Property IDCardNo = new Property(6, String.class, "IDCardNo", false, "IDCARD_NO");
        public final static Property ICCardNo = new Property(7, String.class, "ICCardNo", false, "ICCARD_NO");
        public final static Property DownloadTime = new Property(8, String.class, "DownloadTime", false, "DOWNLOAD_TIME");
        public final static Property Remark1 = new Property(9, String.class, "Remark1", false, "REMARK1");
        public final static Property Remark2 = new Property(10, String.class, "Remark2", false, "REMARK2");
        public final static Property Remark3 = new Property(11, String.class, "Remark3", false, "REMARK3");
    };

    private DaoSession daoSession;


    public StudentDao(DaoConfig config) {
        super(config);
    }
    
    public StudentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'STUDENT' (" + //
                "'STUDENT_ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: StudentID
                "'STUDENT_CODE' TEXT," + // 1: StudentCode
                "'STUDENT_NAME' TEXT," + // 2: StudentName
                "'SEX' INTEGER," + // 3: Sex
                "'CLASS_ID' INTEGER," + // 4: ClassID
                "'GRADE_ID' INTEGER," + // 5: GradeID
                "'IDCARD_NO' TEXT," + // 6: IDCardNo
                "'ICCARD_NO' TEXT," + // 7: ICCardNo
                "'DOWNLOAD_TIME' TEXT," + // 8: DownloadTime
                "'REMARK1' TEXT," + // 9: Remark1
                "'REMARK2' TEXT," + // 10: Remark2
                "'REMARK3' TEXT);"); // 11: Remark3
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'STUDENT'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Student entity) {
        stmt.clearBindings();
 
        Long StudentID = entity.getStudentID();
        if (StudentID != null) {
            stmt.bindLong(1, StudentID);
        }
 
        String StudentCode = entity.getStudentCode();
        if (StudentCode != null) {
            stmt.bindString(2, StudentCode);
        }
 
        String StudentName = entity.getStudentName();
        if (StudentName != null) {
            stmt.bindString(3, StudentName);
        }
 
        Integer Sex = entity.getSex();
        if (Sex != null) {
            stmt.bindLong(4, Sex);
        }
 
        Integer ClassID = entity.getClassID();
        if (ClassID != null) {
            stmt.bindLong(5, ClassID);
        }
 
        Integer GradeID = entity.getGradeID();
        if (GradeID != null) {
            stmt.bindLong(6, GradeID);
        }
 
        String IDCardNo = entity.getIDCardNo();
        if (IDCardNo != null) {
            stmt.bindString(7, IDCardNo);
        }
 
        String ICCardNo = entity.getICCardNo();
        if (ICCardNo != null) {
            stmt.bindString(8, ICCardNo);
        }
 
        String DownloadTime = entity.getDownloadTime();
        if (DownloadTime != null) {
            stmt.bindString(9, DownloadTime);
        }
 
        String Remark1 = entity.getRemark1();
        if (Remark1 != null) {
            stmt.bindString(10, Remark1);
        }
 
        String Remark2 = entity.getRemark2();
        if (Remark2 != null) {
            stmt.bindString(11, Remark2);
        }
 
        String Remark3 = entity.getRemark3();
        if (Remark3 != null) {
            stmt.bindString(12, Remark3);
        }
    }

    @Override
    protected void attachEntity(Student entity) {
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
    public Student readEntity(Cursor cursor, int offset) {
        Student entity = new Student( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // StudentID
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // StudentCode
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // StudentName
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // Sex
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // ClassID
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // GradeID
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // IDCardNo
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // ICCardNo
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // DownloadTime
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // Remark1
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // Remark2
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11) // Remark3
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Student entity, int offset) {
        entity.setStudentID(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setStudentCode(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setStudentName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSex(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setClassID(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setGradeID(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setIDCardNo(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setICCardNo(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setDownloadTime(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setRemark1(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setRemark2(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setRemark3(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Student entity, long rowId) {
        entity.setStudentID(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Student entity) {
        if(entity != null) {
            return entity.getStudentID();
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getStudentItemDao().getAllColumns());
            builder.append(" FROM STUDENT T");
            builder.append(" LEFT JOIN STUDENT_ITEM T0 ON T.'STUDENT_ID'=T0.'STUDENT_ITEM_ID'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Student loadCurrentDeep(Cursor cursor, boolean lock) {
        Student entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        StudentItem studentItem = loadCurrentOther(daoSession.getStudentItemDao(), cursor, offset);
        entity.setStudentItem(studentItem);

        return entity;    
    }

    public Student loadDeep(Long key) {
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
    public List<Student> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Student> list = new ArrayList<Student>(count);
        
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
    
    protected List<Student> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Student> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
