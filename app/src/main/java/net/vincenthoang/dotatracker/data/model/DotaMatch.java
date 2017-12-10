package net.vincenthoang.dotatracker.data.model;

/**
 * Created by vincenthoang on 12/10/17.
 */

public class DotaMatch {
    private long match_id;
    private int barracks_status_dire;
    private int barracks_status_radiant;
    private MatchChatMessage[] chat;
    private int cluster;
    private MatchDraftTiming[] draft_timings;
    private int duration;
    private int engine;
    private int first_blood_time;
    private int game_mode;
    private int human_players;
    private int leagueid;
    private int lobby_type;
    private long match_seq_num;
    private int negative_votes;
    private int positive_votes;
    
}
