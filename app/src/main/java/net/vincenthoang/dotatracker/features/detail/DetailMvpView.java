package net.vincenthoang.dotatracker.features.detail;

import net.vincenthoang.dotatracker.data.model.response.Pokemon;
import net.vincenthoang.dotatracker.data.model.response.Statistic;
import net.vincenthoang.dotatracker.features.base.MvpView;

public interface DetailMvpView extends MvpView {

    void showPokemon(Pokemon pokemon);

    void showStat(Statistic statistic);

    void showProgress(boolean show);

    void showError(Throwable error);
}
