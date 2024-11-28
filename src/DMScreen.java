import javax.swing.*;
import java.awt.*;

public class DMScreen {
    private JFrame frame;

    public DMScreen() {
        // JFrame 설정
        frame = new JFrame("DM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 800);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // 상단 바
        JPanel topBar = new JPanel();
        topBar.setBackground(Color.WHITE);
        topBar.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("DM, Chatting List", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        topBar.add(titleLabel, BorderLayout.CENTER);

        frame.add(topBar, BorderLayout.NORTH);

        // 채팅 리스트
        JPanel chatListPanel = new JPanel();
        chatListPanel.setLayout(new BoxLayout(chatListPanel, BoxLayout.Y_AXIS));
        chatListPanel.setBackground(new Color(245, 245, 245)); // 배경색 설정

        for (int i = 0; i < 30; i++) {
            JPanel chatItemPanel = new JPanel();
            chatItemPanel.setLayout(new BoxLayout(chatItemPanel, BoxLayout.X_AXIS));
            chatItemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            chatItemPanel.setBackground(Color.WHITE);

            JLabel iconLabel = new JLabel();
            iconLabel.setPreferredSize(new Dimension(40, 40));
            iconLabel.setOpaque(true);
            iconLabel.setBackground(Color.BLACK);
            chatItemPanel.add(iconLabel);

            chatItemPanel.add(Box.createRigidArea(new Dimension(8, 0)));

            JPanel textPanel = new JPanel();
            textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
            textPanel.setBackground(Color.WHITE);

            JLabel nicknameLabel = new JLabel("nickname" + i + " @id" + i);
            nicknameLabel.setFont(new Font("Serif", Font.BOLD, 16));
            textPanel.add(nicknameLabel);

            JLabel messageLabel = new JLabel(i % 2 == 0 ? "Hi" : "Yes");
            messageLabel.setFont(new Font("Serif", Font.PLAIN, 14));
            textPanel.add(messageLabel);

            chatItemPanel.add(textPanel);
            chatListPanel.add(chatItemPanel);
        }

        JScrollPane scrollPane = new JScrollPane(chatListPanel);
        frame.add(scrollPane, BorderLayout.CENTER);

        // 하단 바
        JPanel bottomBar = new JPanel();
        bottomBar.setLayout(new GridLayout(1, 4));
        bottomBar.setBackground(new Color(128, 0, 128));

        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(e -> {
            frame.dispose();
            new MainMenuScreen();
        });
        bottomBar.add(homeButton);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> {
            frame.dispose();
            new SearchScreen();
        });
        bottomBar.add(searchButton);

        JButton dmButton = new JButton("DM");
        bottomBar.add(dmButton);

        JButton profileButton = new JButton("Profile");
        profileButton.addActionListener(e -> {
            frame.dispose();
            new ProfileScreen();
        });
        bottomBar.add(profileButton);

        frame.add(bottomBar, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DMScreen::new);
    }
}
