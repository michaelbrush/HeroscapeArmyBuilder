package info.michaelbrush.development.heroscapearmybuilder.DatabaseManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Michael Brush on 2/7/2016.
 */
public class MasterSetDatabaseHelper extends DatabaseHelper
{

    public MasterSetDatabaseHelper(Context context)
    {
        super(context);
    }

    //region MasterSet
    private static final String SQL_CREATE_MASTER_SET_TABLE =
            "CREATE TABLE " + MasterSetEntry.TABLE_NAME + " (" +
                    MasterSetEntry._ID + " INTEGER PRIMARY KEY, " +
                    MasterSetEntry.COLUMN_NAME_SET_NAME +
                    " )";

    private static final String SQL_DELETE_MASTER_SET_TABLE =
            "DROP TABLE IF EXISTS " + MasterSetEntry.TABLE_NAME;
    //endregion

    public static abstract class MasterSetEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "MasterSetEntry";
        public static final String COLUMN_NAME_SET_NAME = "setName";
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_MASTER_SET_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(SQL_DELETE_MASTER_SET_TABLE);
        onCreate(db);
    }

    public void onDelete(SQLiteDatabase db)
    {
        db.execSQL(SQL_DELETE_MASTER_SET_TABLE);
    }
}
