package com.etrianfallout.minimapreplay.MinimapReplay.domain;

import lombok.Data;

import java.util.List;

@Data
public class RiotMatch {
    private int seasonId;
    private int queueId;
    private long gameId;
    private String gameVersion;
    private String platformId;
    private String gameMode;
    private int mapId;
    private String gameType;
    private long gameDuration;
    private long gameCreation;

    private List<ParticipantIdentity> participantIdentities;
    private List<TeamStats> teams;

    @Data
    private static class ParticipantIdentity {
        private int participantId;
        private Player player;
    }

    @Data
    private static class Player {
        private String currentPlatformId;
        private String summonerName;
        private String platformId;
        private String currentAccountId;
        private int profileIcon;
        private String summonerId;
        private String accountId;
    }

    @Data
    private static class TeamStats {
        private boolean firstDragon;
        private boolean firstInhibitor;
        private List<TeamBans> bans;
        private int baronKills;
        private boolean firstRiftHerald;
        private boolean firstBaron;
        private int riftHeraldKills;
        private boolean firstBlood;
        private int teamId;
        private boolean firstTower;
        private int vilemawKills;
        private int inhibitorKills;
        private int towerKills;
        private int dominionVictoryScore;
        private String win;
        private int dragonKills;
    }

    @Data
    private static class TeamBans {
        private int pickTurn;
        private int championId;
    }
}
