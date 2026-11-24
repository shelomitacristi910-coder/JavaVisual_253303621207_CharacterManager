package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;

public final class AppTheme {

    public static final Color WINDOW_BACKGROUND = new Color(245, 247, 250);
    public static final Color TEXT_COLOR = new Color(35, 40, 48);
    public static final Color MUTED_TEXT_COLOR = new Color(90, 98, 110);
    public static final Color GOLD_COLOR = new Color(176, 120, 0);

    public static final Font TITLE_FONT =
            new Font(Font.SANS_SERIF, Font.BOLD, 20);
    public static final Font BODY_FONT =
            new Font(Font.SANS_SERIF, Font.PLAIN, 14);
    public static final Font EMPHASIS_FONT =
            BODY_FONT.deriveFont(Font.BOLD);

    public static final Border WINDOW_BORDER =
            BorderFactory.createEmptyBorder(16, 16, 16, 16);
    public static final Border CARD_PADDING =
            BorderFactory.createEmptyBorder(10, 12, 10, 12);

    private static final Color WARRIOR_COLOR = new Color(255, 226, 218);
    private static final Color MAGE_COLOR = new Color(225, 232, 255);
    private static final Color ARCHER_COLOR = new Color(222, 243, 224);
    private static final Color HEALER_COLOR = new Color(255, 241, 199);
    private static final Color CARD_OUTLINE_COLOR = new Color(205, 211, 220);

    private AppTheme() {
    }

    public static Color colorFor(CharacterType type) {
        switch (type) {
            case WARRIOR:
                return WARRIOR_COLOR;
            case MAGE:
                return MAGE_COLOR;
            case ARCHER:
                return ARCHER_COLOR;
            case HEALER:
                return HEALER_COLOR;
            default:
                throw new IllegalArgumentException("Unsupported character type: " + type);
        }
    }

    public static Border cardBorderFor(CharacterType type) {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(colorFor(type), 2),
                CARD_PADDING);
    }

    public static Border cardBorder() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(CARD_OUTLINE_COLOR),
                CARD_PADDING);
    }
}
