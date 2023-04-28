import javax.swing.*;

public class Main extends JFrame {

    JTable table = new JTable(10, 10);
    public Main() {
        super("My First Swing App");

        setSize(1_280, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}