package DatabaseManager;

import android.provider.BaseColumns;

/**
 * Created by Development on 2/7/2016.
 */
public class ArmyCardsContract {

    public ArmyCardsContract() {}

    public static abstract class ArmyCardsEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "ArmyCards";
        public static final String COLUMN_NAME_ARMY_ID = "armyId";
        public static final String COLUMN_NAME_USER_ID = "CardId";
    }
}
