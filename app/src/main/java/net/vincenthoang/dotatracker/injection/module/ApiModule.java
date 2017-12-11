package net.vincenthoang.dotatracker.injection.module;

import net.vincenthoang.dotatracker.data.remote.PlayerService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by shivam on 29/5/17.
 */
@Module(includes = {NetworkModule.class})
public class ApiModule {

    @Provides
    @Singleton
    PlayerService providePlayerServiceApi(Retrofit retrofit) {
        return retrofit.create(PlayerService.class);
    }
}
