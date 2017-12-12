package net.vincenthoang.dotatracker.features.main;

import net.vincenthoang.dotatracker.data.DataManager;
import net.vincenthoang.dotatracker.features.base.BasePresenter;
import net.vincenthoang.dotatracker.injection.ConfigPersistent;

import javax.inject.Inject;

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

}
