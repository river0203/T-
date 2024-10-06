import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Controller extends JPanel {

    private BufferedImage image;

    // MainVeiw로부터 JPanel을 받는 생성자
    public Controller(MainVeiw mainVeiw) {
        try {
            // 이미지 파일 로드 (파일 경로를 절대경로 또는 상대경로로 수정)
            image = ImageIO.read(new File("C:\\Users\\aspp3\\OneDrive\\문서\\GitHub\\T-\\ImageResource\\BackGround.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // null 레이아웃 설정하여 드래그 앤 드롭한 컴포넌트를 자유롭게 배치할 수 있도록 함
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 배경 이미지를 먼저 그림
        if (image != null) {
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }

        // 이미지를 그리고 나서 다른 컴포넌트들이 그 위에 그려질 수 있도록 함
        super.paintComponents(g);
    }
}
