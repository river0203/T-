import javax.swing.JFrame;

public class Main {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("SIMPLE PAINTER");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        MainVeiw view = new MainVeiw();
        frame.getContentPane().add(view);

        frame.pack();
        frame.setVisible(true);
    }
}
