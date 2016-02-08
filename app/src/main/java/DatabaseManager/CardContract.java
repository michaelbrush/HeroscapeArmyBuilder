package DatabaseManager;

import android.provider.BaseColumns;

/**
 * Created by Development on 2/7/2016.
 */
public class CardContract {

    public CardContract() {}

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
}
