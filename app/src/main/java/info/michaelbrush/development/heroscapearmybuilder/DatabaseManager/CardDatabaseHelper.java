package info.michaelbrush.development.heroscapearmybuilder.DatabaseManager;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Michael Brush on 2/7/2016.
 */
public class CardDatabaseHelper extends SQLiteOpenHelper {

    //helper constants for defining sql statements
    protected static final String TEXT_TYPE = " TEXT";
    protected static final String INT_TYPE = " INT";
    protected static final String REAL_TYPE = " REAL";
    protected static final String COMMA_SEP = ", ";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Card.db";

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
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
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

        //region Cards
        data.put(CardEntry.COLUMN_NAME_NAME, "Finn the Viking Champion");
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

        data.clear();
        data.put(CardEntry.COLUMN_NAME_NAME, "Airborne Elite");
        data.put(CardEntry.COLUMN_NAME_RACE, "Human");
        data.put(CardEntry.COLUMN_NAME_TYPE, "Unique Squad");
        data.put(CardEntry.COLUMN_NAME_CLASS, "Soldiers");
        data.put(CardEntry.COLUMN_NAME_TRAIT, "Disciplined");
        data.put(CardEntry.COLUMN_NAME_SIZE_CLASS, "Medium");
        data.put(CardEntry.COLUMN_NAME_SIZE_DESIGNATION, 5);
        data.put(CardEntry.COLUMN_NAME_LIFE, 1);
        data.put(CardEntry.COLUMN_NAME_MOVE, 4);
        data.put(CardEntry.COLUMN_NAME_RANGE, 8);
        data.put(CardEntry.COLUMN_NAME_ATTACK, 3);
        data.put(CardEntry.COLUMN_NAME_DEFENSE, 1);
        data.put(CardEntry.COLUMN_NAME_COST, 110);
        data.put(CardEntry.COLUMN_NAME_SPECIAL_ABILITIES, "GRENADE SPECIAL ATTACK|THE DROP");
        data.put(CardEntry.COLUMN_NAME_SET_RELATIONSHIP, 1);
        data.put(CardEntry.COLUMN_NAME_IS_CUSTOM, 0);
        db.insert(CardEntry.TABLE_NAME, null, data);

        data.clear();
        data.put(CardEntry.COLUMN_NAME_NAME, "Deathwalker 9000");
        data.put(CardEntry.COLUMN_NAME_RACE, "Soulborg");
        data.put(CardEntry.COLUMN_NAME_TYPE, "Unique Hero");
        data.put(CardEntry.COLUMN_NAME_CLASS, "Deathwalker");
        data.put(CardEntry.COLUMN_NAME_TRAIT, "Precise");
        data.put(CardEntry.COLUMN_NAME_SIZE_CLASS, "Large");
        data.put(CardEntry.COLUMN_NAME_SIZE_DESIGNATION, 7);
        data.put(CardEntry.COLUMN_NAME_LIFE, 1);
        data.put(CardEntry.COLUMN_NAME_MOVE, 5);
        data.put(CardEntry.COLUMN_NAME_RANGE, 7);
        data.put(CardEntry.COLUMN_NAME_ATTACK, 4);
        data.put(CardEntry.COLUMN_NAME_DEFENSE, 9);
        data.put(CardEntry.COLUMN_NAME_COST, 140);
        data.put(CardEntry.COLUMN_NAME_SPECIAL_ABILITIES, "EXPLOSION SPECIAL ATTACK|RANGE ENHANCEMENT");
        data.put(CardEntry.COLUMN_NAME_SET_RELATIONSHIP, 1);
        data.put(CardEntry.COLUMN_NAME_IS_CUSTOM, 0);
        db.insert(CardEntry.TABLE_NAME, null, data);

        data.clear();
        data.put(CardEntry.COLUMN_NAME_NAME, "Grimnak");
        data.put(CardEntry.COLUMN_NAME_RACE, "Orc");
        data.put(CardEntry.COLUMN_NAME_TYPE, "Unique Hero");
        data.put(CardEntry.COLUMN_NAME_CLASS, "Champion");
        data.put(CardEntry.COLUMN_NAME_TRAIT, "Ferocious");
        data.put(CardEntry.COLUMN_NAME_SIZE_CLASS, "Huge");
        data.put(CardEntry.COLUMN_NAME_SIZE_DESIGNATION, 11);
        data.put(CardEntry.COLUMN_NAME_LIFE, 5);
        data.put(CardEntry.COLUMN_NAME_MOVE, 5);
        data.put(CardEntry.COLUMN_NAME_RANGE, 1);
        data.put(CardEntry.COLUMN_NAME_ATTACK, 2);
        data.put(CardEntry.COLUMN_NAME_DEFENSE, 4);
        data.put(CardEntry.COLUMN_NAME_COST, 120);
        data.put(CardEntry.COLUMN_NAME_SPECIAL_ABILITIES, "CHOMP|ORC WARRIOR ENHANCEMENT");
        data.put(CardEntry.COLUMN_NAME_SET_RELATIONSHIP, 1);
        data.put(CardEntry.COLUMN_NAME_IS_CUSTOM, 0);
        db.insert(CardEntry.TABLE_NAME, null, data);
        //endregion


    }

//    public void initFromFile(SQLiteDatabase db, Context context)
//    {
//        AssetManager manager = context.getAssets();
//        InputStream open = null;
//        try
//        {
//            open = manager.open("cards.tsv");
//            InputStreamReader streamReader = new InputStreamReader(open);
//            CSVReader csvReader = new CSVReader(streamReader);
//            String[] line;
//
//            csvReader.readNext();
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//
//    }
}
