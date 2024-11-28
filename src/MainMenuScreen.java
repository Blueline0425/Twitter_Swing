import javax.swing.*;
import java.awt.*;

public class MainMenuScreen {
    private JFrame frame;

    public MainMenuScreen() {
        // JFrame 설정
        frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 800);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // 상단 바
        JPanel topBar = new JPanel();
        topBar.setBackground(new Color(128, 0, 128));
        JLabel titleLabel = new JLabel("Main Menu", JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        topBar.add(titleLabel);
        frame.add(topBar, BorderLayout.NORTH);

        // 중앙 내용 (게시글 리스트 표시)
        JTextArea postList = new JTextArea("게시글 리스트 표시");
        postList.setEditable(false);
        postList.setLineWrap(true);
        postList.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(postList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
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
        dmButton.addActionListener(e -> {
            frame.dispose();
            new DMScreen();
        });
        bottomBar.add(dmButton);

        JButton profileButton = new JButton("Profile");
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
        SwingUtilities.invokeLater(MainMenuScreen::new);
    }
}
