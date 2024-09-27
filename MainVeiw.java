import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.File;
import java.util.List;

public class MainVeiw extends JPanel {

    private Controller experController;
    private JPanel menuPanel, selectPanel, performancePanel;
    private JButton[] btnCircuitAry;
    private JButton[] btnBoardArrangement;

    public MainVeiw() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(1280, 800));
        setLayout(null);

        // experController에 이미지를 표시하고 그 위에 추가 이미지를 배치할 수 있도록 null layout 설정
        experController = new Controller(this);
        experController.setBounds(260, 85, 710, 700);
        experController.setBorder(BorderFactory.createTitledBorder("Create"));
        experController.setLayout(null);  // 자유롭게 컴포넌트 위치 설정을 위해 null layout 사용
        experController.setTransferHandler(new ImageTransferHandler());  // 이미지 드래그 앤 드롭을 위한 TransferHandler 설정
        add(experController);

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
            btnCircuitAry[i].setTransferHandler(new TransferHandler("icon"));
            btnCircuitAry[i].addMouseMotionListener(new MouseAdapter() {
                public void mouseDragged(MouseEvent e) {
                    JComponent comp = (JComponent) e.getSource();
                    TransferHandler handler = comp.getTransferHandler();
                    handler.exportAsDrag(comp, e, TransferHandler.COPY);
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
                experController.add(label);
                experController.revalidate();
                experController.repaint();
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }
}
