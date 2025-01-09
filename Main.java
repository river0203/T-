import javax.swing.JFrame;

public class Main {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("T+");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        MainView view = new MainView();
        frame.getContentPane().add(view);

        frame.pack();
        frame.setVisible(true);
    }
}
