package net.vincenthoang.dotatracker.features.main;

import javax.inject.Inject;

import net.vincenthoang.dotatracker.data.DataManager;
import net.vincenthoang.dotatracker.features.base.BasePresenter;
import net.vincenthoang.dotatracker.injection.ConfigPersistent;
import net.vincenthoang.dotatracker.util.rx.scheduler.SchedulerUtils;

@ConfigPersistent
public class MainPresenter extends BasePresenter<MainMvpView> {

    private final DataManager dataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }

    public void getHeroesPlayed(long steamId) {
        checkViewAttached();
        getView().showProgress(true);

        dataManager.getHeroesPlayedList(steamId)
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

        dataManager.getPlayerWinLoss(steamId)
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

        dataManager.getPlayerProfile(steamId)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(playerProfile -> {
                    getView().showProgress(false);
                    getView().getPlayerProfile(playerProfile);
                }, throwable -> {
                    getView().showProgress(false);
                    getView().showError(throwable);
                });
    }
}
