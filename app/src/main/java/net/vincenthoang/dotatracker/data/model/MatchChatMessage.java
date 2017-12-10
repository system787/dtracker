package net.vincenthoang.dotatracker.data.model;

/**
 * Created by vincenthoang on 12/10/17.
 */

public class MatchChatMessage {
    private int time;
    private String unit;
    private String key;
    private int slot;
    private int player_slot;

    public MatchChatMessage(int time, String unit, String key, int slot, int player_slot) {
        this.time = time;
        this.unit = unit;
        this.key = key;
        this.slot = slot;
        this.player_slot = player_slot;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getPlayer_slot() {
        return player_slot;
    }

    public void setPlayer_slot(int player_slot) {
        this.player_slot = player_slot;
    }
}