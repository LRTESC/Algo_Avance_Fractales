import javax.swing.*;

public class Frame extends JFrame {

    private static final long serialVersionUID = 1L;

    public Frame(String title) {
        setTitle(title);
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}