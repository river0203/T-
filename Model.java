import java.awt.*;

public class Model {

    public int presentLogic;
    public Point ptOne, ptTwo;

    public Model()
    {
        presentLogic = Contants.NONE;
        ptOne = new Point();
        ptTwo = new Point();
    }
    
    // 데이터 갱신 생성자
    public Model(Model data)
    {
        presentLogic = data.presentLogic;
        ptOne = data.ptOne;
        ptTwo = data.ptTwo;
    }
}
