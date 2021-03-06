package info.michaelbrush.development.heroscapearmybuilder;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import info.michaelbrush.development.heroscapearmybuilder.Cards.CardContent;

/**
 * A fragment representing a single Card detail screen.
 * This fragment is either contained in a {@link CardListActivity}
 * in two-pane mode (on tablets) or a {@link CardDetailActivity}
 * on handsets.
 */
public class CardDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private CardContent.CardItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CardDetailFragment() {
    }

    @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = CardContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.name);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.card_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.card_detail_life_value)).setText((Integer.toString(mItem.life)));
            ((TextView) rootView.findViewById(R.id.card_detail_range_value)).setText((Integer.toString(mItem.range)));
            ((TextView) rootView.findViewById(R.id.card_detail_attack_value)).setText((Integer.toString(mItem.attack)));
            ((TextView) rootView.findViewById(R.id.card_detail_defense_value)).setText((Integer.toString(mItem.defense)));
            ((TextView) rootView.findViewById(R.id.card_detail_move_value)).setText((Integer.toString(mItem.move)));
            ((TextView) rootView.findViewById(R.id.card_detail_cost_value)).setText((Integer.toString(mItem.cost)));
        }

        return rootView;
    }
}
