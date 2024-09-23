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
            image = ImageIO.read(new File("/Users/iseungbin/Documents/GitHub/T-/ImageResource/BackGround.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 이미지가 있을 때만 그리기
        if (image != null) {
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
