package info.michaelbrush.development.heroscapearmybuilder.DatabaseManager;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Michael Brush on 2/10/2016.
 */
public abstract class DatabaseHelper extends SQLiteOpenHelper {

    //helper constants for defining sql statements
    protected static final String TEXT_TYPE = " TEXT";
    protected static final String INT_TYPE = " INT";
    protected static final String REAL_TYPE = " REAL";
    protected static final String COMMA_SEP = ",";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "HeroscapeDeck.db";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
