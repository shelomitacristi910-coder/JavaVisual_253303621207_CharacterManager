package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    private final JPanel mainPanel;
    private final ArrayList<Character> characterList;

    public MainWindow(CharacterManager characterManager) {
        super("Character Manager v0.4");
        this.characterList = characterManager.getAllCharacters();
        this.mainPanel = new JPanel(new GridLayout(0, 1, 0, 8));

        initComponents();

        pack();
        setMinimumSize(new Dimension(420, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        mainPanel.setBackground(AppTheme.WINDOW_BACKGROUND);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        mainPanel.add(createTitleLabel());

        for (Character character : characterList) {
            mainPanel.add(createCharacterLabel(character));
        }

        add(mainPanel);
    }

    private JLabel createTitleLabel() {
        JLabel label = new JLabel(
                "Daftar Karakter (" + characterList.size() + ")",
                SwingConstants.CENTER);
        label.setFont(AppTheme.TITLE_FONT);
        label.setForeground(AppTheme.TEXT_COLOR);
        return label;
    }

    private JLabel createCharacterLabel(Character character) {
        String info = character.getName() + " | " + character.getType()
                + " | Lv." + character.getLevel()
                + " | HP:" + character.getHitPoints()
                + " | ATK:" + character.getAttackPower();

        JLabel label = new JLabel(info);
        label.setFont(AppTheme.BODY_FONT);
        label.setForeground(AppTheme.TEXT_COLOR);
        label.setBackground(AppTheme.colorFor(character.getType()));
        label.setOpaque(true);
        label.setBorder(AppTheme.cardBorderFor(character.getType()));
        label.setToolTipText(
                "HP: " + character.getHitPoints()
                        + " | ATK: " + character.getAttackPower()
                        + " | Mana: " + character.getMana());
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return label;
    }
}
