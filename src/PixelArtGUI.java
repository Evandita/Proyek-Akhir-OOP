import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class PixelArtGUI extends JFrame {
    private JButton increaseButton;
    private JLabel textLabel;
    private int fontSize = 12; // Initial font size

    public PixelArtGUI() {
        setTitle("Pixel Art GUI");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        increaseButton = new JButton("Increase Text Size");
        textLabel = new JLabel("Hello, Pixel Art!");

        // Set layout
        setLayout(new GridLayout(2, 1));

        // Add components to the frame
        add(textLabel);
        add(increaseButton);

        // Set pixel art font
        Font pixelArtFont = new Font("PixelArt", Font.PLAIN, fontSize);
        textLabel.setFont(pixelArtFont);

        // Add action listener to the button
        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontSize += 2; // Increase font size by 2
                Font updatedFont = new Font("PixelArt", Font.PLAIN, fontSize);
                textLabel.setFont(updatedFont);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PixelArtGUI().setVisible(true);
            }
        });
    }
}
