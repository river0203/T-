import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

//TODO controller 브렌치, 충돌 구현, 전선 그리기 버튼 누르면 lab 화면에 이미지 띄우기, 띄운 이미지 컨트롤 하기


public class Controller extends JPanel {
    private MainView view;
    private Model nowData;
    private ArrayList<Model> savedList;

    public Controller(MainView v)
    {

    }

    public int getPresentLogic()
    {
        return nowData.presentLogic;
    }
    public void setPresentLogic(int nChangeLogic)
    {
        nowData.presentLogic = nChangeLogic;
    }

}
