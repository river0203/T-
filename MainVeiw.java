import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class MainVeiw extends JPanel{

    private Controller  experController;
    private JPanel      menuPanel, selectPanel, performancePanel;
    private JButton[]   btnCircuitAry;
    private JButton[]   btnBoardArrangement;

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
        selectPanel.setLayout(new GridLayout(8, 2));
        add(selectPanel);

        btnCircuitAry = new JButton[9];

        // 이미지 경로 배열 (경로를 알맞게 변경해야 합니다)
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
        for(int i = 0; i < 9; i++)
        {
            ImageIcon icon = new ImageIcon(imagePaths[i]);  // 이미지 경로로 아이콘 생성
            btnCircuitAry[i] = new JButton(icon);          // 아이콘을 버튼에 추가
            selectPanel.add(btnCircuitAry[i]);
        }

        performancePanel = new JPanel();
        performancePanel.setBounds(980, 85, 300, 700);
        performancePanel.setBackground(Color.white);
        performancePanel.setBorder(BorderFactory.createTitledBorder("Performance"));
        add(performancePanel);
    }
}
