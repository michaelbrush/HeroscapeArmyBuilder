package info.michaelbrush.development.heroscapearmybuilder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import info.michaelbrush.development.heroscapearmybuilder.Cards.CardContent;
import info.michaelbrush.development.heroscapearmybuilder.Database.CardDatabaseHelper;

import java.util.List;

/**
 * An activity representing a list of Cards. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link CardDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class CardListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        View recyclerView = findViewById(R.id.card_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.card_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {

        CardDatabaseHelper cardDB = new CardDatabaseHelper(getApplicationContext());

        CardContent items = new CardContent(cardDB.getReadableDatabase());

        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(CardContent.ITEMS));

        cardDB.close();
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<CardContent.CardItem> mValues;

        public SimpleItemRecyclerViewAdapter(List<CardContent.CardItem> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mNameView.setText(mValues.get(position).name);
            holder.mCostView.setText(Integer.toString(mValues.get(position).cost));
            holder.mDefenseView.setText(Integer.toString(mValues.get(position).defense));
            holder.mAttackView.setText(Integer.toString(mValues.get(position).attack));
            holder.mMoveView.setText(Integer.toString(mValues.get(position).move));
            holder.mLifeView.setText(Integer.toString(mValues.get(position).life));
            holder.mRangeView.setText(Integer.toString(mValues.get(position).range));

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(CardDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                        CardDetailFragment fragment = new CardDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.card_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, CardDetailActivity.class);
                        intent.putExtra(CardDetailFragment.ARG_ITEM_ID, holder.mItem.id);

                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mNameView;
            public final TextView mCostView;
            public final TextView mLifeView;
            public final TextView mAttackView;
            public final TextView mDefenseView;
            public final TextView mRangeView;
            public final TextView mMoveView;
            public CardContent.CardItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mNameView = (TextView) view.findViewById(R.id.name);
                mCostView = (TextView) view.findViewById(R.id.cost);
                mLifeView = (TextView) view.findViewById(R.id.life);
                mAttackView = (TextView) view.findViewById(R.id.attack);
                mDefenseView = (TextView) view.findViewById(R.id.defense);
                mMoveView = (TextView) view.findViewById(R.id.move);
                mRangeView = (TextView) view.findViewById(R.id.range);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mCostView.getText() + "'";
            }
        }
    }
}
