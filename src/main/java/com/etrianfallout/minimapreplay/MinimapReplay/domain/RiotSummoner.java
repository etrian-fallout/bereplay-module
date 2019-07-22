package com.etrianfallout.minimapreplay.MinimapReplay.domain;

import lombok.Data;

@Data
public class RiotSummoner {
    private int profileIcondId;
    private String name;
    private String puuid;
    private long summonerLevel;
    private long revisionDate;
    private String id;
    private String accountId;
}
