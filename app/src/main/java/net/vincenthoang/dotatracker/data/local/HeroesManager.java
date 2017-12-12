package net.vincenthoang.dotatracker.data.local;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.vincenthoang.dotatracker.data.model.Hero;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by vincenthoang on 12/11/17.
 */


public class HeroesManager {

    public static List<Hero> getHeroList(Context context) {
        try {
            AssetManager am = context.getAssets();
            InputStream is = am.open("heroes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            Gson gson = new Gson();
            return gson.fromJson(new String(buffer, "UTF-8"), new TypeToken<List<Hero>>() {}.getType());
        } catch (IOException e) {
            Log.e("HeroesManager", "Unable to read file \"heroes.json\"", e);
        }
        return null;
    }

}
