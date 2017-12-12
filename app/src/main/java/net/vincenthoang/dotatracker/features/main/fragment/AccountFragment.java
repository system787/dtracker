package net.vincenthoang.dotatracker.features.main.fragment;

import android.content.Context;
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
import net.vincenthoang.dotatracker.injection.component.FragmentComponent;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import timber.log.Timber;


/**
 * Created by vincenthoang on 12/10/17.
 */

public class AccountFragment extends BaseFragment implements MainFragmentView {

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

    private FragmentComponent mFragmentComponent;
    private Context mContext;
    private View mView;
    private List<Hero> mHeroList;
    private List<HeroesPlayed> mHeroesPlayedList;
    private List<HeroListData> mDataList;
    private WinLoss mWinLoss;
    private PlayerProfile mPlayerProfile;
    private AccountFragmentAdapter mFragmentAdapter;
    private boolean mIsImageLoading;
    private Drawable mProfileDrawable;


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

    @Override
    public void showProgress(boolean show) {
        if (show) {
            if (mListView.getVisibility() == View.VISIBLE) {
                mRefreshLayout.setRefreshing(true);
            } else {
                mProgressBar.setVisibility(View.VISIBLE);
                mListView.setVisibility(View.GONE);
            }

            mErrorView.setVisibility(View.GONE);
        } else {
            mRefreshLayout.setRefreshing(false);
            mListView.setVisibility(View.GONE);
        }
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
        ImageView profileImage = new ImageView(getContext());
        mIsImageLoading = true;
        Ion.with(profileImage).load(mPlayerProfile.getProfile().getAvatar()).setCallback(new FutureCallback<ImageView>() {
            @Override
            public void onCompleted(Exception e, ImageView result) {
                mIsImageLoading = false;
                mProfileDrawable = result.getDrawable();
                prepareViews();
            }
        });
    }

    @Override
    public void getRefreshAll(List<HeroesPlayed> heroesPlayedList, PlayerProfile playerProfile, WinLoss winLoss) {
        mHeroesPlayedList = heroesPlayedList;
        mPlayerProfile = playerProfile;
        mWinLoss = winLoss;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void prepareViews() {
        HeroListHeader heroHeader = new HeroListHeader();
        heroHeader.setUsername(mPlayerProfile.getProfile().getPersonaname());
        heroHeader.setWinPercentage(calculateWinPercentage());

        Collections.sort(mHeroList, new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                return o1.getId() - o2.getId();
            }
        });

        HeroListHeader header = new HeroListHeader();
        header.setWinPercentage(calculateWinPercentage());
        header.setUsername(mPlayerProfile.getProfile().getPersonaname());
        header.setDrawable(mProfileDrawable);

        for (HeroesPlayed hp : mHeroesPlayedList) {
            HeroListItem item = new HeroListItem();
            Hero hero = mHeroList.get(Integer.parseInt(hp.getHeroId()) - 1);
            item.setHeroName(hero.getLocalizedName());
            item.setGamesPlayed(String.valueOf(hp.getGames()));
            item.setGamesWon(String.valueOf(hp.getWin()));
            item.setGamesPlayedProgress((int) hp.getGames() / (mWinLoss.getLose() + mWinLoss.getWin()));

            AssetManager am = mContext.getAssets();
            try {
                InputStream is = am.open(hero.getFileName());
                Drawable drawable = Drawable.createFromStream(is, hero.getLocalizedName());
                item.setHeroImage(drawable);
            } catch (IOException e) {
                Log.e(TAG, "Error loading image for hero->" + hero.getLocalizedName());
            }

            mDataList.add(item);
        }
        setFragmentAdapter();
    }

    private void setFragmentAdapter() {
        AccountFragmentAdapter adapter = new AccountFragmentAdapter(mContext, mDataList);
        mListView.setAdapter(adapter);
        showProgress(false);
    }

    private String calculateWinPercentage() {
        NumberFormat nf = DecimalFormat.getPercentInstance();
        nf.setMaximumFractionDigits(1);
        return nf.format(mWinLoss.getWin() / (mWinLoss.getWin() + mWinLoss.getLose()));
    }
}
