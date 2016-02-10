package info.michaelbrush.development.heroscapearmybuilder.DatabaseManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Michael Brush on 2/7/2016.
 */
public class CardDatabaseHelper extends DatabaseHelper {

    public static abstract class CardEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "Cards";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_RACE = "race";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_SYNERGY = "synergy";
        public static final String COLUMN_NAME_TRAIT = "trait";
        public static final String COLUMN_NAME_SIZE_CLASS = "sizeClass";
        public static final String COLUMN_NAME_SIZE_DESIGNATION = "sizeDesignation";
        public static final String COLUMN_NAME_LIFE = "life";
        public static final String COLUMN_NAME_MOVE = "move";
        public static final String COLUMN_NAME_RANGE = "range";
        public static final String COLUMN_NAME_ATTACK = "attack";
        public static final String COLUMN_NAME_DEFENSE = "defense";
        public static final String COLUMN_NAME_COST = "cost";
        public static final String COLUMN_NAME_SPECIAL_ABILITIES = "specialAbilities";
        public static final String COLUMN_NAME_SET_RELATIONSHIP = "setRelationship";
        public static final String COLUMN_NAME_IS_CUSTOM = "isCustom";
    }

    //region Card Queries
    private static final String SQL_CREATE_CARD_TABLE =
            "CREATE TABLE " + CardEntry.TABLE_NAME + " (" +
                    CardEntry._ID + " INTEGER PRIMARY KEY, " +
                    CardEntry.COLUMN_NAME_ATTACK + INT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_COST + INT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_DEFENSE + INT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_IS_CUSTOM +
                    CardEntry.COLUMN_NAME_LIFE + INT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_MOVE + INT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_RACE + TEXT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_RANGE + INT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_SET_RELATIONSHIP + TEXT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_SPECIAL_ABILITIES + TEXT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_SIZE_CLASS + TEXT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_SIZE_DESIGNATION + INT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_SYNERGY + TEXT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_TRAIT + TEXT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_TYPE + TEXT_TYPE + COMMA_SEP +
                    " )";

    private static final String SQL_DELETE_CARD_TABLE =
            "DROP TABLE IF EXISTS " + CardEntry.TABLE_NAME;
    //endregion

    public CardDatabaseHelper(Context context)
    {
        super(context);
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_CARD_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(SQL_DELETE_CARD_TABLE);
        onCreate(db);
    }

    public void onDelete(SQLiteDatabase db)
    {
        db.execSQL(SQL_DELETE_CARD_TABLE);
    }
}
