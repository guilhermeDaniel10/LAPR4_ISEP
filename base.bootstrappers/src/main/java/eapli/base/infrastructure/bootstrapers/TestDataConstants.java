package eapli.base.infrastructure.bootstrapers;

import java.util.Calendar;

import eapli.framework.time.util.Calendars;

public final class TestDataConstants {

    public static final String[] BLACK = {"PRETO", "#000000"};
    public static final String[] RED = {"VERMELHO", "#ff0000"};
    public static final String[] GREEN = {"VERDE", "#00ff00"};
    public static final String[] YELLOW = {"AMARELO", "#ffff00"};
    public static final String[] BLUE = {"AZUL", "#0000ff"};
    public static final String[] PURPLE = {"ROXO", "#ff00ff"};
    public static final String[] CYAN = {"CYAN", "#00ffff"};
    public static final String[] WHITE = {"BRANCO", "#ffffff"};

    public static final String USER_TEST1 = "user1";

    @SuppressWarnings("squid:S2068")
    public static final String PASSWORD1 = "Password1";

    @SuppressWarnings("squid:S2885")
    public static final Calendar DATE_TO_BOOK = Calendars.of(2017, 12, 01);

    private TestDataConstants() {
        // ensure utility
    }
}
