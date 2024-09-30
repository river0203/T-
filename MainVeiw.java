import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.*;
import java.awt.event.*;

public class MainVeiw extends JPanel {

    private Controller experController;
    private JPanel menuPanel, selectPanel, performancePanel;
    private JButton[] btnCircuitAry;
    private JButton[] btnBoardArrangement;
    private JLayeredPane layeredPane;

    public MainVeiw() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(1280, 800));
        setLayout(null);

        // experController에 이미지를 표시하고 그 위에 추가 이미지를 배치할 수 있도록 null layout 설정
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(260, 85, 710, 700);
        layeredPane.setBorder(BorderFactory.createTitledBorder("Create"));
        layeredPane.setLayout(null);  // 자유롭게 컴포넌트 위치 설정을 위해 null layout 사용
        add(layeredPane);

        // Menu Panel 설정
        menuPanel = new JPanel();
        menuPanel.setBounds(0, 0, 1280, 80);
        menuPanel.setBackground(Color.white);
        menuPanel.setBorder(BorderFactory.createTitledBorder("Menu"));
        menuPanel.setLayout(new GridLayout(1, 4));
        add(menuPanel);

        btnBoardArrangement = new JButton[5];

        String[] menuImgPath = {
                "/Users/iseungbin/Documents/GitHub/T-/ImageResource/menu_logo.jpg",
                "/Users/iseungbin/Documents/GitHub/T-/ImageResource/menu1.jpg",
                "/Users/iseungbin/Documents/GitHub/T-/ImageResource/menu2.jpg",
                "/Users/iseungbin/Documents/GitHub/T-/ImageResource/menu3.jpg",
                "/Users/iseungbin/Documents/GitHub/T-/ImageResource/menu4.jpg"
        };

        for (int i = 0; i < 5; i++) {
            ImageIcon icon = new ImageIcon(menuImgPath[i]);  // 이미지 경로로 아이콘 생성
            btnBoardArrangement[i] = new JButton(icon);
            menuPanel.add(btnBoardArrangement[i]);
        }

        // Select Panel 설정
        selectPanel = new JPanel();
        selectPanel.setBounds(0, 85, 250, 700);
        selectPanel.setBackground(Color.white);
        selectPanel.setBorder(BorderFactory.createTitledBorder("Select"));
        selectPanel.setLayout(new GridLayout(8, 2));
        add(selectPanel);

        btnCircuitAry = new JButton[9];

        String[] imagePaths = {
                "/Users/iseungbin/Documents/GitHub/T-/ImageResource/Battery.png",
                "/Users/iseungbin/Documents/GitHub/T-/ImageResource/BatteryCase.png",
                "/Users/iseungbin/Documents/GitHub/T-/ImageResource/SwitchAry.png",
                "/Users/iseungbin/Documents/GitHub/T-/ImageResource/SwitchOff.png",
                "/Users/iseungbin/Documents/GitHub/T-/ImageResource/SwitchOn.png",
                "/Users/iseungbin/Documents/GitHub/T-/ImageResource/Wing.png",
                "/Users/iseungbin/Documents/GitHub/T-/ImageResource/line1.png",
                "/Users/iseungbin/Documents/GitHub/T-/ImageResource/line2.png",
                "/Users/iseungbin/Documents/GitHub/T-/ImageResource/line3.png"
        };

        // 각 버튼에 이미지를 설정
        for (int i = 0; i < 9; i++) {
            ImageIcon icon = new ImageIcon(imagePaths[i]);  // 이미지 경로로 아이콘 생성
            btnCircuitAry[i] = new JButton(icon);          // 아이콘을 버튼에 추가
            btnCircuitAry[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    ImageIcon buttonIcon = (ImageIcon) source.getIcon();
                    addImageToLayeredPane(buttonIcon);
                }
            });
            selectPanel.add(btnCircuitAry[i]);
        }

        performancePanel = new JPanel();
        performancePanel.setBounds(980, 85, 300, 700);
        performancePanel.setBackground(Color.white);
        performancePanel.setBorder(BorderFactory.createTitledBorder("Performance"));
        add(performancePanel);
    }

    // 버튼 클릭 시 호출되는 메소드로 이미지를 JLayeredPane에 추가
    private void addImageToLayeredPane(ImageIcon icon) {
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(100, 100, icon.getIconWidth(), icon.getIconHeight());  // 원하는 위치와 크기 설정

        // 마우스 드래그 리스너 추가
        imageLabel.addMouseListener(new MouseAdapter() {
            Point initialClick;

            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
            }
        });

        imageLabel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // 이미지의 현재 위치를 가져옴
                int xMoved = e.getX() - imageLabel.getWidth() / 2;
                int yMoved = e.getY() - imageLabel.getHeight() / 2;

                // 새 위치 계산
                int x = imageLabel.getX() + xMoved;
                int y = imageLabel.getY() + yMoved;
                imageLabel.setLocation(x, y);
            }
        });

        // 이미지를 레이어에 추가
        layeredPane.add(imageLabel, JLayeredPane.PALETTE_LAYER);
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    // 이미지 드래그 앤 드롭을 위한 TransferHandler 설정
    private class ImageTransferHandler extends TransferHandler {

        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            // 이미지 데이터만 허용
            return support.isDataFlavorSupported(DataFlavor.imageFlavor);
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            if (!canImport(support)) {
                return false;
            }

            try {
                // 드래그 앤 드롭한 이미지 데이터를 가져옴
                ImageIcon icon = (ImageIcon) support.getTransferable().getTransferData(DataFlavor.imageFlavor);
                JLabel label = new JLabel(icon);
                Point dropLocation = support.getDropLocation().getDropPoint();

                // 드롭한 위치에 이미지 레이블 추가
                label.setBounds(dropLocation.x, dropLocation.y, icon.getIconWidth(), icon.getIconHeight());
                layeredPane.add(label, JLayeredPane.PALETTE_LAYER);
                layeredPane.revalidate();
                layeredPane.repaint();
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }
}
