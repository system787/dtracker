package net.vincenthoang.dotatracker.features.main;

import net.vincenthoang.dotatracker.data.DataManager;
import net.vincenthoang.dotatracker.data.model.response.HeroesPlayed;
import net.vincenthoang.dotatracker.data.model.response.PlayerProfile;
import net.vincenthoang.dotatracker.data.model.response.WinLoss;
import net.vincenthoang.dotatracker.features.base.BasePresenter;
import net.vincenthoang.dotatracker.features.main.accountfragment.MainFragmentView;
import net.vincenthoang.dotatracker.injection.ConfigPersistent;
import net.vincenthoang.dotatracker.util.rx.scheduler.SchedulerUtils;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by vincenthoang on 12/11/17.
 */

@ConfigPersistent
public class FragmentPresenter extends BasePresenter<MainFragmentView> {

    private final DataManager mDataManager;

    @Inject
    public FragmentPresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(MainFragmentView mvpView) {
        super.attachView(mvpView);
    }

    public void getHeroesPlayed(long steamId) {
        checkViewAttached();
        getView().showProgress(true);

        mDataManager.getHeroesPlayedList(steamId)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(heroes -> {
                            getView().showProgress(false);
                            getView().getHeroesPlayed(heroes);
                        },
                        throwable -> {
                            getView().showProgress(false);
                            getView().showError(throwable);
                        });
    }

    public void getWinLoss(long steamId) {
        checkViewAttached();
        getView().showProgress(true);

        mDataManager.getPlayerWinLoss(steamId)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(winLoss -> {
                            getView().showProgress(false);
                            getView().getWinLoss(winLoss);
                        },
                        throwable -> {
                            getView().showProgress(false);
                            getView().showError(throwable);
                        });
    }

    public void getPlayerProfile(long steamId) {
        checkViewAttached();
        getView().showProgress(true);

        mDataManager.getPlayerProfile(steamId)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(playerProfile -> {
                    getView().showProgress(false);
                    getView().getPlayerProfile(playerProfile);
                }, throwable -> {
                    getView().showProgress(false);
                    getView().showError(throwable);
                });
    }

    public AdaptedResponse adaptResponse(PlayerProfile profileSingle, List<HeroesPlayed> heroListSingle, WinLoss winLossSingle) {
        return new AdaptedResponse(profileSingle, heroListSingle, winLossSingle);
    }


    public void getProfileRefresh(long steamId) {
        checkViewAttached();
        getView().showProgress(true);

        Single.zip(mDataManager.getPlayerProfile(steamId),
                mDataManager.getHeroesPlayedList(steamId),
                mDataManager.getPlayerWinLoss(steamId), (a, b, c) -> adaptResponse(a, b, c))
                .compose(SchedulerUtils.ioToMain())
                .subscribe(subscriber -> {
                    getView().showProgress(false);
                    getView().getRefreshAll(subscriber.getHeroesPlayedList(), subscriber.getProfile(), subscriber.getWinLoss());
                }, throwable -> {
                    getView().showProgress(false);
                    getView().showError(throwable);
                });
    }

    class AdaptedResponse {
        private PlayerProfile mProfile;
        private List<HeroesPlayed> mHeroesPlayedList;
        private WinLoss mWinLoss;

        public AdaptedResponse(PlayerProfile profile, List<HeroesPlayed> heroesPlayedList, WinLoss winLoss) {
            mProfile = profile;
            mHeroesPlayedList = heroesPlayedList;
            mWinLoss = winLoss;
        }

        public PlayerProfile getProfile() {
            return mProfile;
        }

        public void setProfile(PlayerProfile profile) {
            mProfile = profile;
        }

        public List<HeroesPlayed> getHeroesPlayedList() {
            return mHeroesPlayedList;
        }

        public void setHeroesPlayedList(List<HeroesPlayed> heroesPlayedList) {
            mHeroesPlayedList = heroesPlayedList;
        }

        public WinLoss getWinLoss() {
            return mWinLoss;
        }

        public void setWinLoss(WinLoss winLoss) {
            mWinLoss = winLoss;
        }
    }
}
