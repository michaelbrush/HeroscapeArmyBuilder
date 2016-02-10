package info.michaelbrush.development.heroscapearmybuilder.DatabaseManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Michael Brush on 2/7/2016.
 */
public final class UserDatabaseHelper extends DatabaseHelper {

    public UserDatabaseHelper(Context context)
    {
        super(context);
    }

    //region User
    private static final String SQL_CREATE_USER_TABLE =
            "CREATE TABLE " + UserEntry.TABLE_NAME + " (" +
                    UserEntry._ID + " INTEGER PRIMARY KEY, " +
                    UserEntry.COLUMN_NAME_USER_NAME + TEXT_TYPE +
                    " )";

    private static final String SQL_DELETE_USER_TABLE =
            "DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME;
    //endregion

    public  static abstract class UserEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "Users";
        public static final String COLUMN_NAME_USER_NAME = "username";
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_USER_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(SQL_DELETE_USER_TABLE);
        onCreate(db);
    }

    public void onDelete(SQLiteDatabase db)
    {
        db.execSQL(SQL_DELETE_USER_TABLE);
    }
}