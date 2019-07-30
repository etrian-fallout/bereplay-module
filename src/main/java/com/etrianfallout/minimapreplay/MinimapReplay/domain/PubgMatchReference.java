package com.etrianfallout.minimapreplay.MinimapReplay.domain;

import lombok.Data;

import java.util.List;

@Data
public class PubgMatchReference {

    private MatchObject data;
    private List<IncludedObject> included;

    @Data
    public static class MatchObject {
        private DataAttributes attributes;
    }

    @Data
    public static class DataAttributes {
        private String createdAt;
        private int duration;
        private String gameMode;
        private String mapName;
    }

    @Data
    public static class IncludedObject {
        private String type;
        private IncludeAttributes attributes;
    }

    @Data
    public static class IncludeAttributes {
        private String createdAt;
        private String URL;
        private Stats stats;
    }

    @Data
    private static class Stats {
        private int kills;
        private int winPlace;
        private String name;
    }
}

