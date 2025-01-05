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

    private JPanel menuPanel, laboratoryPanel, sideBarPanel;
    private JButton[] btnMenuArray, btnLogicArray;

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

        sideBarPanel = new JPanel();
        sideBarPanel.setBounds(10, 120, 350,660);
        sideBarPanel.setBackground(Color.white);
        sideBarPanel.setBorder(BorderFactory.createTitledBorder("Side Bar"));
        sideBarPanel.setLayout(new GridLayout(7, 1));
        add(sideBarPanel);

        btnLogicArray = new JButton[7];
        for(int i = 0; i < 7; i++)
        {
            btnLogicArray[i] = new JButton(Contants.LOGIC[i]);
            btnLogicArray[i].setBackground(Contants.HOVERING[0]);
            btnLogicArray[i].setForeground(Contants.HOVERING[1]);
            btnLogicArray[i].addMouseListener(new HoveringListener());
            btnLogicArray[i].addActionListener(new MenuListener());
            sideBarPanel.add(btnLogicArray[i]);
        }

        laboratoryPanel = new JPanel();
        laboratoryPanel.setBounds(370, 120, 900,660);
        laboratoryPanel.setBackground(Color.white);
        laboratoryPanel.setBorder(BorderFactory.createTitledBorder("Laboratory"));
        add(laboratoryPanel);

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
