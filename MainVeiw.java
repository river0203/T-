import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//TODO 이미지 버튼에 넣기 Img-management branch 우선

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
        sideBarPanel.setLayout(new GridLayout(5, 1));
        add(sideBarPanel);

        btnLogicArray = new JButton[6];
        for(int i = 0; i < 6; i++)
        {
            btnLogicArray[i] = new JButton(Contants.LOGIC[i]);
            btnLogicArray[i].setBackground(Contants.HOVERING[0]);
            btnLogicArray[i].setForeground(Contants.HOVERING[1]);
            btnLogicArray[i].addMouseListener(new HoveringListener());
            btnLogicArray[i].addMouseListener(new SideBarListener());
            sideBarPanel.add(btnLogicArray[i]);
        }

        laboratoryPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                Image breadBoardImg = new ImageIcon("Draw/breadBoard.png").getImage();
                g.drawImage(breadBoardImg, 150, 20, 600, 600, null);
                setOpaque(false);

                super.paintComponent(g);
            }
        };
        laboratoryPanel.setBounds(370, 120, 900,660);
        laboratoryPanel.setBackground(Color.white);
        laboratoryPanel.setBorder(BorderFactory.createTitledBorder("Laboratory"));
        add(laboratoryPanel);
    }

    private class HoveringListener implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
            JButton presentButton =(JButton) e.getSource();
            if(presentButton == btnLogicArray[0])
            {
                System.out.println("Button 0");
            }
            else if(presentButton == btnLogicArray[1])
            {
                System.out.println("Button 1");
            }
            else if(presentButton == btnLogicArray[2])
            {
                System.out.println("Button 2");
            }
            else if(presentButton == btnLogicArray[3])
            {
                System.out.println("Button 3");
            }
            else if(presentButton == btnLogicArray[4])
            {
                System.out.println("Button 4");
            }
            else if(presentButton == btnLogicArray[5])
            {
                System.out.println("Button 5");
            }
            else
            {
                System.out.println("Default");
            }
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

    private class SideBarListener implements MouseListener
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
}
