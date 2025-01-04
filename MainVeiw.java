import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MenuListener;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.*;
import java.awt.event.*;
import java.util.Stack;

//TODO 각 활동 구역 나누기

public class MainVeiw extends JPanel {

    private JPanel menuPanel;
    private JButton[] btnMenuArray;

    public MainVeiw() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(1280, 800));
        setLayout(null);

        menuPanel = new JPanel();
        menuPanel.setBounds(10, 10, 1260, 100);
        menuPanel.setBackground(Color.white);
        menuPanel.setBorder(BorderFactory.createTitledBorder("menu"));
        menuPanel.setLayout(new GridLayout(1, 5));
        add(menuPanel);

        btnMenuArray = new JButton[5];
        for(int i = 0; i < 5; i++)
        {
            btnMenuArray[i] = new JButton(Contants.BUTTON[i]);
            btnMenuArray[i].setBackground(Contants.HOVERING[0]);
            btnMenuArray[i].setForeground(Contants.HOVERING[1]);
            btnMenuArray[i].addMouseListener(new HoveringListener());
            btnMenuArray[i].addActionListener(new MenuListener());
            menuPanel.add(btnMenuArray[i]);
        }
    }

    private class HoveringListener implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class MenuListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
        }
    }
}
