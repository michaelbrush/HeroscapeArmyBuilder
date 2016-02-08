package DatabaseManager;

import android.provider.BaseColumns;

/**
 * Created by Development on 2/7/2016.
 */
public final class UserContract {

    public UserContract()
    {}

    public  static abstract class UserEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "Users";
        public static final String COLUMN_NAME_USER_NAME = "username";
    }
}
