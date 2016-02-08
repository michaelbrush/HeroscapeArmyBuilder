package DatabaseManager;

import android.provider.BaseColumns;

/**
 * Created by Development on 2/7/2016.
 */
public class MasterSetContract {

    public MasterSetContract() {}

    public static abstract class MasterSetEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "MasterSetEntry";
        public static final String COLUMN_NAME_SET_NAME = "setName";
    }
}
