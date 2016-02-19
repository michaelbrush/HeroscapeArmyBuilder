package info.michaelbrush.development.heroscapearmybuilder.Cards;

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
public class CardContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<CardItem> ITEMS = new ArrayList<CardItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, CardItem> ITEM_MAP = new HashMap<String, CardItem>();

    public CardContent(SQLiteDatabase db)
    {
        ITEMS.clear();
        CardItem newCard;
        Cursor allCards = db.query(DatabaseHelper.CardColumns.TABLE_NAME,
                new String[]
                    {
                        DatabaseHelper.CardColumns._ID,
                        DatabaseHelper.CardColumns.COLUMN_NAME_NAME,
                        DatabaseHelper.CardColumns.COLUMN_NAME_COST,
                        DatabaseHelper.CardColumns.COLUMN_NAME_ATTACK,
                        DatabaseHelper.CardColumns.COLUMN_NAME_DEFENSE,
                        DatabaseHelper.CardColumns.COLUMN_NAME_MOVE,
                        DatabaseHelper.CardColumns.COLUMN_NAME_LIFE,
                        DatabaseHelper.CardColumns.COLUMN_NAME_RANGE,
                    },
                null, null, null, null, null);

        allCards.moveToFirst();

        while(!allCards.isAfterLast())
        {
            newCard = new CardItem(allCards.getString(0), allCards.getString(1), allCards.getInt(2), allCards.getInt(3), allCards.getInt(4), allCards.getInt(5), allCards.getInt(6), allCards.getInt(7));
            addItem(newCard);
            allCards.moveToNext();
        }
        allCards.close();
    }

    private void addItem(CardItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public class CardItem {
        public final String id;
        public final String name;
        public final int cost;
        public final int attack;
        public final int defense;
        public final int move;
        public final int life;
        public final int range;

        public CardItem(String id, String name, int cost, int attack, int defense, int move, int life, int range) {
            this.id = id;
            this.name = name;
            this.cost = cost;
            this.attack = attack;
            this.defense = defense;
            this.move = move;
            this.life = life;
            this.range = range;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
