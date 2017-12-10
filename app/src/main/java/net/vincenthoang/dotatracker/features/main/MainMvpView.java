package net.vincenthoang.dotatracker.features.main;

import java.util.List;

import net.vincenthoang.dotatracker.features.base.MvpView;

public interface MainMvpView extends MvpView {


    void showPokemon(List<String> pokemon);

    void showProgress(boolean show);

    void showError(Throwable error);
}
