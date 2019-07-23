package com.etrianfallout.minimapreplay.MinimapReplay.service;

import com.etrianfallout.minimapreplay.MinimapReplay.api.RiotApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiotService {

    @Autowired
    private RiotApi riotApi;

    public String getEncryptedAccountIdByName(String summonerName) {
        return riotApi.getSummonerByName(summonerName).getAccountId();
    }
}
