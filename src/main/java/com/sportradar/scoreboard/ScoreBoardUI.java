package com.sportradar.scoreboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ScoreBoardUI extends JFrame {
    private ScoreBoard scoreBoard;
    private JTextField homeTeamField;
    private JTextField awayTeamField;
    private JButton addGameButton;
    private JButton finishGameButton;
    private JPanel liveGamesPanel;
    private JPanel rankingsPanel;

    public ScoreBoardUI() {
        scoreBoard = ScoreBoard.getInstance();
        setTitle("Scoreboard Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Game Management Panel
        JPanel gameManagementPanel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gameManagementPanel.add(new JLabel("Home Team:"), gbc);
        homeTeamField = new JTextField(10);
        gbc.gridx = 1;
        gameManagementPanel.add(homeTeamField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gameManagementPanel.add(new JLabel("Away Team:"), gbc);
        awayTeamField = new JTextField(10);
        gbc.gridx = 1;
        gameManagementPanel.add(awayTeamField, gbc);

        addGameButton = new JButton("Add Game");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gameManagementPanel.add(addGameButton, gbc);

        finishGameButton = new JButton("Finish Game");
        gbc.gridx = 1;
        gameManagementPanel.add(finishGameButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(gameManagementPanel, gbc);

        // Live Games Panel
        liveGamesPanel = new JPanel();
        liveGamesPanel.setLayout(new BoxLayout(liveGamesPanel, BoxLayout.Y_AXIS));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(liveGamesPanel), gbc);

        // Rankings Panel
        rankingsPanel = new JPanel();
        rankingsPanel.setLayout(new BoxLayout(rankingsPanel, BoxLayout.Y_AXIS));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(rankingsPanel), gbc);

        // Button Actions
        addGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String homeTeam = homeTeamField.getText();
                String awayTeam = awayTeamField.getText();
                if (!homeTeam.isEmpty() && !awayTeam.isEmpty()) {
                    scoreBoard.startGame(homeTeam, awayTeam);
                    homeTeamField.setText("");
                    awayTeamField.setText("");
                    refreshLiveGamesPanel();
                    refreshRankingsPanel();
                }
            }
        });

        finishGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String homeTeam = homeTeamField.getText();
                String awayTeam = awayTeamField.getText();
                if (!homeTeam.isEmpty() && !awayTeam.isEmpty()) {
                    scoreBoard.finishGame(homeTeam, awayTeam);
                    homeTeamField.setText("");
                    awayTeamField.setText("");
                    refreshLiveGamesPanel();
                    refreshRankingsPanel();
                }
            }
        });

        refreshLiveGamesPanel();
        refreshRankingsPanel();
    }

    private void refreshRankingsPanel() {
        rankingsPanel.removeAll();
        List<String> rankings = scoreBoard.getRankings();
        for (String ranking : rankings) {
            rankingsPanel.add(new JLabel(ranking));
        }
        rankingsPanel.revalidate();
        rankingsPanel.repaint();
    }

    private void refreshLiveGamesPanel() {
        liveGamesPanel.removeAll();
        List<Game> liveGames = scoreBoard.getSortedLiveGames();
        for (Game game : liveGames) {
            if (!game.isFinished()) {
                liveGamesPanel.add(createGamePanel(game));
            }
        }
        liveGamesPanel.revalidate();
        liveGamesPanel.repaint();
    }

    private JPanel createGamePanel(Game game) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel gameLabel = new JLabel(game.toString());
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(gameLabel, gbc);

        JTextField homeGoalsField = new JTextField(5);
        gbc.gridx = 1;
        panel.add(new JLabel("   Home Goals:"), gbc);
        gbc.gridx = 2;
        panel.add(homeGoalsField, gbc);

        JTextField awayGoalsField = new JTextField(5);
        gbc.gridx = 3;
        panel.add(new JLabel("Away Goals:"), gbc);
        gbc.gridx = 4;
        panel.add(awayGoalsField, gbc);

        JButton updateButton = new JButton("Update");
        gbc.gridx = 5;
        panel.add(updateButton, gbc);

        JButton addButton = new JButton("Add Goals");
        gbc.gridx = 6;
        panel.add(addButton, gbc);

        JButton finishButton = new JButton("Finish");
        gbc.gridx = 7;
        panel.add(finishButton, gbc);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int homeGoals = homeGoalsField.getText().isEmpty() ? 0 : Integer.parseInt(homeGoalsField.getText());
                int awayGoals = awayGoalsField.getText().isEmpty() ? 0 : Integer.parseInt(awayGoalsField.getText());
                scoreBoard.updateGoals(game.getHomeTeam().getName(), homeGoals, game.getAwayTeam().getName(), awayGoals);
                homeGoalsField.setText("");
                awayGoalsField.setText("");
                refreshLiveGamesPanel();
                refreshRankingsPanel();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int homeGoals = homeGoalsField.getText().isEmpty() ? 0 : Integer.parseInt(homeGoalsField.getText());
                int awayGoals = awayGoalsField.getText().isEmpty() ? 0 : Integer.parseInt(awayGoalsField.getText());
                scoreBoard.addGoals(game.getHomeTeam().getName(), homeGoals, game.getAwayTeam().getName(), awayGoals);
                homeGoalsField.setText("");
                awayGoalsField.setText("");
                refreshLiveGamesPanel();
                refreshRankingsPanel();
            }
        });

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scoreBoard.finishGame(game.getHomeTeam().getName(), game.getAwayTeam().getName());
                refreshLiveGamesPanel();
                refreshRankingsPanel();
            }
        });

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ScoreBoardUI ui = new ScoreBoardUI();
                ui.setVisible(true);
            }
        });
    }
}
