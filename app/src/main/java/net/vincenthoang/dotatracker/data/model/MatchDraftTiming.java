package net.vincenthoang.dotatracker.data.model;

/**
 * Created by vincenthoang on 12/10/17.
 */

public class MatchDraftTiming {
    int order;
    boolean pick;
    int active_team;
    int hero_id;
    int player_slot;
    int extra_time;
    int total_time_taken;

    public MatchDraftTiming(int order, boolean pick, int active_team, int hero_id, int player_slot, int extra_time, int total_time_taken) {
        this.order = order;
        this.pick = pick;
        this.active_team = active_team;
        this.hero_id = hero_id;
        this.player_slot = player_slot;
        this.extra_time = extra_time;
        this.total_time_taken = total_time_taken;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isPick() {
        return pick;
    }

    public void setPick(boolean pick) {
        this.pick = pick;
    }

    public int getActive_team() {
        return active_team;
    }

    public void setActive_team(int active_team) {
        this.active_team = active_team;
    }

    public int getHero_id() {
        return hero_id;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    public int getPlayer_slot() {
        return player_slot;
    }

    public void setPlayer_slot(int player_slot) {
        this.player_slot = player_slot;
    }

    public int getExtra_time() {
        return extra_time;
    }

    public void setExtra_time(int extra_time) {
        this.extra_time = extra_time;
    }

    public int getTotal_time_taken() {
        return total_time_taken;
    }

    public void setTotal_time_taken(int total_time_taken) {
        this.total_time_taken = total_time_taken;
    }
}
