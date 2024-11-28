import javax.swing.*;
import java.awt.*;

public class FollowingScreen {
    private JFrame frame;

    public FollowingScreen() {
        // JFrame 설정
        frame = new JFrame("Following");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 800);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // 상단 바
        JPanel topBar = new JPanel();
        topBar.setBackground(Color.WHITE);
        topBar.setLayout(new BorderLayout());

        JButton backButton = new JButton("<");
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(e -> frame.dispose());
        topBar.add(backButton, BorderLayout.WEST);

        JLabel titleLabel = new JLabel("Following", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        topBar.add(titleLabel, BorderLayout.CENTER);

        frame.add(topBar, BorderLayout.NORTH);

        // 팔로잉 리스트
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(new Color(245, 245, 245)); // 배경색 설정

        for (int i = 0; i < 10; i++) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.X_AXIS));
            itemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            itemPanel.setBackground(Color.WHITE);

            JLabel iconLabel = new JLabel();
            iconLabel.setPreferredSize(new Dimension(40, 40));
            iconLabel.setOpaque(true);
            iconLabel.setBackground(Color.BLACK);
            itemPanel.add(iconLabel);

            itemPanel.add(Box.createRigidArea(new Dimension(8, 0)));

            JPanel textPanel = new JPanel();
            textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
            textPanel.setBackground(Color.WHITE);

            JLabel nicknameLabel = new JLabel("nickname" + i);
            nicknameLabel.setFont(new Font("Serif", Font.BOLD, 16));
            textPanel.add(nicknameLabel);

            JLabel idLabel = new JLabel("@id" + i);
            idLabel.setFont(new Font("Serif", Font.PLAIN, 14));
            textPanel.add(idLabel);

            itemPanel.add(textPanel);
            listPanel.add(itemPanel);
        }

        frame.add(new JScrollPane(listPanel), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FollowingScreen::new);
    }
}
