package src;

import javax.swing.*;
import java.awt.*;

public class MathToolsGUI extends JFrame {
    private JTabbedPane tabbedPane;

    public MathToolsGUI() {
        setTitle("Công Cụ Toán Học");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        // 4 khung tương ứng với 4 phần
        tabbedPane.addTab("Phần 1: Giải PT bậc nhất", createPart1Panel());
        tabbedPane.addTab("Phần 2: Max/Min & Sắp xếp", createPart2Panel());
        tabbedPane.addTab("Phần 3: Số đối xứng", createPart3Panel());
        tabbedPane.addTab("Phần 4: Ước chung lớn nhất", createPart4Panel());

        add(tabbedPane);
    }
    private JPanel createPart1Panel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblA = new JLabel("Hệ số a:");
        JTextField txtA = new JTextField();
        JLabel lblB = new JLabel("Hệ số b:");
        JTextField txtB = new JTextField();
        JButton btnSolve = new JButton("Giải phương trình");
        JTextArea txtResult = new JTextArea();
        txtResult.setEditable(false);

        btnSolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(txtA.getText());
                    double b = Double.parseDouble(txtB.getText());

                    if (a == 0) {
                        if (b == 0) {
                            txtResult.setText("Phương trình có vô số nghiệm");
                        } else {
                            txtResult.setText("Phương trình vô nghiệm");
                        }
                    } else {
                        double solution = -b / a;
                        txtResult.setText("Nghiệm: x = " + solution);
                    }
                } catch (NumberFormatException ex) {
                    txtResult.setText("Vui lòng nhập số hợp lệ!");
                }
            }
        });

        panel.add(lblA);
        panel.add(txtA);
        panel.add(lblB);
        panel.add(txtB);
        panel.add(btnSolve);
        panel.add(new JLabel()); // ô trống
        panel.add(new JLabel("Kết quả:"));
        panel.add(new JScrollPane(txtResult));

        return panel;
    }

 private JPanel createPart2Panel() {
        // TODO: Người 2 viết code ở đây
        JPanel panel = new JPanel();
        panel.add(new JLabel("Chờ người 2 hoàn thiện..."));
        return panel;
    }

    private JPanel createPart3Panel() {
        // TODO: Người 3 viết code ở đây
        JPanel panel = new JPanel();
        panel.add(new JLabel("Chờ người 3 hoàn thiện..."));
        return panel;
    }

    private JPanel createPart4Panel() {
        // TODO: Người 4 viết code ở đây
        JPanel panel = new JPanel();
        panel.add(new JLabel("Chờ người 4 hoàn thiện..."));
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MathToolsGUI().setVisible(true));
    }
}