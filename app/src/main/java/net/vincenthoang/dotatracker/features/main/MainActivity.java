package net.vincenthoang.dotatracker.features.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.BindView;
import net.vincenthoang.dotatracker.R;
import net.vincenthoang.dotatracker.data.model.response.HeroesPlayed;
import net.vincenthoang.dotatracker.data.model.response.PlayerProfile;
import net.vincenthoang.dotatracker.data.model.response.WinLoss;
import net.vincenthoang.dotatracker.features.base.BaseActivity;
import net.vincenthoang.dotatracker.features.common.ErrorView;
import net.vincenthoang.dotatracker.injection.component.ActivityComponent;

import java.util.List;

public class MainActivity extends BaseActivity implements MainMvpView, ErrorView.ErrorListener {

    @Inject
    MainPresenter mainPresenter;

    @BindView(R.id.view_error)
    ErrorView errorView;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.homeTabLayout)
    TabLayout mTabLayout;

    @BindView(R.id.homeViewPager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(toolbar);

        errorView.setErrorListener(this);

        HomeViewPagerAdapter viewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(viewPagerAdapter);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void attachView() {
        mainPresenter.attachView(this);
    }

    @Override
    protected void detachPresenter() {
        mainPresenter.detachView();
    }

    @Override
    public void getHeroesPlayed(List<HeroesPlayed> heroesPlayedList) {

    }

    @Override
    public void getWinLoss(WinLoss winLoss) {

    }

    @Override
    public void getPlayerProfile(PlayerProfile playerProfile) {

    }

    @Override
    public void showProgress(boolean show) {
        /*
        if (show) {
            if (pokemonRecycler.getVisibility() == View.VISIBLE
                    && pokemonAdapter.getItemCount() > 0) {
                swipeRefreshLayout.setRefreshing(true);
            } else {
                progressBar.setVisibility(View.VISIBLE);

                pokemonRecycler.setVisibility(View.GONE);
                swipeRefreshLayout.setVisibility(View.GONE);
            }

            errorView.setVisibility(View.GONE);
        } else {
            swipeRefreshLayout.setRefreshing(false);
            progressBar.setVisibility(View.GONE);
        }
        */
    }

    @Override
    public void showError(Throwable error) {
        /*
        pokemonRecycler.setVisibility(View.GONE);
        swipeRefreshLayout.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        Timber.e(error, "There was an error retrieving the pokemon");
        */
    }

    @Override
    public void onReloadData() {
        mainPresenter.getHeroesPlayed(114611);
    }
}
