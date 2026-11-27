package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    private final ArrayList<Character> characterList;

    public MainWindow(CharacterManager characterManager) {
        super("Character Manager v0.5");
        this.characterList = characterManager.getAllCharacters();

        initComponents();

        pack();
        setMinimumSize(new Dimension(560, 380));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        getContentPane().setBackground(AppTheme.WINDOW_BACKGROUND);
        setLayout(new BorderLayout());

        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createListArea(), BorderLayout.CENTER);
        add(createLegendPanel(), BorderLayout.EAST);
        add(createStatusPanel(), BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(AppTheme.WINDOW_BACKGROUND);
        header.setBorder(BorderFactory.createEmptyBorder(16, 16, 8, 16));

        JLabel title = new JLabel("Character Manager");
        title.setFont(AppTheme.TITLE_FONT);
        title.setForeground(AppTheme.TEXT_COLOR);

        JLabel count = new JLabel(characterList.size() + " karakter");
        count.setFont(AppTheme.BODY_FONT);
        count.setForeground(AppTheme.GOLD_COLOR);

        header.add(title, BorderLayout.WEST);
        header.add(count, BorderLayout.EAST);
        return header;
    }

    private JScrollPane createListArea() {
        JPanel cards = new JPanel(new GridLayout(0, 1, 0, 8));
        cards.setBackground(AppTheme.WINDOW_BACKGROUND);
        for (Character character : characterList) {
            cards.add(createCharacterLabel(character));
        }

        JPanel holder = new JPanel(new BorderLayout());
        holder.setBackground(AppTheme.WINDOW_BACKGROUND);
        holder.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 8));
        holder.add(cards, BorderLayout.NORTH);

        JScrollPane scroll = new JScrollPane(holder);
        scroll.setBorder(null);
        scroll.getViewport().setBackground(AppTheme.WINDOW_BACKGROUND);
        scroll.setPreferredSize(new Dimension(460, 280));
        return scroll;
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

    private JPanel createLegendPanel() {
        JPanel legend = new JPanel();
        legend.setLayout(new BoxLayout(legend, BoxLayout.Y_AXIS));
        legend.setBackground(AppTheme.WINDOW_BACKGROUND);
        legend.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 16));

        JLabel heading = new JLabel("Legenda Role");
        heading.setFont(AppTheme.BODY_FONT.deriveFont(Font.BOLD));
        heading.setForeground(AppTheme.TEXT_COLOR);
        legend.add(heading);
        legend.add(Box.createVerticalStrut(8));

        for (CharacterType type : CharacterType.values()) {
            JLabel chip = new JLabel(type.name());
            chip.setOpaque(true);
            chip.setBackground(AppTheme.colorFor(type));
            chip.setForeground(AppTheme.TEXT_COLOR);
            chip.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
            chip.setBorder(AppTheme.cardBorderFor(type));
            chip.setToolTipText("Peran karakter: " + type);
            legend.add(chip);
            legend.add(Box.createVerticalStrut(6));
        }
        legend.add(Box.createVerticalGlue());
        return legend;
    }

    private JPanel createStatusPanel() {
        JPanel status = new JPanel(new FlowLayout(FlowLayout.LEFT, 16, 6));
        status.setBackground(AppTheme.WINDOW_BACKGROUND);

        JLabel label = new JLabel(
                "Total: " + characterList.size() + " karakter  |  Siap");
        label.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        label.setForeground(AppTheme.MUTED_TEXT_COLOR);
        status.add(label);
        return status;
    }
}
