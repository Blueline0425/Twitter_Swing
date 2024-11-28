import javax.swing.*;
import java.awt.*;

public class WritePostScreen {
    private JFrame frame;

    public WritePostScreen() {
        // JFrame 설정
        frame = new JFrame("Write a Post");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 800);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // 상단 바
        JPanel topBar = new JPanel();
        topBar.setBackground(new Color(98, 0, 238)); // 보라색
        topBar.setLayout(new BorderLayout());

        JButton closeButton = new JButton("X");
        closeButton.setForeground(Color.WHITE);
        closeButton.setBackground(new Color(98, 0, 238));
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(e -> {
            frame.dispose();
            new MainMenuScreen();
        });
        topBar.add(closeButton, BorderLayout.WEST);

        JLabel titleLabel = new JLabel("Write a Post", JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        topBar.add(titleLabel, BorderLayout.CENTER);

        JButton postButton = new JButton("게시하기");
        postButton.setForeground(Color.WHITE);
        postButton.setBackground(new Color(98, 0, 238));
        postButton.setBorderPainted(false);
        postButton.setFocusPainted(false);
        // postButton.addActionListener(e -> /* 게시하기 로직 */);
        topBar.add(postButton, BorderLayout.EAST);

        frame.add(topBar, BorderLayout.NORTH);

        // 중앙 내용
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 사용자 아이콘 및 텍스트 입력 필드
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel profileIcon = new JLabel();
        profileIcon.setPreferredSize(new Dimension(40, 40));
        profileIcon.setOpaque(true);
        profileIcon.setBackground(Color.GRAY);
        inputPanel.add(profileIcon);

        inputPanel.add(Box.createRigidArea(new Dimension(8, 0)));

        JTextField postField = new JTextField("무슨 일이 일어나고 있나요?");
        inputPanel.add(postField);

        centerPanel.add(inputPanel);

        frame.add(centerPanel, BorderLayout.CENTER);

        // 플로팅 버튼
        JButton addButton = new JButton("+");
        addButton.setFont(new Font("Serif", Font.BOLD, 24));
        addButton.setBackground(new Color(29, 161, 242));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setBorderPainted(false);
        addButton.setContentAreaFilled(false);
        addButton.setOpaque(true);
        addButton.setPreferredSize(new Dimension(60, 60));

        JLayeredPane layeredPane = frame.getLayeredPane();
        addButton.setBounds(380, 660, 60, 60);
        layeredPane.add(addButton, JLayeredPane.PALETTE_LAYER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WritePostScreen::new);
    }
}
