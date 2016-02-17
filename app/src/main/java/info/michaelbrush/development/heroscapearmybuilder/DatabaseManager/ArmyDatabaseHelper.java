package info.michaelbrush.development.heroscapearmybuilder.DatabaseManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Michael Brush on 2/7/2016.
 */
public final class ArmyDatabaseHelper extends SQLiteOpenHelper
{

    //helper constants for defining sql statements
    protected static final String TEXT_TYPE = " TEXT";
    protected static final String INT_TYPE = " INT";
    protected static final String REAL_TYPE = " REAL";
    protected static final String COMMA_SEP = ", ";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Army.db";

    public ArmyDatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //region Army
    private static final String SQL_CREATE_ARMY_TABLE =
            "CREATE TABLE " + ArmyEntry.TABLE_NAME + " (" +
                    ArmyEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    ArmyEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    ArmyEntry.COLUMN_NAME_POINT_TOTAL + INT_TYPE + COMMA_SEP +
                    ArmyEntry.COLUMN_NAME_USER_ID + INT_TYPE +
                    " )";

    private static final String SQL_DELETE_ARMY_TABLE =
            "DROP TABLE IF EXISTS " + ArmyEntry.TABLE_NAME;
    //endregion

    public static abstract class ArmyEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "Armies";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_USER_ID = "userId";
        public static final String COLUMN_NAME_POINT_TOTAL = "pointTotal";
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_ARMY_TABLE);
        initData(db);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(SQL_DELETE_ARMY_TABLE);
        onCreate(db);
    }

    public void onDelete(SQLiteDatabase db)
    {
        db.execSQL(SQL_DELETE_ARMY_TABLE);
    }

    public void initData(SQLiteDatabase db)
    {
        ContentValues data = new ContentValues();

        data.put(ArmyEntry.COLUMN_NAME_NAME, "Test Army 1");
        data.put(ArmyEntry.COLUMN_NAME_POINT_TOTAL, 200);
        data.put(ArmyEntry.COLUMN_NAME_USER_ID, 1);
        db.insert(ArmyEntry.TABLE_NAME, null, data);

        data.clear();
        data.put(ArmyEntry.COLUMN_NAME_NAME, "Test Army 2");
        data.put(ArmyEntry.COLUMN_NAME_POINT_TOTAL, 50);
        data.put(ArmyEntry.COLUMN_NAME_USER_ID, 1);
        db.insert(ArmyEntry.TABLE_NAME, null, data);

        data.clear();
        data.put(ArmyEntry.COLUMN_NAME_NAME, "Test Army 3");
        data.put(ArmyEntry.COLUMN_NAME_POINT_TOTAL, 400);
        data.put(ArmyEntry.COLUMN_NAME_USER_ID, 2);
        db.insert(ArmyEntry.TABLE_NAME, null, data);
    }
}
