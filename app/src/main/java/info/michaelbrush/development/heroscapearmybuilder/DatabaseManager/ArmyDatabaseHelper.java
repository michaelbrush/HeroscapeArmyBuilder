package info.michaelbrush.development.heroscapearmybuilder.DatabaseManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Michael Brush on 2/7/2016.
 */
public final class ArmyDatabaseHelper extends DatabaseHelper
{

    public ArmyDatabaseHelper(Context context)
    {
        super(context);
    }

    //region Army
    private static final String SQL_CREATE_ARMY_TABLE =
            "CREATE TABLE " + ArmyEntry.TABLE_NAME + " (" +
                    ArmyEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    ArmyEntry.COLUMN_NAME_USER_ID + TEXT_TYPE +
                    " )";

    private static final String SQL_DELETE_ARMY_TABLE =
            "DROP TABLE IF EXISTS " + ArmyEntry.TABLE_NAME;
    //endregion

    public static abstract class ArmyEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "Armies";
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

        data.put(ArmyEntry.COLUMN_NAME_POINT_TOTAL, 200);
        data.put(ArmyEntry.COLUMN_NAME_USER_ID, 1);

        db.insert(ArmyEntry.TABLE_NAME, null, data);
    }
}
