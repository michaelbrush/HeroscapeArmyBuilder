package info.michaelbrush.development.heroscapearmybuilder.Armies;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.michaelbrush.development.heroscapearmybuilder.Database.DatabaseHelper;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 */
public class ArmyContent {

    /**
     * An array of sample (Army) items.
     */
    public static final List<ArmyItem> ITEMS = new ArrayList<ArmyItem>();

    /**
     * A map of sample (Army) items, by ID.
     */
    public static final Map<String, ArmyItem> ITEM_MAP = new HashMap<String, ArmyItem>();

    public ArmyContent(SQLiteDatabase db)
    {
        ITEMS.clear();
        ArmyItem newArmy;
        Cursor allArmies = db.query(DatabaseHelper.ArmyColumns.TABLE_NAME,
                new String[]
                        {
                                DatabaseHelper.ArmyColumns._ID,
                                DatabaseHelper.ArmyColumns.COLUMN_NAME_NAME,
                                DatabaseHelper.ArmyColumns.COLUMN_NAME_POINT_TOTAL,
                                DatabaseHelper.ArmyColumns.COLUMN_NAME_USER_ID
                        },
                null, null, null, null, null);

        allArmies.moveToFirst();

        while(!allArmies.isAfterLast())
        {
            newArmy = new ArmyItem(allArmies.getString(0), allArmies.getString(1), allArmies.getInt(2), allArmies.getInt(3));
            addItem(newArmy);
            allArmies.moveToNext();
        }
        allArmies.close();
    }

    private static void addItem(ArmyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

//    private static ArmyItem createArmyItem(int position) {
//        return new ArmyItem(String.valueOf(position), "Item " + position, makeDetails(position));
//    }

//    private static String makeDetails(int position) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Details about Item: ").append(position);
//        for (int i = 0; i < position; i++) {
//            builder.append("\nMore details information here.");
//        }
//        return builder.toString();
//    }

    /**
     * A Army item representing a piece of content.
     */
    public static class ArmyItem {
        public final String id;
        public final String name;
        public final int userId;
        public final int pointTotal;

        public ArmyItem(String id, String name, int pointTotal, int userId) {
            this.id = id;
            this.name = name;
            this.userId = userId;
            this.pointTotal = pointTotal;
        }

        @Override
        public String toString() {
            return name + " (" + pointTotal + ")";
        }
    }
}
