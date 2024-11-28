import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginScreen() {
        // JFrame 설정
        frame = new JFrame("Login Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 720); // 화면 크기 고정
        frame.setResizable(false); // 크기 조절 비활성화
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // APP 로고 텍스트
        JLabel logoLabel = new JLabel("X", JLabel.CENTER);
        logoLabel.setFont(new Font("Serif", Font.BOLD, 100)); // 폰트 크기 조정
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        frame.add(logoLabel, gbc);

        // ID 입력 필드
        JLabel usernameLabel = new JLabel("ID 입력:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        frame.add(usernameLabel, gbc);

        usernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(usernameField, gbc);

        // 비밀번호 입력 필드
        JLabel passwordLabel = new JLabel("비밀번호 입력:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(passwordField, gbc);

        // 로그인 버튼
        JButton loginButton = new JButton("로그인");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        frame.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // 로그인 검증 로직
                if (isValidLogin(username, password)) {
                    frame.dispose(); // 현재 로그인 화면 닫기
                    new MainMenuScreen(); // 메인 메뉴 화면 열기
                } else {
                    JOptionPane.showMessageDialog(frame, "잘못된 ID 또는 비밀번호입니다.");
                }
            }
        });

        // 비밀번호 찾기 버튼
        JButton findPasswordButton = new JButton("비밀번호 찾기");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        frame.add(findPasswordButton, gbc);

        findPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 비밀번호 찾기 로직 (예시로 메시지 출력)
                JOptionPane.showMessageDialog(frame, "비밀번호 찾기 기능 실행");
            }
        });

        // 회원가입 버튼
        JButton registerButton = new JButton("회원가입");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        frame.add(registerButton, gbc);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원가입 로직 (예시로 메시지 출력)
                JOptionPane.showMessageDialog(frame, "회원가입 기능 실행");
            }
        });

        frame.setVisible(true);
    }

    private boolean isValidLogin(String username, String password) {
        // 간단한 로그인 검증 로직 (여기서는 모든 입력을 허용)
        return !username.isEmpty() && !password.isEmpty();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginScreen::new);
    }
}
