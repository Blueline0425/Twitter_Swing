import javax.swing.*;
import java.awt.*;

public class SearchScreen {
    private JFrame frame;

    public SearchScreen() {
        // JFrame 설정
        frame = new JFrame("검색");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 800);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // 상단 바
        JPanel topBar = new JPanel();
        topBar.setBackground(new Color(98, 0, 238)); // 보라색
        JLabel titleLabel = new JLabel("검색", JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        topBar.add(titleLabel);
        frame.add(topBar, BorderLayout.NORTH);

        // 중앙 내용
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 검색 입력창
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(400, 30));
        searchField.setMaximumSize(new Dimension(400, 30));
        searchField.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(searchField);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // 게시물 리스트
        for (int i = 0; i < 7; i++) {
            JPanel postItem = new JPanel();
            postItem.setLayout(new BoxLayout(postItem, BoxLayout.Y_AXIS));
            postItem.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            postItem.setBackground(Color.WHITE);
            postItem.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel nicknameLabel = new JLabel("nickname" + i + " @id" + i);
            nicknameLabel.setFont(new Font("Serif", Font.BOLD, 16));
            postItem.add(nicknameLabel);

            JLabel postContent = new JLabel("text field " + i);
            postContent.setFont(new Font("Serif", Font.PLAIN, 14));
            postItem.add(postContent);

            JPanel actionPanel = new JPanel();
            actionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JButton commentButton = new JButton("댓글 수");
            commentButton.setForeground(Color.BLUE);
            actionPanel.add(commentButton);

            JButton likeButton = new JButton("좋아요 수");
            likeButton.setForeground(Color.BLUE);
            actionPanel.add(likeButton);

            postItem.add(actionPanel);
            centerPanel.add(postItem);
            centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        frame.add(new JScrollPane(centerPanel), BorderLayout.CENTER);

        // 하단 바
        JPanel bottomBar = new JPanel();
        bottomBar.setLayout(new GridLayout(1, 4));
        bottomBar.setBackground(new Color(98, 0, 238));

        JButton homeButton = new JButton("Home");
        homeButton.setForeground(Color.WHITE);
        homeButton.addActionListener(e -> {
            frame.dispose();
            new MainMenuScreen();
        });
        bottomBar.add(homeButton);

        JButton searchButton = new JButton("Search");
        searchButton.setForeground(Color.WHITE);
        bottomBar.add(searchButton);

        JButton dmButton = new JButton("DM");
        dmButton.setForeground(Color.WHITE);
        dmButton.addActionListener(e -> {
            frame.dispose();
            new DMScreen();
        });
        bottomBar.add(dmButton);

        JButton profileButton = new JButton("Profile");
        profileButton.setForeground(Color.WHITE);
        profileButton.addActionListener(e -> {
            frame.dispose();
            new ProfileScreen();
        });
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
        SwingUtilities.invokeLater(SearchScreen::new);
    }
}
