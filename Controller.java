import javax.swing.*;
import java.awt.*;

public class Controller extends JPanel {

    private MainVeiw view;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public Controller(MainVeiw v)
    {
        view = v;
        setBackground(Color.white);
    }
}
