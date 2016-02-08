package DatabaseManager;

import android.provider.BaseColumns;

/**
 * Created by Development on 2/7/2016.
 */
public final class ArmyContract {

    public ArmyContract () {}

    public static abstract class ArmyEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "Armies";
        public static final String COLUMN_NAME_USER_ID = "userId";
        public static final String COLUMN_NAME_POINT_TOTAL = "pointTotal";
    }
}
