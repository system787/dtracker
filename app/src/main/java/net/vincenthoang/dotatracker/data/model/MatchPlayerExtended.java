package net.vincenthoang.dotatracker.data.model;

/**
 * Created by vincenthoang on 12/10/17.
 */

public class MatchPlayerExtended extends MatchPlayer {

    private int[] ability_upgrades_arr;
    private BuybackLog[] buyback_log;
    private int camps_stacked;
    private int creeps_stacked;
    private int obs_placed;
    private int sen_placed;
    private int pings;
    private int rune_pickups;
    private int stuns;
    private boolean is_roaming;
    private int lane;
    private int lane_role;
    private int rank_tier;
    private int roshan_kills;
    private int observer_kills;
    private int sentry_kills;
    private int buyback_count;

    private int kills_per_min;
    private double kda;

    static class BuybackLog {
        static int time;
        static int slot;
        static int player_slot;
    }

    public MatchPlayerExtended(long match_id, long account_id, int player_slot, int hero_id,
                               int level, int item_0, int item_1, int item_2, int item_3,
                               int item_4, int item_5, int kills, int deaths, int assists,
                               int hero_damage, int tower_damage, int hero_healing, int last_hits,
                               int denies, int gold, int gold_per_min, int gold_spent, int xp_per_min,
                               int leaver_status, String personaname, String name, boolean radiant_win,
                               boolean isRadiant, int[] ability_upgrades_arr, BuybackLog[] buyback_log,
                               int camps_stacked, int creeps_stacked, int obs_placed, int sen_placed,
                               int pings, int rune_pickups, int stuns, boolean is_roaming, int lane,
                               int lane_role, int rank_tier, int roshan_kills, int observer_kills,
                               int sentry_kills, int buyback_count, int kills_per_min, double kda) {

        super(match_id, account_id, player_slot, hero_id,
                level, item_0, item_1, item_2, item_3,
                item_4, item_5, kills, deaths, assists,
                hero_damage, tower_damage, hero_healing,
                last_hits, denies, gold, gold_per_min,
                gold_spent, xp_per_min, leaver_status,
                personaname, name, radiant_win, isRadiant);

        this.ability_upgrades_arr = ability_upgrades_arr;
        this.buyback_log = buyback_log;
        this.camps_stacked = camps_stacked;
        this.creeps_stacked = creeps_stacked;
        this.obs_placed = obs_placed;
        this.sen_placed = sen_placed;
        this.pings = pings;
        this.rune_pickups = rune_pickups;
        this.stuns = stuns;
        this.is_roaming = is_roaming;
        this.lane = lane;
        this.lane_role = lane_role;
        this.rank_tier = rank_tier;
        this.roshan_kills = roshan_kills;
        this.observer_kills = observer_kills;
        this.sentry_kills = sentry_kills;
        this.buyback_count = buyback_count;
        this.kills_per_min = kills_per_min;
        this.kda = kda;
    }
}
