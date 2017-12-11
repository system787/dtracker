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
        return mPlayerService.getHeroesPlayedList(parameter).toObservable()
                .flatMapIterable(namedResources -> namedResources.results)
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

    /*
    public Single<List<String>> getPokemonList(int limit) {
        return pokemonService
                .getPokemonList(limit)
                .toObservable()
                .flatMapIterable(namedResources -> namedResources.results)
                .map(namedResource -> namedResource.name)
                .toList();
    }

    public Single<Pokemon> getPokemon(String name) {
        return pokemonService.getPokemon(name);
    }
    */
}
