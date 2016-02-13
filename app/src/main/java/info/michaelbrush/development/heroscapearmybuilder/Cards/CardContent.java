package info.michaelbrush.development.heroscapearmybuilder.Cards;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.michaelbrush.development.heroscapearmybuilder.DatabaseManager.CardDatabaseHelper;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
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
        Cursor allCards = db.query(CardDatabaseHelper.CardEntry.TABLE_NAME,
                new String[]
                    {
                        CardDatabaseHelper.CardEntry._ID,
                        CardDatabaseHelper.CardEntry.COLUMN_NAME_NAME,
                        CardDatabaseHelper.CardEntry.COLUMN_NAME_SPECIAL_ABILITIES
                    },
                null, null, null, null, null);

        allCards.moveToFirst();

        while(!allCards.isAfterLast())
        {
            newCard = new CardItem(allCards.getString(0), allCards.getString(1), allCards.getString(2));
            addItem(newCard);
            allCards.moveToNext();
        }
        allCards.close();
    }

    private void addItem(CardItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private CardItem createCardItem(int position) {
        return new CardItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public class CardItem {
        public final String id;
        public final String content;
        public final String details;

        public CardItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
