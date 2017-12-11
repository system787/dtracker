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

        dataManager.getHeroesPlayedList(114611)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(heroes -> {
                            getView().showProgress(false);
                            // TODO: getView().showHeroes(heroes);
                        },
                        throwable -> {
                            getView().showProgress(false);
                            getView().showError(throwable);
                        });
    }
}
