package info.michaelbrush.development.heroscapearmybuilder.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Michael Brush on 2/10/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    //helper constants for defining sql statements
    protected static final String TEXT_TYPE = " TEXT";
    protected static final String INT_TYPE = " INT";
    protected static final String REAL_TYPE = " REAL";
    protected static final String COMMA_SEP = ", ";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "HeroscapeArmyBuilder.db";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_CARD_TABLE);
        db.execSQL(SQL_CREATE_ARMY_TABLE);
        db.execSQL(SQL_CREATE_MASTER_SET_TABLE);
        db.execSQL(SQL_CREATE_ARMY_CARDS_TABLE);
        db.execSQL(SQL_CREATE_USER_TABLE);
        initCardData(db);
        initArmyData(db);
        initMasterSetData(db);
        initArmyCardsData(db);
        initUserData(db);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(SQL_DELETE_CARD_TABLE);
        db.execSQL(SQL_DELETE_ARMY_TABLE);
        db.execSQL(SQL_DELETE_MASTER_SET_TABLE);
        db.execSQL(SQL_DELETE_ARMY_CARDS_TABLE);
        db.execSQL(SQL_DELETE_USER_TABLE);
        onCreate(db);
    }

    public void onDelete(SQLiteDatabase db)
    {
        db.execSQL(SQL_DELETE_ARMY_TABLE);
        db.execSQL(SQL_DELETE_CARD_TABLE);
        db.execSQL(SQL_DELETE_MASTER_SET_TABLE);
        db.execSQL(SQL_DELETE_ARMY_CARDS_TABLE);
        db.execSQL(SQL_DELETE_USER_TABLE);
    }

    //region CardTable
    public static abstract class CardColumns implements BaseColumns
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
            "CREATE TABLE " + CardColumns.TABLE_NAME + " (" +
                    CardColumns._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    CardColumns.COLUMN_NAME_ATTACK + INT_TYPE + COMMA_SEP +
                    CardColumns.COLUMN_NAME_COST + INT_TYPE + COMMA_SEP +
                    CardColumns.COLUMN_NAME_DEFENSE + INT_TYPE + COMMA_SEP +
                    CardColumns.COLUMN_NAME_IS_CUSTOM + INT_TYPE + COMMA_SEP +
                    CardColumns.COLUMN_NAME_LIFE + INT_TYPE + COMMA_SEP +
                    CardColumns.COLUMN_NAME_MOVE + INT_TYPE + COMMA_SEP +
                    CardColumns.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    CardColumns.COLUMN_NAME_RACE + TEXT_TYPE + COMMA_SEP +
                    CardColumns.COLUMN_NAME_RANGE + INT_TYPE + COMMA_SEP +
                    CardColumns.COLUMN_NAME_SET_RELATIONSHIP + INT_TYPE + COMMA_SEP +
                    CardColumns.COLUMN_NAME_SPECIAL_ABILITIES + TEXT_TYPE + COMMA_SEP +
                    CardColumns.COLUMN_NAME_SIZE_CLASS + TEXT_TYPE + COMMA_SEP +
                    CardColumns.COLUMN_NAME_SIZE_DESIGNATION + INT_TYPE + COMMA_SEP +
                    CardColumns.COLUMN_NAME_CLASS + TEXT_TYPE + COMMA_SEP +
                    CardColumns.COLUMN_NAME_TRAIT + TEXT_TYPE + COMMA_SEP +
                    CardColumns.COLUMN_NAME_TYPE + TEXT_TYPE  +
                    " )";

    private static final String SQL_DELETE_CARD_TABLE =
            "DROP TABLE IF EXISTS " + CardColumns.TABLE_NAME;
    //endregion

    public void initCardData(SQLiteDatabase db)
    {
        ContentValues data = new ContentValues();

        //region Cards
        data.put(CardColumns.COLUMN_NAME_NAME, "Finn the Viking Champion");
        data.put(CardColumns.COLUMN_NAME_RACE, "Human");
        data.put(CardColumns.COLUMN_NAME_TYPE, "Unique Hero");
        data.put(CardColumns.COLUMN_NAME_CLASS, "Champion");
        data.put(CardColumns.COLUMN_NAME_TRAIT, "Valiant");
        data.put(CardColumns.COLUMN_NAME_SIZE_CLASS, "Medium");
        data.put(CardColumns.COLUMN_NAME_SIZE_DESIGNATION, 5);
        data.put(CardColumns.COLUMN_NAME_LIFE, 4);
        data.put(CardColumns.COLUMN_NAME_MOVE, 5);
        data.put(CardColumns.COLUMN_NAME_RANGE, 1);
        data.put(CardColumns.COLUMN_NAME_ATTACK, 3);
        data.put(CardColumns.COLUMN_NAME_DEFENSE, 4);
        data.put(CardColumns.COLUMN_NAME_COST, 80);
        data.put(CardColumns.COLUMN_NAME_SPECIAL_ABILITIES, "ATTACK AURA 1: All friendly figures " +
                "adjacent to Finn with a range of 1 add 1 die to their normal attack, WARRIOR'S " +
                "ATTACK SPIRIT 1: Whn Finn is destroyed, place this figure on any unique Army "
                + "Card. Finn's Spirit adds 1 to the normal attack number on that card.");
        data.put(CardColumns.COLUMN_NAME_SET_RELATIONSHIP, 1);
        data.put(CardColumns.COLUMN_NAME_IS_CUSTOM, 0);
        db.insert(CardColumns.TABLE_NAME, null, data);

        data.clear();
        data.put(CardColumns.COLUMN_NAME_NAME, "Airborne Elite");
        data.put(CardColumns.COLUMN_NAME_RACE, "Human");
        data.put(CardColumns.COLUMN_NAME_TYPE, "Unique Squad");
        data.put(CardColumns.COLUMN_NAME_CLASS, "Soldiers");
        data.put(CardColumns.COLUMN_NAME_TRAIT, "Disciplined");
        data.put(CardColumns.COLUMN_NAME_SIZE_CLASS, "Medium");
        data.put(CardColumns.COLUMN_NAME_SIZE_DESIGNATION, 5);
        data.put(CardColumns.COLUMN_NAME_LIFE, 1);
        data.put(CardColumns.COLUMN_NAME_MOVE, 4);
        data.put(CardColumns.COLUMN_NAME_RANGE, 8);
        data.put(CardColumns.COLUMN_NAME_ATTACK, 3);
        data.put(CardColumns.COLUMN_NAME_DEFENSE, 1);
        data.put(CardColumns.COLUMN_NAME_COST, 110);
        data.put(CardColumns.COLUMN_NAME_SPECIAL_ABILITIES, "GRENADE SPECIAL ATTACK|THE DROP");
        data.put(CardColumns.COLUMN_NAME_SET_RELATIONSHIP, 1);
        data.put(CardColumns.COLUMN_NAME_IS_CUSTOM, 0);
        db.insert(CardColumns.TABLE_NAME, null, data);

        data.clear();
        data.put(CardColumns.COLUMN_NAME_NAME, "Deathwalker 9000");
        data.put(CardColumns.COLUMN_NAME_RACE, "Soulborg");
        data.put(CardColumns.COLUMN_NAME_TYPE, "Unique Hero");
        data.put(CardColumns.COLUMN_NAME_CLASS, "Deathwalker");
        data.put(CardColumns.COLUMN_NAME_TRAIT, "Precise");
        data.put(CardColumns.COLUMN_NAME_SIZE_CLASS, "Large");
        data.put(CardColumns.COLUMN_NAME_SIZE_DESIGNATION, 7);
        data.put(CardColumns.COLUMN_NAME_LIFE, 1);
        data.put(CardColumns.COLUMN_NAME_MOVE, 5);
        data.put(CardColumns.COLUMN_NAME_RANGE, 7);
        data.put(CardColumns.COLUMN_NAME_ATTACK, 4);
        data.put(CardColumns.COLUMN_NAME_DEFENSE, 9);
        data.put(CardColumns.COLUMN_NAME_COST, 140);
        data.put(CardColumns.COLUMN_NAME_SPECIAL_ABILITIES, "EXPLOSION SPECIAL ATTACK|RANGE ENHANCEMENT");
        data.put(CardColumns.COLUMN_NAME_SET_RELATIONSHIP, 1);
        data.put(CardColumns.COLUMN_NAME_IS_CUSTOM, 0);
        db.insert(CardColumns.TABLE_NAME, null, data);

        data.clear();
        data.put(CardColumns.COLUMN_NAME_NAME, "Grimnak");
        data.put(CardColumns.COLUMN_NAME_RACE, "Orc");
        data.put(CardColumns.COLUMN_NAME_TYPE, "Unique Hero");
        data.put(CardColumns.COLUMN_NAME_CLASS, "Champion");
        data.put(CardColumns.COLUMN_NAME_TRAIT, "Ferocious");
        data.put(CardColumns.COLUMN_NAME_SIZE_CLASS, "Huge");
        data.put(CardColumns.COLUMN_NAME_SIZE_DESIGNATION, 11);
        data.put(CardColumns.COLUMN_NAME_LIFE, 5);
        data.put(CardColumns.COLUMN_NAME_MOVE, 5);
        data.put(CardColumns.COLUMN_NAME_RANGE, 1);
        data.put(CardColumns.COLUMN_NAME_ATTACK, 2);
        data.put(CardColumns.COLUMN_NAME_DEFENSE, 4);
        data.put(CardColumns.COLUMN_NAME_COST, 120);
        data.put(CardColumns.COLUMN_NAME_SPECIAL_ABILITIES, "CHOMP|ORC WARRIOR ENHANCEMENT");
        data.put(CardColumns.COLUMN_NAME_SET_RELATIONSHIP, 1);
        data.put(CardColumns.COLUMN_NAME_IS_CUSTOM, 0);
        db.insert(CardColumns.TABLE_NAME, null, data);
        //endregion


    }

    //endregion

    //region Army

    public static abstract class ArmyColumns implements BaseColumns
    {
        public static final String TABLE_NAME = "Armies";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_USER_ID = "userId";
        public static final String COLUMN_NAME_POINT_TOTAL = "pointTotal";
    }

    //region Army SQL
    private static final String SQL_CREATE_ARMY_TABLE =
            "CREATE TABLE " + ArmyColumns.TABLE_NAME + " (" +
                    ArmyColumns._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    ArmyColumns.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    ArmyColumns.COLUMN_NAME_POINT_TOTAL + INT_TYPE + COMMA_SEP +
                    ArmyColumns.COLUMN_NAME_USER_ID + INT_TYPE +
                    " )";

    private static final String SQL_DELETE_ARMY_TABLE =
            "DROP TABLE IF EXISTS " + ArmyColumns.TABLE_NAME;
    //endregion

    public void initArmyData(SQLiteDatabase db)
    {
        ContentValues data = new ContentValues();

        data.put(ArmyColumns.COLUMN_NAME_NAME, "Test Army 1");
        data.put(ArmyColumns.COLUMN_NAME_POINT_TOTAL, 200);
        data.put(ArmyColumns.COLUMN_NAME_USER_ID, 1);
        db.insert(ArmyColumns.TABLE_NAME, null, data);

        data.clear();
        data.put(ArmyColumns.COLUMN_NAME_NAME, "Test Army 2");
        data.put(ArmyColumns.COLUMN_NAME_POINT_TOTAL, 50);
        data.put(ArmyColumns.COLUMN_NAME_USER_ID, 1);
        db.insert(ArmyColumns.TABLE_NAME, null, data);

        data.clear();
        data.put(ArmyColumns.COLUMN_NAME_NAME, "Test Army 3");
        data.put(ArmyColumns.COLUMN_NAME_POINT_TOTAL, 400);
        data.put(ArmyColumns.COLUMN_NAME_USER_ID, 2);
        db.insert(ArmyColumns.TABLE_NAME, null, data);
    }
    //endregion

    //region MasterSet

    //region MasterSet
    private static final String SQL_CREATE_MASTER_SET_TABLE =
            "CREATE TABLE " + MasterSetColumns.TABLE_NAME + " (" +
                    MasterSetColumns._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    MasterSetColumns.COLUMN_NAME_SET_NAME + TEXT_TYPE +
                    " )";

    private static final String SQL_DELETE_MASTER_SET_TABLE =
            "DROP TABLE IF EXISTS " + MasterSetColumns.TABLE_NAME;
    //endregion

    public static abstract class MasterSetColumns implements BaseColumns
    {
        public static final String TABLE_NAME = "MasterSetEntry";
        public static final String COLUMN_NAME_SET_NAME = "setName";
    }

    public void initMasterSetData(SQLiteDatabase db)
    {
        ContentValues data = new ContentValues();

        data.put(MasterSetColumns.COLUMN_NAME_SET_NAME, "Rise of the Valkyrie - Master Set");

        db.insert(MasterSetColumns.TABLE_NAME, null, data);
    }

    //endregion

    //region ArmyCards

    //region ArmyCards
    private static final String SQL_CREATE_ARMY_CARDS_TABLE =
            "CREATE TABLE " + ArmyCardsColumns.TABLE_NAME + " (" +
                    ArmyCardsColumns.COLUMN_NAME_ARMY_ID + INT_TYPE + COMMA_SEP +
                    ArmyCardsColumns.COLUMN_NAME_CARD_ID + INT_TYPE +
                    " )";

    private static final String SQL_DELETE_ARMY_CARDS_TABLE =
            "DROP TABLE IF EXISTS " + ArmyCardsColumns.TABLE_NAME;
    //endregion

    public static abstract class ArmyCardsColumns implements BaseColumns
    {
        public static final String TABLE_NAME = "ArmyCards";
        public static final String COLUMN_NAME_ARMY_ID = "armyId";
        public static final String COLUMN_NAME_CARD_ID = "CardId";
    }

    public void initArmyCardsData(SQLiteDatabase db)
    {
        ContentValues data = new ContentValues();

        data.put(ArmyCardsColumns.COLUMN_NAME_ARMY_ID, 1);
        data.put(ArmyCardsColumns.COLUMN_NAME_CARD_ID, 1);
        db.insert(ArmyCardsColumns.TABLE_NAME, null, data);

        data.clear();
        data.put(ArmyCardsColumns.COLUMN_NAME_ARMY_ID, 1);
        data.put(ArmyCardsColumns.COLUMN_NAME_CARD_ID, 2);
        db.insert(ArmyCardsColumns.TABLE_NAME, null, data);

        data.clear();
        data.put(ArmyCardsColumns.COLUMN_NAME_ARMY_ID, 1);
        data.put(ArmyCardsColumns.COLUMN_NAME_CARD_ID, 3);
        db.insert(ArmyCardsColumns.TABLE_NAME, null, data);

        data.clear();
        data.put(ArmyCardsColumns.COLUMN_NAME_ARMY_ID, 1);
        data.put(ArmyCardsColumns.COLUMN_NAME_CARD_ID, 4);
        db.insert(ArmyCardsColumns.TABLE_NAME, null, data);

        data.clear();
        data.put(ArmyCardsColumns.COLUMN_NAME_ARMY_ID, 2);
        data.put(ArmyCardsColumns.COLUMN_NAME_CARD_ID, 2);
        db.insert(ArmyCardsColumns.TABLE_NAME, null, data);

        data.clear();
        data.put(ArmyCardsColumns.COLUMN_NAME_ARMY_ID, 2);
        data.put(ArmyCardsColumns.COLUMN_NAME_CARD_ID, 3);
        db.insert(ArmyCardsColumns.TABLE_NAME, null, data);

        data.clear();
        data.put(ArmyCardsColumns.COLUMN_NAME_ARMY_ID, 3);
        data.put(ArmyCardsColumns.COLUMN_NAME_CARD_ID, 4);
        db.insert(ArmyCardsColumns.TABLE_NAME, null, data);
    }

    //endregion

    //region User

    //region User
    private static final String SQL_CREATE_USER_TABLE =
            "CREATE TABLE " + UserColumns.TABLE_NAME + " (" +
                    UserColumns._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    UserColumns.COLUMN_NAME_USER_NAME + TEXT_TYPE +
                    " )";

    private static final String SQL_DELETE_USER_TABLE =
            "DROP TABLE IF EXISTS " + UserColumns.TABLE_NAME;

    //endregion

    public  static abstract class UserColumns implements BaseColumns
    {
        public static final String TABLE_NAME = "Users";
        public static final String COLUMN_NAME_USER_NAME = "username";
    }

    public void initUserData(SQLiteDatabase db)
    {
        ContentValues data = new ContentValues();

        data.put(UserColumns.COLUMN_NAME_USER_NAME, "Test User");

        db.insert(UserColumns.TABLE_NAME, null, data);
    }

    //endregion
}
