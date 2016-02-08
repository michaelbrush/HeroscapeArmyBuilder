package DatabaseManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Development on 2/7/2016.
 */
public class HeroscapeDeck {

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INT";
    private static final String COMMA_SEP = ",";

    //region ArmyCards
    private static final String SQL_CREATE_ARMY_CARDS_ENTRIES =
            "CREATE TABLE " + ArmyCardsContract.ArmyCardsEntry.TABLE_NAME + " (" +
                    ArmyCardsContract.ArmyCardsEntry.COLUMN_NAME_USER_ID + INT_TYPE + COMMA_SEP +
                    ArmyCardsContract.ArmyCardsEntry.COLUMN_NAME_USER_ID +
                    " )";

    private static final String SQL_DELETE_ARMY_CARDS_ENTRIES =
            "DROP TABLE IF EXISTS " + ArmyCardsContract.ArmyCardsEntry.TABLE_NAME;
    //endregion

    //region Army
    private static final String SQL_CREATE_ARMY_ENTRIES =
            "CREATE TABLE " + ArmyContract.ArmyEntry.TABLE_NAME + " (" +
                    ArmyContract.ArmyEntry._ID + " INTEGER PRIMARY KEY, " +
                    ArmyContract.ArmyEntry.COLUMN_NAME_USER_ID + TEXT_TYPE +
                    " )";

    private static final String SQL_DELETE_ARMY_ENTRIES =
            "DROP TABLE IF EXISTS " + ArmyContract.ArmyEntry.TABLE_NAME;
    //endregion

    //region Card
    private static final String SQL_CREATE_CARD_ENTRIES =
            "CREATE TABLE " + CardContract.CardEntry.TABLE_NAME + " (" +
                    CardContract.CardEntry._ID + " INTEGER PRIMARY KEY, " +
                    CardContract.CardEntry.COLUMN_NAME_ATTACK + INT_TYPE + COMMA_SEP +
                    CardContract.CardEntry.COLUMN_NAME_COST + INT_TYPE + COMMA_SEP +
                    CardContract.CardEntry.COLUMN_NAME_DEFENSE + INT_TYPE + COMMA_SEP +
                    CardContract.CardEntry.COLUMN_NAME_IS_CUSTOM +
                    CardContract.CardEntry.COLUMN_NAME_LIFE + INT_TYPE + COMMA_SEP +
                    CardContract.CardEntry.COLUMN_NAME_MOVE + INT_TYPE + COMMA_SEP +
                    CardContract.CardEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    CardContract.CardEntry.COLUMN_NAME_RACE + TEXT_TYPE + COMMA_SEP +
                    CardContract.CardEntry.COLUMN_NAME_RANGE + INT_TYPE + COMMA_SEP +
                    CardContract.CardEntry.COLUMN_NAME_SET_RELATIONSHIP + TEXT_TYPE + COMMA_SEP +
                    CardContract.CardEntry.COLUMN_NAME_SPECIAL_ABILITIES + TEXT_TYPE + COMMA_SEP +
                    CardContract.CardEntry.COLUMN_NAME_SIZE_CLASS + TEXT_TYPE + COMMA_SEP +
                    CardContract.CardEntry.COLUMN_NAME_SIZE_DESIGNATION + INT_TYPE + COMMA_SEP +
                    CardContract.CardEntry.COLUMN_NAME_SYNERGY + TEXT_TYPE + COMMA_SEP +
                    CardContract.CardEntry.COLUMN_NAME_TRAIT + TEXT_TYPE + COMMA_SEP +
                    CardContract.CardEntry.COLUMN_NAME_TYPE + TEXT_TYPE + COMMA_SEP +
                    " )";

    private static final String SQL_DELETE_CARD_ENTRIES =
            "DROP TABLE IF EXISTS " + CardContract.CardEntry.TABLE_NAME;
    //endregion

    //region MasterSet
    private static final String SQL_CREATE_MASTER_SET_ENTRIES =
            "CREATE TABLE " + MasterSetContract.MasterSetEntry.TABLE_NAME + " (" +
                    MasterSetContract.MasterSetEntry._ID + " INTEGER PRIMARY KEY, " +
                    MasterSetContract.MasterSetEntry.COLUMN_NAME_SET_NAME +
                    " )";

    private static final String SQL_DELETE_MASTER_SET_ENTRIES =
            "DROP TABLE IF EXISTS " + MasterSetContract.MasterSetEntry.TABLE_NAME;
    //endregion

    //region User
    private static final String SQL_CREATE_USER_ENTRIES =
            "CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " (" +
                    UserContract.UserEntry._ID + " INTEGER PRIMARY KEY, " +
                    UserContract.UserEntry.COLUMN_NAME_USER_NAME + TEXT_TYPE +
                    " )";

    private static final String SQL_DELETE_USER_ENTRIES =
            "DROP TABLE IF EXISTS " + UserContract.UserEntry.TABLE_NAME;
    //endregion



public class HeroscapeDeckDbHelper extends SQLiteOpenHelper {

    //Database version to be incremented on schema change
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "HeroscapeDeck.db";

    public HeroscapeDeckDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_ARMY_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //We are in development currently, so if the database schema changes
        //discard existing data and start fresh from the new schema.
        db.execSQL(SQL_DELETE_ARMY_ENTRIES);
        onCreate(db);
    }
}



}
