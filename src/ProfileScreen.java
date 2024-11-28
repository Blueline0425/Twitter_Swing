import javax.swing.*;
import java.awt.*;

public class ProfileScreen {
    private JFrame frame;

    public ProfileScreen() {
        // JFrame 설정
        frame = new JFrame("Profile");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 800);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // 상단 바
        JPanel topBar = new JPanel();
        topBar.setBackground(new Color(128, 0, 128));
        JLabel titleLabel = new JLabel("Profile", JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        topBar.add(titleLabel);
        frame.add(topBar, BorderLayout.NORTH);

        // 중앙 내용
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 프로필 섹션
        JPanel profileSection = new JPanel();
        profileSection.setLayout(new BoxLayout(profileSection, BoxLayout.Y_AXIS));
        profileSection.setBackground(Color.LIGHT_GRAY);
        profileSection.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel profileLabel = new JLabel("한웅재 @woongjae2435");
        profileLabel.setFont(new Font("Serif", Font.BOLD, 18));
        profileSection.add(profileLabel);

        JPanel followPanel = new JPanel();
        followPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        followPanel.setBackground(Color.LIGHT_GRAY);

        JButton followingButton = new JButton("1 팔로잉");
        followingButton.setFont(new Font("Serif", Font.PLAIN, 14));
        followingButton.addActionListener(e -> {
            frame.dispose();
            new FollowingScreen();
        });
        followPanel.add(followingButton);

        JButton followerButton = new JButton("0 팔로워");
        followerButton.setFont(new Font("Serif", Font.PLAIN, 14));
        followerButton.addActionListener(e -> {
            frame.dispose();
            new FollowerScreen();
        });
        followPanel.add(followerButton);

        profileSection.add(followPanel);
        centerPanel.add(profileSection);

        // 게시글 리스트
        for (int i = 0; i < 3; i++) {
            JPanel postItem = new JPanel();
            postItem.setLayout(new BoxLayout(postItem, BoxLayout.Y_AXIS));
            postItem.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel nicknameLabel = new JLabel("Nickname " + i + " @username");
            nicknameLabel.setFont(new Font("Serif", Font.BOLD, 16));
            postItem.add(nicknameLabel);

            JLabel postContent = new JLabel("게시글 내용 " + i);
            postContent.setFont(new Font("Serif", Font.PLAIN, 14));
            postItem.add(postContent);

            JPanel actionPanel = new JPanel();
            actionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JButton commentButton = new JButton("댓글 수");
            actionPanel.add(commentButton);

            JButton likeButton = new JButton("좋아요 수");
            actionPanel.add(likeButton);

            postItem.add(actionPanel);
            centerPanel.add(postItem);
        }

        frame.add(new JScrollPane(centerPanel), BorderLayout.CENTER);

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
        dmButton.addActionListener(e -> {
            frame.dispose();
            new DMScreen();
        });
        bottomBar.add(dmButton);

        JButton profileButton = new JButton("Profile");
        bottomBar.add(profileButton);

        frame.add(bottomBar, BorderLayout.SOUTH);

        // 플로팅 버튼
        JButton addButton = new JButton("+");
        addButton.setFont(new Font("Serif", Font.BOLD, 18));
        addButton.setBackground(new Color(29, 161, 242));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setBorderPainted(false);
        addButton.setContentAreaFilled(false);
        addButton.setOpaque(true);
        addButton.setPreferredSize(new Dimension(30, 30));

        JLayeredPane layeredPane = frame.getLayeredPane();
        addButton.setBounds(400, 680, 45, 45);
        addButton.addActionListener(e -> {
            frame.dispose();
            new WritePostScreen();
        });
        layeredPane.add(addButton, JLayeredPane.PALETTE_LAYER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProfileScreen::new);
    }
}