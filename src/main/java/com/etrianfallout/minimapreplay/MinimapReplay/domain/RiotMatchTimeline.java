package com.etrianfallout.minimapreplay.MinimapReplay.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RiotMatchTimeline {
    private List<MatchFrame> frames;
    private long frameInterval;

    @Data
    private static class MatchFrame {
        private long timestamp;
        private Map<String, MatchParticipantFrame> participantFrames;
        private List<MatchEvent> events;
    }

    @Data
    private static class MatchParticipantFrame {
        private int totalGold;
        private int teamScore;
        private int participantId;
        private int level;
        private int currentGold;
        private int dominionScore;
        private MatchPosition position;
        private int xp;
        private int jungleMinionsKilled;
    }

    @Data
    private static class MatchEvent {
        private String eventType;
        private String towerType;
        private int teamId;
        private String ascendedType;
        private int killerId;
        private String levelUpType;
        private String pointCaptured;
        private int[] assistingParticipantIds;
        private String wardType;
        private String monsterType;
        private String type;
        private int skillSlot;
        private int victimId;
        private long timestamp;
        private int afterId;
        private String monsterSubType;
        private String laneType;
        private int itemId;
        private int participantId;
        private String buildType;
        private MatchPosition position;
        private int beforeId;
    }

    @Data
    private static class MatchPosition {
        private int x;
        private int y;
    }
}
