package net.vincenthoang.dotatracker.data;

import net.vincenthoang.dotatracker.data.model.response.HeroesPlayed;
import net.vincenthoang.dotatracker.data.model.response.PlayerProfile;
import net.vincenthoang.dotatracker.data.model.response.WinLoss;
import net.vincenthoang.dotatracker.data.remote.PlayerService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by shivam on 29/5/17.
 */
@Singleton
public class DataManager {
    private PlayerService mPlayerService;

    @Inject
    public DataManager(PlayerService playerService) {
        this.mPlayerService = playerService;
    }

    public Single<List<HeroesPlayed>> getHeroesPlayedList(long steamId) {
        String parameter = String.valueOf(steamId);
        return mPlayerService.getHeroesPlayedList(parameter)
                .toObservable()
                .flatMapIterable(list -> list)
                .map(item -> new HeroesPlayed())
                .toList();
    }

    public Single<PlayerProfile> getPlayerProfile(long steamId) {
        String parameter = String.valueOf(steamId);
        return mPlayerService.getPlayerProfile(parameter);
    }

    public Single<WinLoss> getPlayerWinLoss(long steamId) {
        String parameter = String.valueOf(steamId);
        return mPlayerService.getPlayerWinLoss(parameter);
    }
}
