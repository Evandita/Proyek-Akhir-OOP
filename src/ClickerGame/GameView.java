package ClickerGame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView extends JFrame {
    
    private int level = 0;
    private int totalPoints = 0;
    private int pointsPerClick = 1;

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
    
        // Quest text with a light red background
        JLabel questLabel = new JLabel("Hint: Click the button to earn points!\nComplete quests to progress in the game.");
        questLabel.setBorder(BorderFactory.createEmptyBorder(40, 20, 10, 0)); // Add extra space from the top
        questLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        // Border for the mission container
        Border missionBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
        missionContainer.setBorder(missionBorder);
        missionContainer.setBackground(new Color(255, 200, 200)); // Light red background
    
        // Add the quest text to the mission container at the top
        missionContainer.add(questLabel, BorderLayout.NORTH);
    
        // Add a panel for buttons at the bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(255, 200, 200)); // Light red background
    
        // Add a Save button with the same background color as the container
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add the logic to save the mission data
                // For example, you can save it to a file or a database
                // Implement your save logic here
                System.out.println("Mission data saved!");
            }
        });
        buttonPanel.add(saveButton);
    
        // Add a New Game button
        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add the logic to start a new game
                // Implement your new game logic here
                System.out.println("Starting a new game!");
            }
        });
        buttonPanel.add(newGameButton);
    
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
        JLabel totalPointsLabel = new JLabel("Total Points: " + totalPoints);
        totalPointsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        totalPointsLabel.setBorder(BorderFactory.createEmptyBorder(80, 0, 10, 0)); // Add extra space from the top
        totalPointsLabel.setFont(totalPointsLabel.getFont().deriveFont(Font.BOLD, 30)); // Bold and bigger font
    
        // Clicker button
        JButton clickerButton = new JButton("Click Me!");
        clickerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        clickerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalPoints += pointsPerClick;
                updatePointsDisplay();
            }
        });
    
        // Points per click label
        JLabel pointsPerClickLabel = new JLabel("Points per Click: " + pointsPerClick);
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

        // Example items
        addItem(itemContainer, "Item 1", 10, 2);
        addItem(itemContainer, "Item 2", 25, 5);
        addItem(itemContainer, "Item 3", 50, 10);

        return itemContainer;
    }

    private void addItem(JPanel container, String itemName, int itemPrice, int pointsIncrease) {
        JButton itemButton = new JButton(itemName + " - Price: " + itemPrice);
        itemButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (totalPoints >= itemPrice) {
                    totalPoints -= itemPrice;
                    pointsPerClick += pointsIncrease;
                    updatePointsDisplay();
                    updatePointsPerClickDisplay();
                } else {
                    JOptionPane.showMessageDialog(null, "Not enough points to purchase " + itemName, "Insufficient Points", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        container.add(itemButton);
    }

    private void updatePointsDisplay() {
        ((JLabel) ((JPanel) getContentPane().getComponent(1)).getComponent(0)).setText("Total Points: " + totalPoints);
    }

    private void updatePointsPerClickDisplay() {
        ((JLabel) ((JPanel) getContentPane().getComponent(1)).getComponent(3)).setText("Points per Click: " + pointsPerClick);
    }

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameView game = new GameView();
            game.setVisible(true);
        });
    }
}
