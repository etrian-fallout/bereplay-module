package com.etrianfallout.minimapreplay.MinimapReplay.api;

import com.etrianfallout.minimapreplay.MinimapReplay.domain.PubgMatch;
import com.etrianfallout.minimapreplay.MinimapReplay.domain.PubgMatchReference;
import com.google.gson.Gson;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PubgApi {
    private final String apiKey = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJkMTZiOWQ2MC04Z" +
            "TkzLTAxMzctYmNhNi0zOTE0OTdlOTY2MmYiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNTYzNzg4OTI0LC" +
            "JwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6InpleHl6LW5hdmVyLWNvIn0.BCsS4TQdc0WkX" +
            "LVZ5Oh8TtpXvucy33AFnnAgg7gCHMs";

    private final String requestUrl = "api.pubg.com";
    private final String PLAYER_URL = "players";
    private final String MATCH_URL = "matches";

    public List<PubgMatch.Match> getMatchByName(String playerName, String platform) {
        OkHttpClient client = new OkHttpClient();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https").host(requestUrl)
                .addPathSegment("shards").addPathSegment(platform).addPathSegment(PLAYER_URL)
                .addQueryParameter("filter[playerNames]", playerName)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("Accept", "application/vnd.api+json")
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try {
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            PubgMatch match = gson.fromJson(response.body().string(), PubgMatch.class);
            List<PubgMatch.Match> data = match.getData().get(0)
                    .getRelationships().getMatches().getData();

            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public PubgMatchReference getMatchInfo(String matchId, String platform) {
        OkHttpClient client = new OkHttpClient();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https").host(requestUrl)
                .addPathSegment("shards").addPathSegment(platform).addPathSegment(MATCH_URL).addPathSegment(matchId)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("Accept", "application/vnd.api+json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            PubgMatchReference match = gson.fromJson(response.body().string(), PubgMatchReference.class);
            match.setIncluded(match.getIncluded()
                    .stream()
                    .filter(x -> x.getType().equals("asset"))
                    .collect(Collectors.toList()));

            return match;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
