package info.michaelbrush.development.heroscapearmybuilder.DatabaseManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Michael Brush on 2/7/2016.
 */
public class ArmyCardsDatabaseHelper extends DatabaseHelper {

    public ArmyCardsDatabaseHelper(Context context)
    {
        super(context);
    }

    //region ArmyCards
    private static final String SQL_CREATE_ARMY_CARDS_TABLE =
            "CREATE TABLE " + ArmyCardsEntry.TABLE_NAME + " (" +
                    ArmyCardsEntry.COLUMN_NAME_USER_ID + INT_TYPE + COMMA_SEP +
                    ArmyCardsEntry.COLUMN_NAME_USER_ID + INT_TYPE +
                    " )";

    private static final String SQL_DELETE_ARMY_CARDS_TABLE =
            "DROP TABLE IF EXISTS " + ArmyCardsEntry.TABLE_NAME;
    //endregion

    public static abstract class ArmyCardsEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "ArmyCards";
        public static final String COLUMN_NAME_ARMY_ID = "armyId";
        public static final String COLUMN_NAME_USER_ID = "CardId";
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_ARMY_CARDS_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(SQL_DELETE_ARMY_CARDS_TABLE);
        onCreate(db);
    }

    public void onDelete(SQLiteDatabase db)
    {
        db.execSQL(SQL_DELETE_ARMY_CARDS_TABLE);
    }

    public void initData(SQLiteDatabase db)
    {
        ContentValues data = new ContentValues();

        data.put(ArmyCardsEntry.COLUMN_NAME_ARMY_ID, 1);
        data.put(ArmyCardsEntry.COLUMN_NAME_USER_ID, 1);

        db.insert(ArmyCardsEntry.TABLE_NAME, null, data);
    }
}
