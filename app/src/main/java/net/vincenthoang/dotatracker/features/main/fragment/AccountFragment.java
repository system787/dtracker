package net.vincenthoang.dotatracker.features.main.fragment;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import net.vincenthoang.dotatracker.R;
import net.vincenthoang.dotatracker.data.local.HeroesManager;
import net.vincenthoang.dotatracker.data.model.Hero;
import net.vincenthoang.dotatracker.data.model.response.HeroesPlayed;
import net.vincenthoang.dotatracker.data.model.response.PlayerProfile;
import net.vincenthoang.dotatracker.data.model.response.WinLoss;
import net.vincenthoang.dotatracker.features.base.BaseFragment;
import net.vincenthoang.dotatracker.features.common.ErrorView;
import net.vincenthoang.dotatracker.features.main.FragmentPresenter;
import net.vincenthoang.dotatracker.features.main.UpdateableFragment;
import net.vincenthoang.dotatracker.injection.component.FragmentComponent;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;


/**
 * Created by vincenthoang on 12/10/17.
 */

public class AccountFragment extends BaseFragment implements MainFragmentView, UpdateableFragment {

    private static final String TAG = "AccountFragment";

    @Inject
    FragmentPresenter mFragmentPresenter;

    @BindView(R.id.frag_account_progress)
    ProgressBar mProgressBar;

    @BindView(R.id.frag_account_view_error)
    ErrorView mErrorView;

    @BindView(R.id.accountRefreshLayout)
    SwipeRefreshLayout mRefreshLayout;

    @BindView(R.id.heroesPlayedListView)
    ListView mListView;

    @BindView(R.id.jankyImageView)
    ImageView mProfileDrawable;

    private View mView;
    private List<Hero> mHeroList;
    private List<HeroesPlayed> mHeroesPlayedList;
    private List<HeroListData> mDataList;
    private WinLoss mWinLoss;
    private PlayerProfile mPlayerProfile;
    private boolean mIsImageLoading;
    private AccountFragmentAdapter mFragmentAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHeroList = HeroesManager.getHeroList(getContext());
        mHeroesPlayedList = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.fragment_account, container, false);
        ButterKnife.bind(this, mView);

        mListView = mView.findViewById(R.id.heroesPlayedListView);
        mDataList = new ArrayList<>();
        mFragmentAdapter = new AccountFragmentAdapter(getActivity(), mDataList);
        mListView.setAdapter(mFragmentAdapter);

        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });

        refresh();

        return mView;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_account;
    }

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    protected void attachView() {
        mFragmentPresenter.attachView(this);
    }

    @Override
    protected void detachPresenter() {
        mFragmentPresenter.detachView();
    }

    private void refresh() {
        mFragmentPresenter.getProfileRefresh(114611L);
    }

    private void loadImage() {
        mIsImageLoading = true;
        Log.i(TAG, "Getting player profile image with Ion");
        Log.i(TAG, "mPlayerProfile->" + mPlayerProfile.toString());
        Ion.getDefault(getActivity()).build(mProfileDrawable).load(mPlayerProfile.getProfile().getAvatarfull()).setCallback(new FutureCallback<ImageView>() {
            @Override
            public void onCompleted(Exception e, ImageView result) {
                Log.i(TAG, "Ion request complete");
                mIsImageLoading = false;
            }
        });
    }

    @Override
    public void showList(List<HeroesPlayed> heroesPlayedList) {
        mRefreshLayout.setVisibility(View.VISIBLE);
        mListView.setVisibility(View.VISIBLE);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mDataList = prepareViews(heroesPlayedList);
                mFragmentAdapter.setDataList(prepareViews(heroesPlayedList));
                mFragmentAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showProgress(boolean show) {
        /*
        if (show) {
            if (mListView.getVisibility() == View.VISIBLE && mFragmentAdapter.getCount() > 0) {
                mRefreshLayout.setRefreshing(true);
            } else {
                mProgressBar.setVisibility(View.VISIBLE);
                mListView.setVisibility(View.GONE);
                mRefreshLayout.setVisibility(View.GONE);
            }

            mErrorView.setVisibility(View.GONE);
        } else {
            mRefreshLayout.setRefreshing(false);
            mProgressBar.setVisibility(View.GONE);
        }
        */
    }

    @Override
    public void showError(Throwable error) {
        mListView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
        Timber.e(error, "There was an error retrieving data");
    }

    @Override
    public void getHeroesPlayed(List<HeroesPlayed> heroesPlayedList) {
        mHeroesPlayedList = heroesPlayedList;
    }

    @Override
    public void getWinLoss(WinLoss winLoss) {
        mWinLoss = winLoss;
    }

    @Override
    public void getPlayerProfile(PlayerProfile playerProfile) {
        mPlayerProfile = playerProfile;
    }

    @Override
    public void getRefreshAll(List<HeroesPlayed> heroesPlayedList, PlayerProfile playerProfile, WinLoss winLoss) {
        mHeroesPlayedList = heroesPlayedList;
        mPlayerProfile = playerProfile;
        mWinLoss = winLoss;
        loadImage();
        Log.i(TAG, "getRefreshAll complete, values returned");
        showList(heroesPlayedList);
        mRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private List<HeroListData> prepareViews(List<HeroesPlayed> heroesPlayedList) {
        Log.i(TAG, "Preparing views");

        List<HeroListData> tempList = new ArrayList<>();

        HeroListHeader header = new HeroListHeader();
        header.setWinPercentage(calculateWinPercentage());
        header.setUsername(mPlayerProfile.getProfile().getPersonaname());
        header.setDrawable(mProfileDrawable.getDrawable());
        tempList.add(header);

        //for (HeroesPlayed hp : heroesPlayedList) {
        //    Log.i(TAG, hp.toString());
        //}

        //for (Hero h : mHeroList) {
        //    Log.i(TAG, h.toString());
        //}

        int mostPlayed = heroesPlayedList.get(0).getGames();

        for (HeroesPlayed hp : heroesPlayedList) {
            HeroListItem item = new HeroListItem();
            Hero hero = getHero(hp);
            item.setHeroName(hero.getLocalizedName());
            item.setGamesPlayed(String.valueOf(hp.getGames()));
            item.setGamesWon(String.valueOf(hp.getWin()));
            item.setGamesPlayedProgress((int) ((hp.getGames() * 100.0) / mostPlayed));

            AssetManager am = getContext().getAssets();
            try {
                InputStream is = am.open(hero.getFileName());
                Drawable drawable = Drawable.createFromStream(is, hero.getLocalizedName());
                item.setHeroImage(drawable);
            } catch (IOException e) {
                Log.e(TAG, "Error loading image for hero->" + hero.getLocalizedName());
            }

            tempList.add(item);
        }

        Log.i(TAG, "Finished preparing views; mDataList size->" + mDataList.size());

        return tempList;
    }

    private String calculateWinPercentage() {
        NumberFormat nf = DecimalFormat.getPercentInstance();
        nf.setMaximumFractionDigits(2);
        return nf.format(((100.0 * mWinLoss.getWin()) / (mWinLoss.getWin() + mWinLoss.getLose())) / 100.0);
    }

    @Override
    public void update() {
        refresh();
    }

    private Hero getHero(HeroesPlayed heroesPlayed) {
        for (Hero h : mHeroList) {
            int heroId = heroesPlayed.getHeroId();
            if (heroId == h.getId()) {
                return h;
            }
        }
        return null;
    }
}
