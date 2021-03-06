package net.vincenthoang.dotatracker.features.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

import net.vincenthoang.dotatracker.R;
import net.vincenthoang.dotatracker.data.model.Hero;
import net.vincenthoang.dotatracker.features.main.accountfragment.AccountFragment;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by vincenthoang on 12/10/17.
 */

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder> {
    private final String TAG = "HeroAdapter";
    private AccountFragment mAccountFragment;

    public HeroAdapter(AccountFragment accountFragment) {
        this.mAccountFragment = accountFragment;
    }

    private List<Hero> heroList;
    private Subject<Hero> heroClickSubject;

    @Inject
    HeroAdapter() {
        heroClickSubject = PublishSubject.create();
        heroList = Collections.emptyList();
    }

    public void setHeroList(List<Hero> heroList) {
        this.heroList = heroList;
        notifyDataSetChanged();
    }

    /**
     * Called when RecyclerView needs a new {@link HeroViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(HeroViewHolder, int)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(HeroViewHolder, int)
     */
    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hero, parent, false);

        return new HeroViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link HeroViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link HeroViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p>
     * Override {@link #onBindViewHolder(HeroViewHolder, int)} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(HeroViewHolder holder, int position) {

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return 0;
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.hero_name_text_view)
        TextView heroNameText;

        @BindView(R.id.hero_games_played_text_view)
        TextView heroGamesPlayedText;

        @BindView(R.id.hero_games_won_text_view)
        TextView heroGamesWonText;

        @BindView(R.id.hero_image_circle_view)
        CircleImageView heroCircleImageView;

        private String heroName;

        HeroViewHolder(View itemView) {
            super(itemView);
        }

        void onBind(Hero hero) {
            this.heroName = hero.getLocalizedName();
            heroNameText.setText(heroName);
            Ion.with(mAccountFragment.getContext()).load(hero.getFileName()).intoImageView(heroCircleImageView);
        }
    }
}
