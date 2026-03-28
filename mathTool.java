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
        // TODO: Người 1 viết code ở đây
        JPanel panel = new JPanel();
        panel.add(new JLabel("Chờ người 1 hoàn thiện..."));
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