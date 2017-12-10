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

    public void getPokemon(int limit) {
        checkViewAttached();
        getView().showProgress(true);
        dataManager
                .getPokemonList(limit)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(
                        pokemons -> {
                            getView().showProgress(false);
                            getView().showPokemon(pokemons);
                        },
                        throwable -> {
                            getView().showProgress(false);
                            getView().showError(throwable);
                        });
    }
}
