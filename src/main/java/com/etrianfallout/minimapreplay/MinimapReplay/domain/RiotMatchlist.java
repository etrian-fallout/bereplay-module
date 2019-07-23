package com.etrianfallout.minimapreplay.MinimapReplay.domain;

import lombok.Data;

import java.util.List;

@Data
public class RiotMatchlist {
    private List<RiotMatchReference> matches;
    private int totalGames;
    private int startIndex;
    private int endIndex;
}
