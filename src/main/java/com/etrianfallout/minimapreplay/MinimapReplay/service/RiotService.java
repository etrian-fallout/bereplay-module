package com.etrianfallout.minimapreplay.MinimapReplay.service;

import com.etrianfallout.minimapreplay.MinimapReplay.api.RiotApi;
import com.etrianfallout.minimapreplay.MinimapReplay.domain.RiotMatch;
import com.etrianfallout.minimapreplay.MinimapReplay.domain.RiotMatchTimeline;
import com.etrianfallout.minimapreplay.MinimapReplay.domain.RiotMatchlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiotService {

    @Autowired
    private RiotApi riotApi;

    public String getEncryptedAccountIdByName(String summonerName) {
        return riotApi.getSummonerByName(summonerName).getAccountId();
    }

    public RiotMatchlist getMatchlistsByAccountId(String encryptedAccountId) {
        return riotApi.getMatchlistsByAccountId(encryptedAccountId);
    }

    public RiotMatch getMatchByMatchId(String matchId) {
        return riotApi.getMatchByMatchId(matchId);
    }

    public RiotMatchTimeline getTimelineByMatchid(String matchId) {
        return riotApi.getTimelineByMatchId(matchId);
    }
}
