import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class MainVeiw extends JPanel{

    private Controller  experController;
    private JPanel      menuPanel, selectPanel, performancePanel;

    public MainVeiw()
    {
        setBackground(Color.white);
        setPreferredSize(new Dimension(1280, 800));
        setLayout(null);

        experController = new Controller(this);
        experController.setBounds(260, 85, 710, 700);
        experController.setBorder(BorderFactory.createTitledBorder("Create"));
        add(experController);

        menuPanel = new JPanel();
        menuPanel.setBounds(0, 0, 1280, 80);
        menuPanel.setBackground(Color.white);
        menuPanel.setBorder(BorderFactory.createTitledBorder("Menu"));
        menuPanel.setLayout(new GridLayout(1, 4));
        add(menuPanel);

        selectPanel = new JPanel();
        selectPanel.setBounds(0, 85, 250, 700);
        selectPanel.setBackground(Color.white);
        selectPanel.setBorder(BorderFactory.createTitledBorder("Select"));
        add(selectPanel);

        performancePanel = new JPanel();
        performancePanel.setBounds(980, 85, 300, 700);
        performancePanel.setBackground(Color.white);
        performancePanel.setBorder(BorderFactory.createTitledBorder("Performance"));
        add(performancePanel);
    }
}