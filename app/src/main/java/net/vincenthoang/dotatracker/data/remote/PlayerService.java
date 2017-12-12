package net.vincenthoang.dotatracker.data.remote;

import net.vincenthoang.dotatracker.data.model.response.HeroesPlayedListResponse;
import net.vincenthoang.dotatracker.data.model.response.PlayerProfile;
import net.vincenthoang.dotatracker.data.model.response.WinLoss;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by vincenthoang on 12/10/17.
 */

public interface PlayerService {
    @GET("players/{account_id}/heroes")
    Single<List<HeroesPlayedListResponse>> getHeroesPlayedList(@Path("account_id") String account_id);

    @GET("players/{account_id}")
    Single<PlayerProfile> getPlayerProfile(@Path("account_id") String account_id);

    @GET("players/{account_id}/wl")
    Single<WinLoss> getPlayerWinLoss(@Path("account_id") String account_id);

}
