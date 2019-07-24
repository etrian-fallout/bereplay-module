package com.etrianfallout.minimapreplay.MinimapReplay.domain;

import lombok.Data;

@Data
public class PubgTelemetry {
    private String _D;
    private String _T;
    private PubgCharacter character;
    int elapsedTime;
}
