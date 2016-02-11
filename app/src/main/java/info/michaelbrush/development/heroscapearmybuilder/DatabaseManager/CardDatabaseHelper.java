package info.michaelbrush.development.heroscapearmybuilder.DatabaseManager;

import android.content.ContentValues;
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
        public static final String COLUMN_NAME_CLASS = "class";
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
                    CardEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    CardEntry.COLUMN_NAME_ATTACK + INT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_COST + INT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_DEFENSE + INT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_IS_CUSTOM + INT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_LIFE + INT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_MOVE + INT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_RACE + TEXT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_RANGE + INT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_SET_RELATIONSHIP + INT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_SPECIAL_ABILITIES + TEXT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_SIZE_CLASS + TEXT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_SIZE_DESIGNATION + INT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_CLASS + TEXT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_TRAIT + TEXT_TYPE + COMMA_SEP +
                    CardEntry.COLUMN_NAME_TYPE + TEXT_TYPE  +
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
        initData(db);
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

    public void initData(SQLiteDatabase db)
    {
        ContentValues data = new ContentValues();

        data.put(CardEntry.COLUMN_NAME_NAME, "Fin the Viking Champion");
        data.put(CardEntry.COLUMN_NAME_RACE, "Human");
        data.put(CardEntry.COLUMN_NAME_TYPE, "Unique Hero");
        data.put(CardEntry.COLUMN_NAME_CLASS, "Champion");
        data.put(CardEntry.COLUMN_NAME_TRAIT, "Valiant");
        data.put(CardEntry.COLUMN_NAME_SIZE_CLASS, "Medium");
        data.put(CardEntry.COLUMN_NAME_SIZE_DESIGNATION, 5);
        data.put(CardEntry.COLUMN_NAME_LIFE, 4);
        data.put(CardEntry.COLUMN_NAME_MOVE, 5);
        data.put(CardEntry.COLUMN_NAME_RANGE, 1);
        data.put(CardEntry.COLUMN_NAME_ATTACK, 3);
        data.put(CardEntry.COLUMN_NAME_DEFENSE, 4);
        data.put(CardEntry.COLUMN_NAME_COST, 80);
        data.put(CardEntry.COLUMN_NAME_SPECIAL_ABILITIES, "ATTACK AURA 1: All friendly figures " +
                "adjacent to Finn with a range of 1 add 1 die to their normal attack, WARRIOR'S " +
                "ATTACK SPIRIT 1: Whn Finn is destroyed, place this figure on any unique Army "
                + "Card. Finn's Spirit adds 1 to the normal attack number on that card.");
        data.put(CardEntry.COLUMN_NAME_SET_RELATIONSHIP, 1);
        data.put(CardEntry.COLUMN_NAME_IS_CUSTOM, 0);

        db.insert(CardEntry.TABLE_NAME, null, data);
    }
}
