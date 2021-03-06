package net.vincenthoang.dotatracker.features.main.accountfragment;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import net.vincenthoang.dotatracker.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import io.netopen.hotbitmapgg.library.view.RingProgressBar;

/**
 * Created by vincenthoang on 12/11/17.
 */

public class AccountFragmentAdapter extends BaseAdapter {

    private static final int VIEW_TYPE_NONE = 0;
    private static final int VIEW_TYPE_HEADER = 1;
    private static final int VIEW_TYPE_HERO_ITEM = 2;

    private Context mContext;

    private LayoutInflater mLayoutInflater;
    private List<HeroListData> mDataList;

    public AccountFragmentAdapter(Context context, List<HeroListData> listData) {
        super();
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mDataList = listData;
        Log.i("AccountFragmentAdapter", "mDataList initialized->" + mDataList.size());
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return mDataList.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public HeroListData getItem(int position) {
        if (mDataList.isEmpty()) {
            return null;
        } else {
            return mDataList.get(position);
        }
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (getItemViewType(position) == VIEW_TYPE_HEADER) {
            return getHeaderView(position, convertView, parent);
        } else if (getItemViewType(position) == VIEW_TYPE_HERO_ITEM) {
            return getItemView(position, convertView, parent);
        }
        Log.i("AccountFragmentAdapter", "getView(); Slipped past the if statements");
        return null;
    }

    @NonNull
    private View getItemView(int position, View convertView, ViewGroup parent) {
        ListItemHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_hero, parent, false);
            holder = new ListItemHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ListItemHolder) convertView.getTag();
        }

        HeroListItem listItem = (HeroListItem) getItem(position);
        holder.setHeroName(listItem.getHeroName());
        holder.setGamesPlayed(mContext.getString(R.string.games_played, listItem.getGamesPlayed()));
        holder.setHeroImage(listItem.getHeroImage());
        holder.setGamesWon(mContext.getString(R.string.games_won, listItem.getGamesWon()));
        holder.setGamesPlayedProgressBar(listItem.getGamesPlayedProgress());

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        if (getCount() > 0) {
            HeroListData data = getItem(position);
            if (data instanceof HeroListHeader) {
                return VIEW_TYPE_HEADER;
            } else if (data instanceof HeroListItem) {
                return VIEW_TYPE_HERO_ITEM;
            } else {
                return VIEW_TYPE_NONE;
            }
        } else {
            return VIEW_TYPE_NONE;
        }
    }

    @Override
    public int getViewTypeCount()  {
        return 3;
    }

    @NonNull
    private View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.account_fragment_header, parent, false);
            holder = new HeaderViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }

        String winPercentageText = ((HeroListHeader) getItem(position)).getWinPercentage();
        double winPercentage = Double.parseDouble(winPercentageText.replaceAll("%", ""));

        holder.setUsername(((HeroListHeader) getItem(position)).getUsername());
        holder.setWinPercentageText(winPercentageText);
        holder.setRingProgressBar((int) winPercentage);
        holder.setProfilePicture(((HeroListHeader) getItem(position)).getDrawable());
        holder.setWinPercentageColor(winPercentage, mContext);

        return convertView;
    }

    public void setDataList(List<HeroListData> listData) {
        this.mDataList.clear();
        this.mDataList.addAll(listData);
        Log.i("AccountFragmentAdapter", "mDataList updated->" + mDataList.size());
        this.notifyDataSetChanged();
    }

    public static class HeaderViewHolder {
        TextView mUsername;
        TextView mWinPercentageText;
        ImageView mProfilePicture;
        RingProgressBar mRingProgressBar;

        public HeaderViewHolder(View view) {
            mUsername = view.findViewById(R.id.frag_userName);
            mWinPercentageText = view.findViewById(R.id.winPercentageTextView);
            mProfilePicture = view.findViewById(R.id.profilePicture);
            mRingProgressBar = view.findViewById(R.id.winRingProgressBar);
        }

        public void setRingProgressBar(int winPercentage) {
            mRingProgressBar.setProgress(winPercentage);
        }

        public void setUsername(String username) {
            mUsername.setText(username);
        }

        public void setWinPercentageText(String winPercentageText) {
            mWinPercentageText.setText(winPercentageText);
        }

        public void setProfilePicture(Drawable profilePicture) {
            mProfilePicture.setImageDrawable(profilePicture);
        }

        public void setWinPercentageColor(double winPercentage, Context context) {

            if (winPercentage >= 54) {
                mWinPercentageText.setTextColor(context.getResources().getColor(R.color.win_gooder));
            } else if (winPercentage >= 52) {
                mWinPercentageText.setTextColor(context.getResources().getColor(R.color.win_good));
            } else if (winPercentage >= 48) {
                mWinPercentageText.setTextColor(context.getResources().getColor(R.color.white));
            } else if (winPercentage >= 46){
                mWinPercentageText.setTextColor(context.getResources().getColor(R.color.win_bad));
            } else {
                mWinPercentageText.setTextColor(context.getResources().getColor(R.color.win_badder));
            }
        }
    }

    public static class ListItemHolder {
        View mView;
        TextView mHeroName;
        TextView mGamesPlayed;
        TextView mGamesWon;
        CircleImageView mHeroImage;
        ProgressBar mGamesPlayedProgressBar;

        public ListItemHolder(View view) {
            mView = view;
            mHeroName = view.findViewById(R.id.hero_name_text_view);
            mGamesWon = view.findViewById(R.id.hero_games_won_text_view);
            mGamesPlayed = view.findViewById(R.id.hero_games_played_text_view);
            mHeroImage = view.findViewById(R.id.hero_image_circle_view);
            mGamesPlayedProgressBar = view.findViewById(R.id.hero_games_played_progress_Bar);
        }

        public void setHeroName(String heroName) {
            mHeroName.setText(heroName);
        }

        public void setGamesPlayed(String gamesPlayed) {;
            mGamesPlayed.setText(gamesPlayed);
        }

        public void setGamesWon(String gamesWon) {;
            mGamesWon.setText(gamesWon);
        }

        public void setHeroImage(Drawable heroImage) {
            mHeroImage.setImageDrawable(heroImage);
        }

        public void setGamesPlayedProgressBar(int gamesPlayed) {
            mGamesPlayedProgressBar.setProgress(gamesPlayed);
        }

    }

}
