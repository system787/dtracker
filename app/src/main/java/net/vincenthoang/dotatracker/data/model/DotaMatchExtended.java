package net.vincenthoang.dotatracker.data.model;

/**
 * Created by vincenthoang on 12/10/17.
 */

public class DotaMatchExtended extends DotaMatch {
    private MatchChatMessage[] chat;
    private MatchDraftTiming[] draft_timings;
    private int engine;
    private int first_blood_time;
}
