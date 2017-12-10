package net.vincenthoang.dotatracker.data.model;

/**
 * Created by vincenthoang on 12/10/17.
 */

public class SteamProfile {
    private long account_id;
    private String personaname;
    private String name;
    private int cheese;
    private String steamid;
    private String avatar;
    private String avatarmedium;
    private String avatarfull;
    private String profileurl;
    private String last_login;
    private String loccountrycode;

    public SteamProfile(long account_id, String personaname, String name, int cheese, String steamid, String avatar, String avatarmedium, String avatarfull, String profileurl, String last_login, String loccountrycode) {
        this.account_id = account_id;
        this.personaname = personaname;
        this.name = name;
        this.cheese = cheese;
        this.steamid = steamid;
        this.avatar = avatar;
        this.avatarmedium = avatarmedium;
        this.avatarfull = avatarfull;
        this.profileurl = profileurl;
        this.last_login = last_login;
        this.loccountrycode = loccountrycode;
    }

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public String getPersonaname() {
        return personaname;
    }

    public void setPersonaname(String personaname) {
        this.personaname = personaname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCheese() {
        return cheese;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }

    public String getSteamid() {
        return steamid;
    }

    public void setSteamid(String steamid) {
        this.steamid = steamid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarmedium() {
        return avatarmedium;
    }

    public void setAvatarmedium(String avatarmedium) {
        this.avatarmedium = avatarmedium;
    }

    public String getAvatarfull() {
        return avatarfull;
    }

    public void setAvatarfull(String avatarfull) {
        this.avatarfull = avatarfull;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public String getLoccountrycode() {
        return loccountrycode;
    }

    public void setLoccountrycode(String loccountrycode) {
        this.loccountrycode = loccountrycode;
    }
}
