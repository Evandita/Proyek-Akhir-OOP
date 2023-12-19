package ClickerGame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView extends JFrame {
    
    public static Game Data;

    public GameView() {
        // Set up the JFrame
        setTitle("Clicker Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use GridLayout to arrange components in equal-sized cells
        setLayout(new GridLayout(1, 3));

        // Create and add three portrait containers with borders and background colors
        add(createMissionContainer());
        add(createClickerContainer());
        add(createItemContainer());

        // Set the initial size of the JFrame to full screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Pack the JFrame to ensure proper layout
        pack();
        setLocationRelativeTo(null); // Center the JFrame on the screen
    }

    private JPanel createMissionContainer() {
        JPanel missionContainer = new JPanel();
        missionContainer.setLayout(new BorderLayout());
        
        // Border for the mission container
        Border missionBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
        missionContainer.setBorder(missionBorder);
        missionContainer.setBackground(new Color(255, 200, 200)); // Light red background
        
        // Create a panel to hold questLabel and hintLabel vertically
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(new Color(255, 200, 200)); // Light red background
        
        // Quest Title
        JLabel questLabel = new JLabel("Quests");
        questLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        questLabel.setBorder(BorderFactory.createEmptyBorder(80, 0, 10, 0)); // Add extra space from the top
        questLabel.setFont(questLabel.getFont().deriveFont(Font.BOLD, 40)); // Bold and bigger font

        // Hint Text
        JLabel hintLabel = new JLabel("Hint: Complete quests to progress in the game.");
        hintLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //Level Title
        JLabel levelLabel = new JLabel("Level " + Data.getRenown() + ": " + Data.getRenownName());
        levelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        levelLabel.setBorder(BorderFactory.createEmptyBorder(40, 0, 10, 0)); // Add extra space from the top
        levelLabel.setFont(levelLabel.getFont().deriveFont(Font.BOLD, 30)); // Bold and bigger font

        // Add the quest and hint labels to the titlePanel
        titlePanel.add(questLabel);
        titlePanel.add(hintLabel);
        titlePanel.add(levelLabel);

        // Add a panel for quests
        JPanel questPanel = new JPanel();
        questPanel.setLayout(new BoxLayout(questPanel, BoxLayout.Y_AXIS));
        questPanel.setBackground(new Color(255, 200, 200)); // Light red background
        
        //Quests Text
        JLabel quest1Label = new JLabel("1. Get " + Quests.quest_points + " points! (" + Data.getCummulativePoints() + "/" + Quests.quest_points + ")");
        quest1Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        quest1Label.setFont(quest1Label.getFont().deriveFont(Font.BOLD, 20));

        JLabel quest2Label = new JLabel("2. Click " + Quests.quest_click + " times! (" + Data.getTotalClicks() + "/" + Quests.quest_click + ")");
        quest2Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        quest2Label.setFont(quest2Label.getFont().deriveFont(Font.BOLD, 20));

        JLabel quest3Label = new JLabel("3. Buy " + Quests.quest_item + " Items! (" + Data.getTotalItems() + "/" + Quests.quest_item + ")");
        quest3Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        quest3Label.setFont(quest3Label.getFont().deriveFont(Font.BOLD, 20));

        // Add quest labels to the panel
        questPanel.add(quest1Label);
        questPanel.add(quest2Label);
        questPanel.add(quest3Label);

        // Add a panel for buttons at the bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(255, 200, 200)); // Light red background
    
        // Add a Save button with the same background color as the container
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameController.save("src\\data\\test.txt", Data);
            }
        });
        buttonPanel.add(saveButton);
    
        // Add a New Game button
        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data.setPoints(0);
                Data.setPointsPerClick(1);
                Data.setPointsPerClickMultiplier(1);
                Data.setCummulativePoints(0);
                Data.setTotalClicks(0);
                Data.setTotalItems(0);
                Data.setRenown(0);
                GameController.save("src\\data\\test.txt", Data);
                updatePointsDisplay();
                updatePointsPerClickDisplay();
                updateQuestsDisplay();
            }
        });
        buttonPanel.add(newGameButton);
        
        // Add the titlePanel to the missionContainer at the top
        missionContainer.add(titlePanel, BorderLayout.NORTH);

        // Add the questPanel to the missionContainer at the center
        missionContainer.add(questPanel);

        // Add the button panel to the mission container at the bottom
        missionContainer.add(buttonPanel, BorderLayout.SOUTH);
    
        return missionContainer;
    }
    
    
    

    private JPanel createClickerContainer() {
        JPanel clickerContainer = new JPanel();
        clickerContainer.setLayout(new BoxLayout(clickerContainer, BoxLayout.Y_AXIS));
        clickerContainer.setBackground(new Color(230, 255, 230)); // Light green background
    
        // Border for the clicker container
        Border clickerBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
        clickerContainer.setBorder(clickerBorder);
    
        // Total points label with extra space from the top, bold, and bigger font
        JLabel totalPointsLabel = new JLabel("Total Points: " + Data.getPoints());
        totalPointsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        totalPointsLabel.setBorder(BorderFactory.createEmptyBorder(80, 0, 10, 0)); // Add extra space from the top
        totalPointsLabel.setFont(totalPointsLabel.getFont().deriveFont(Font.BOLD, 40)); // Bold and bigger font
    
        // Clicker button
        JButton clickerButton = new JButton("Click Me!");
        clickerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        clickerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameController.click();
                updatePointsDisplay();

                if (GameController.questRequirements()) {
                    GameController.levelUp();
                    Quests.updateQuests(Data.getRenown());
                }

                updateQuestsDisplay();
            }
        });
    
        // Points per click label
        JLabel pointsPerClickLabel = new JLabel("Points per Click: " + Data.getPointsPerClick());
        pointsPerClickLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        clickerContainer.add(totalPointsLabel);
        clickerContainer.add(Box.createVerticalGlue()); // Adds space between total points and clicker button
        clickerContainer.add(clickerButton);
        clickerContainer.add(pointsPerClickLabel);
    
        return clickerContainer;
    }

    private JPanel createItemContainer() {
        JPanel itemContainer = new JPanel();
        itemContainer.setLayout(new BoxLayout(itemContainer, BoxLayout.Y_AXIS));
        itemContainer.setBackground(new Color(230, 230, 255)); // Light blue background

        // Border for the item container
        Border itemBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
        itemContainer.setBorder(itemBorder);

        // Shop Title
        JLabel shopLabel = new JLabel("Shop");
        shopLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        shopLabel.setBorder(BorderFactory.createEmptyBorder(80, 0, 10, 0)); // Add extra space from the top
        shopLabel.setFont(shopLabel.getFont().deriveFont(Font.BOLD, 40)); // Bold and bigger font

        //Create Shop
        itemContainer.add(shopLabel);
        for (Item i : Data.shopItems) {
            addItem(itemContainer, i.getName(), i.getPrice(), i.getPointsIncrease());
        }
    

        return itemContainer;
    }

    private void addItem(JPanel container, String itemName, int itemPrice, int pointsIncrease) {
        JButton itemButton = new JButton("<html>" + itemName + "<br><br>Price: " + itemPrice + "<br>Points Per Click: " + pointsIncrease + "</html>");
        itemButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Data.getPoints() >= itemPrice) {
                    GameController.buyItem(itemPrice);
                    GameController.addPointsPerClick(pointsIncrease);
                    updatePointsDisplay();
                    updatePointsPerClickDisplay();
                    
                    if (GameController.questRequirements()) {
                        GameController.levelUp();
                        Quests.updateQuests(Data.getRenown());
                    }

                    updateQuestsDisplay();
                } else {
                    JOptionPane.showMessageDialog(null, "Not enough points to purchase " + itemName, "Insufficient Points", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        container.add(itemButton);
    }

    private void updatePointsDisplay() {
        ((JLabel) ((JPanel) getContentPane().getComponent(1)).getComponent(0)).setText("Total Points: " + Data.getPoints());
    }

    private void updatePointsPerClickDisplay() {
        ((JLabel) ((JPanel) getContentPane().getComponent(1)).getComponent(3)).setText("Points per Click: " + Data.getPointsPerClick());
    }

    private void updateQuestsDisplay() {
        ((JLabel)((JPanel) ((JPanel) getContentPane().getComponent(0)).getComponent(0)).getComponent(2)).setText("Level " + Data.getRenown() + ": " + Data.getRenownName());
        ((JLabel)((JPanel) ((JPanel) getContentPane().getComponent(0)).getComponent(1)).getComponent(0)).setText("1. Get " + Quests.quest_points + " points! (" + Data.getCummulativePoints() + "/" + Quests.quest_points + ")");
        ((JLabel)((JPanel) ((JPanel) getContentPane().getComponent(0)).getComponent(1)).getComponent(1)).setText("2. Click " + Quests.quest_click + " times! (" + Data.getTotalClicks() + "/" + Quests.quest_click + ")");
        ((JLabel)((JPanel) ((JPanel) getContentPane().getComponent(0)).getComponent(1)).getComponent(2)).setText("3. Buy " + Quests.quest_item + " Items! (" + Data.getTotalItems() + "/" + Quests.quest_item + ")");
    }

    

    public static void main(String[] args) {
        
        //Load saved data to game
        Data = Game.getInstance();
        GameController.load("src\\data\\test.txt", Data);
        Quests.updateQuests(Data.getRenown());

        SwingUtilities.invokeLater(() -> {
            GameView game = new GameView();
            game.setVisible(true);
        });
    }
}
