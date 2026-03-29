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
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton btnMinMax = new JButton("Tìm Max/Min");
        JButton btnSort = new JButton("Sắp xếp tăng dần");
        buttonPanel.add(btnMinMax);
        buttonPanel.add(btnSort);
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout)
        JPanel minMaxPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        JLabel lblNum1 = new JLabel("Số thứ nhất:");
        JTextField txtNum1 = new JTextField();
        JLabel lblNum2 = new JLabel("Số thứ hai:");
        JTextField txtNum2 = new JTextField();
        JButton btnFindMax = new JButton("Tìm số lớn nhất");
        JButton btnFindMin = new JButton("Tìm số nhỏ nhất");
        JTextArea txtResultMinMax = new JTextArea();
        txtResultMinMax.setEditable(false);

        btnFindMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(txtNum1.getText());
                    double num2 = Double.parseDouble(txtNum2.getText());
                    double max = Math.max(num1, num2);
                    txtResultMinMax.setText("Số lớn nhất: " + max);
                } catch (NumberFormatException ex) {
                    txtResultMinMax.setText("Vui lòng nhập số hợp lệ!");
                }
            }
        });

        btnFindMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(txtNum1.getText());
                    double num2 = Double.parseDouble(txtNum2.getText());
                    double min = Math.min(num1, num2);
                    txtResultMinMax.setText("Số nhỏ nhất: " + min);
                } catch (NumberFormatException ex) {
                    txtResultMinMax.setText("Vui lòng nhập số hợp lệ!");
                }
            }
        });

        minMaxPanel.add(lblNum1);
        minMaxPanel.add(txtNum1);
        minMaxPanel.add(lblNum2);
        minMaxPanel.add(txtNum2);
        minMaxPanel.add(btnFindMax);
        minMaxPanel.add(btnFindMin);
        minMaxPanel.add(new JLabel("Kết quả:"));
        minMaxPanel.add(new JScrollPane(txtResultMinMax));

        
        JPanel sortPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        JLabel lblA1 = new JLabel("Số thứ nhất:");
        JTextField txtA1 = new JTextField();
        JLabel lblB1 = new JLabel("Số thứ hai:");
        JTextField txtB1 = new JTextField();
        JButton btnSortAsc = new JButton("Sắp xếp tăng dần");
        JTextArea txtResultSort = new JTextArea();
        txtResultSort.setEditable(false);

        btnSortAsc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(txtA1.getText());
                    double num2 = Double.parseDouble(txtB1.getText());
                    if (num1 <= num2) {
                        txtResultSort.setText(num1 + ", " + num2);
                    } else {
                        txtResultSort.setText(num2 + ", " + num1);
                    }
                } catch (NumberFormatException ex) {
                    txtResultSort.setText("Vui lòng nhập số hợp lệ!");
                }
            }
        });

        sortPanel.add(lblA1);
        sortPanel.add(txtA1);
        sortPanel.add(lblB1);
        sortPanel.add(txtB1);
        sortPanel.add(btnSortAsc);
        sortPanel.add(new JLabel());
        sortPanel.add(new JLabel("Kết quả:"));
        sortPanel.add(new JScrollPane(txtResultSort));

       
        cardPanel.add(minMaxPanel, "MinMax");
        cardPanel.add(sortPanel, "Sort");

      
        btnMinMax.addActionListener(e -> cardLayout.show(cardPanel, "MinMax"));
        btnSort.addActionListener(e -> cardLayout.show(cardPanel, "Sort"));

       
        cardLayout.show(cardPanel, "MinMax");

        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(cardPanel, BorderLayout.CENTER);

        return mainPanel;

    }
private JPanel createPart3Panel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblNumber = new JLabel("Nhập số:");
        JTextField txtNumber = new JTextField();
        JButton btnCheck = new JButton("Kiểm tra");
        JTextArea txtResult = new JTextArea();
        txtResult.setEditable(false);

        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int number = Integer.parseInt(txtNumber.getText());
                    if (isPalindrome(number)) {
                        txtResult.setText(number + " là số đối xứng");
                    } else {
                        txtResult.setText(number + " không phải số đối xứng");
                    }
                } catch (NumberFormatException ex) {
                    txtResult.setText("Vui lòng nhập số nguyên hợp lệ!");
                }
            }
        });

        panel.add(lblNumber);
        panel.add(txtNumber);
        panel.add(btnCheck);
        panel.add(new JLabel());
        panel.add(new JLabel("Kết quả:"));
        panel.add(new JScrollPane(txtResult));

        return panel;
    }

    // Hàm hỗ trợ kiểm tra số đối xứng (private)
    private boolean isPalindrome(int num) {
        String str = Integer.toString(num);
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }


    private JPanel createPart4Panel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblNum1 = new JLabel("Số thứ nhất:");
        JTextField txtNum1 = new JTextField();
        JLabel lblNum2 = new JLabel("Số thứ hai:");
        JTextField txtNum2 = new JTextField();
        JButton btnFindGCD = new JButton("Tìm ƯCLN");
        JTextArea txtResult = new JTextArea();
        txtResult.setEditable(false);

        btnFindGCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(txtNum1.getText());
                    int num2 = Integer.parseInt(txtNum2.getText());
                    int gcd = findGCD(num1, num2);
                    txtResult.setText("Ước chung lớn nhất: " + gcd);
                } catch (NumberFormatException ex) {
                    txtResult.setText("Vui lòng nhập số nguyên hợp lệ!");
                }
            }
        });

        panel.add(lblNum1);
        panel.add(txtNum1);
        panel.add(lblNum2);
        panel.add(txtNum2);
        panel.add(btnFindGCD);
        panel.add(new JLabel());
        panel.add(new JLabel("Kết quả:"));
        panel.add(new JScrollPane(txtResult));

        return panel;
    }

    // Hàm hỗ trợ tìm ƯCLN (private)
    private int findGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MathToolsGUI().setVisible(true));
    }
} 
