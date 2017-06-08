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

import de.greenrobot.daoexample.Item;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table ITEM.
*/
public class ItemDao extends AbstractDao<Item, Long> {

    public static final String TABLENAME = "ITEM";

    /**
     * Properties of entity Item.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ItemID = new Property(0, Long.class, "ItemID", true, "ITEM_ID");
        public final static Property ItemCode = new Property(1, String.class, "ItemCode", false, "ITEM_CODE");
        public final static Property ItemName = new Property(2, String.class, "ItemName", false, "ITEM_NAME");
        public final static Property MinValue = new Property(3, Integer.class, "MinValue", false, "MIN_VALUE");
        public final static Property MaxValue = new Property(4, Integer.class, "MaxValue", false, "MAX_VALUE");
        public final static Property Unit = new Property(5, String.class, "Unit", false, "UNIT");
        public final static Property DataLen = new Property(6, Integer.class, "DataLen", false, "DATA_LEN");
        public final static Property CarryMode = new Property(7, Integer.class, "CarryMode", false, "CARRY_MODE");
        public final static Property ItemType = new Property(8, Integer.class, "ItemType", false, "ITEM_TYPE");
        public final static Property MachineCode = new Property(9, String.class, "MachineCode", false, "MACHINE_CODE");
        public final static Property IsEnable = new Property(10, Integer.class, "IsEnable", false, "IS_ENABLE");
        public final static Property Remark1 = new Property(11, String.class, "Remark1", false, "REMARK1");
    };

    private DaoSession daoSession;


    public ItemDao(DaoConfig config) {
        super(config);
    }
    
    public ItemDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'ITEM' (" + //
                "'ITEM_ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: ItemID
                "'ITEM_CODE' TEXT," + // 1: ItemCode
                "'ITEM_NAME' TEXT," + // 2: ItemName
                "'MIN_VALUE' INTEGER," + // 3: MinValue
                "'MAX_VALUE' INTEGER," + // 4: MaxValue
                "'UNIT' TEXT," + // 5: Unit
                "'DATA_LEN' INTEGER," + // 6: DataLen
                "'CARRY_MODE' INTEGER," + // 7: CarryMode
                "'ITEM_TYPE' INTEGER," + // 8: ItemType
                "'MACHINE_CODE' TEXT," + // 9: MachineCode
                "'IS_ENABLE' INTEGER," + // 10: IsEnable
                "'REMARK1' TEXT);"); // 11: Remark1
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'ITEM'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Item entity) {
        stmt.clearBindings();
 
        Long ItemID = entity.getItemID();
        if (ItemID != null) {
            stmt.bindLong(1, ItemID);
        }
 
        String ItemCode = entity.getItemCode();
        if (ItemCode != null) {
            stmt.bindString(2, ItemCode);
        }
 
        String ItemName = entity.getItemName();
        if (ItemName != null) {
            stmt.bindString(3, ItemName);
        }
 
        Integer MinValue = entity.getMinValue();
        if (MinValue != null) {
            stmt.bindLong(4, MinValue);
        }
 
        Integer MaxValue = entity.getMaxValue();
        if (MaxValue != null) {
            stmt.bindLong(5, MaxValue);
        }
 
        String Unit = entity.getUnit();
        if (Unit != null) {
            stmt.bindString(6, Unit);
        }
 
        Integer DataLen = entity.getDataLen();
        if (DataLen != null) {
            stmt.bindLong(7, DataLen);
        }
 
        Integer CarryMode = entity.getCarryMode();
        if (CarryMode != null) {
            stmt.bindLong(8, CarryMode);
        }
 
        Integer ItemType = entity.getItemType();
        if (ItemType != null) {
            stmt.bindLong(9, ItemType);
        }
 
        String MachineCode = entity.getMachineCode();
        if (MachineCode != null) {
            stmt.bindString(10, MachineCode);
        }
 
        Integer IsEnable = entity.getIsEnable();
        if (IsEnable != null) {
            stmt.bindLong(11, IsEnable);
        }
 
        String Remark1 = entity.getRemark1();
        if (Remark1 != null) {
            stmt.bindString(12, Remark1);
        }
    }

    @Override
    protected void attachEntity(Item entity) {
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
    public Item readEntity(Cursor cursor, int offset) {
        Item entity = new Item( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // ItemID
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // ItemCode
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // ItemName
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // MinValue
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // MaxValue
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // Unit
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // DataLen
            cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // CarryMode
            cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8), // ItemType
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // MachineCode
            cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10), // IsEnable
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11) // Remark1
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Item entity, int offset) {
        entity.setItemID(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setItemCode(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setItemName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMinValue(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setMaxValue(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setUnit(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDataLen(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setCarryMode(cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7));
        entity.setItemType(cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8));
        entity.setMachineCode(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setIsEnable(cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10));
        entity.setRemark1(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Item entity, long rowId) {
        entity.setItemID(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Item entity) {
        if(entity != null) {
            return entity.getItemID();
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
            builder.append(" FROM ITEM T");
            builder.append(" LEFT JOIN STUDENT_ITEM T0 ON T.'ITEM_ID'=T0.'STUDENT_ITEM_ID'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Item loadCurrentDeep(Cursor cursor, boolean lock) {
        Item entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        StudentItem studentItem = loadCurrentOther(daoSession.getStudentItemDao(), cursor, offset);
        entity.setStudentItem(studentItem);

        return entity;    
    }

    public Item loadDeep(Long key) {
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
    public List<Item> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Item> list = new ArrayList<Item>(count);
        
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
    
    protected List<Item> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Item> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}