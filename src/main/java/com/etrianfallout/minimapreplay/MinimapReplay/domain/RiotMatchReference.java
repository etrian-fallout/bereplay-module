package com.etrianfallout.minimapreplay.MinimapReplay.domain;

import lombok.Data;

@Data
public class RiotMatchReference {
    private String lane;
    private long gameId;
    private int champion;
    private String platformId;
    private int season;
    private int queue;
    private String role;
    private long timestamp;
}
