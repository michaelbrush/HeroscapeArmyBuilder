package info.michaelbrush.development.heroscapearmybuilder;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import info.michaelbrush.development.heroscapearmybuilder.DatabaseManager.CardDatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void onClick(View view)
    {
        Intent intent;
        switch(view.getId())
        {
            case(R.id.buttonArmies):
                intent = new Intent(this, ArmyListActivity.class);
                startActivity(intent);
                break;
            case(R.id.buttonCards):
                intent = new Intent(this, CardListActivity.class);
                startActivity(intent);
                break;
            case(R.id.buttonDeck):

                break;
            case(R.id.buttonUsers):

                break;
            case(R.id.buttonDelete):
                CardDatabaseHelper cards = new CardDatabaseHelper(getApplicationContext());
                cards.onUpgrade(cards.getWritableDatabase(), 1, 1);
                break;
        }
    }

    public void showDb(View view)
    {
//        HeroscapeDeck deck;
//        deck = new HeroscapeDeck(getApplicationContext());
//        TextView text = (TextView) findViewById(R.id.textView2);
//        text.setText(deck.getDatabaseName());
//
//        SQLiteDatabase db = deck.getReadableDatabase();
//        db.

//        CardDatabaseHelper cardDB = new CardDatabaseHelper(getApplicationContext());
//        String qry = "SELECT name FROM Cards where _ID = 1";
//        SQLiteDatabase db = cardDB.getReadableDatabase();
//        Cursor result = db.rawQuery(qry, null);
//        result.moveToFirst();
////        text.setText(result.getString(0));
//        db.close();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
