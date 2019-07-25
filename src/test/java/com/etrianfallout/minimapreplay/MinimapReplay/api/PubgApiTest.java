package com.etrianfallout.minimapreplay.MinimapReplay.api;

import com.etrianfallout.minimapreplay.MinimapReplay.domain.PubgMatch;
import com.etrianfallout.minimapreplay.MinimapReplay.domain.PubgMatchReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PubgApiTest {
    @Autowired
    private PubgApi pubgApi;

    @Test
    public void getMatchByName() {
        List<PubgMatch.Match> var = pubgApi.getMatchByName("HeavyRain", "steam");

        assert var != null
                && var.size() != 0;
    }

    @Test
    public void getMatchInfo() {
        String matchId = "c2cebe83-af2a-4193-b2e6-68c63c25812c";
        String platform = "steam";

        PubgMatchReference result = pubgApi.getMatchInfo(matchId, platform);

        assert result != null
                && result.getIncluded() != null
                && result.getData() != null;
    }
}
