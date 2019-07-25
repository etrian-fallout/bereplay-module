package com.etrianfallout.minimapreplay.MinimapReplay.service;

import com.etrianfallout.minimapreplay.MinimapReplay.api.PubgApi;
import com.etrianfallout.minimapreplay.MinimapReplay.domain.PubgMatch;
import com.etrianfallout.minimapreplay.MinimapReplay.domain.PubgMatchReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PubgService {
    @Autowired
    private PubgApi pubgApi;

    public List<PubgMatch.Match> getMatchByName(String playerName, String platform) {
        return pubgApi.getMatchByName(playerName, platform);
    }

    public PubgMatchReference getMatchInfo(String matchId, String platform) {
        return pubgApi.getMatchInfo(matchId, platform);
    }
}
