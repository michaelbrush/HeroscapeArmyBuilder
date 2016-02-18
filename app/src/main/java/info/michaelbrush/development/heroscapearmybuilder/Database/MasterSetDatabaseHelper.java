package info.michaelbrush.development.heroscapearmybuilder.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Michael Brush on 2/7/2016.
 */
public class MasterSetDatabaseHelper extends SQLiteOpenHelper
{

    //helper constants for defining sql statements
    protected static final String TEXT_TYPE = " TEXT";
    protected static final String INT_TYPE = " INT";
    protected static final String REAL_TYPE = " REAL";
    protected static final String COMMA_SEP = ", ";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MasterSet.db";

    public MasterSetDatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //region MasterSet
    private static final String SQL_CREATE_MASTER_SET_TABLE =
            "CREATE TABLE " + MasterSetEntry.TABLE_NAME + " (" +
                    MasterSetEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    MasterSetEntry.COLUMN_NAME_SET_NAME + TEXT_TYPE +
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

    public void initData(SQLiteDatabase db)
    {
        ContentValues data = new ContentValues();

        data.put(MasterSetEntry.COLUMN_NAME_SET_NAME, "Rise of the Valkyrie - Master Set");

        db.insert(MasterSetEntry.TABLE_NAME, null, data);
    }
}
