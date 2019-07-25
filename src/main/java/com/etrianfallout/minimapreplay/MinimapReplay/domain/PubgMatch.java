package com.etrianfallout.minimapreplay.MinimapReplay.domain;

import lombok.Data;

import java.util.List;

@Data
public class PubgMatch {

    private List<PlayerData> data;

    @Data
    public static class PlayerData {
        private String id;
        private MatchRelationships relationships;
    }

    @Data
    public static class MatchRelationships {
        private MatchData matches;
    }

    @Data
    public static class MatchData {
        private List<Match> data;
    }

    @Data
    public static class Match {
        private String id;
    }
}
