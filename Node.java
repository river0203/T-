public class Node {

    // node의 특징 파워 1, 접지 2, 연결부 3

    //private int voltage = 0;
    private boolean isPower = false;
    private boolean isGround = false;
    private boolean isConnection = false;
    private boolean isComponentOn = false;
    private int[] node = new int[5];

    public Node()
    {

    }

    public Node(int nodeMode)
    {

    }

    public boolean getPower(){return isPower;}
    public void setPower(boolean changePower){isPower = changePower;}
    public boolean getGround(){return isGround;}
    public void setGround(boolean changeGround){isGround = changeGround;}
    public boolean getConnection(){return isConnection;}
    public void setConnection(boolean changeConnection){isConnection = changeConnection;}

    public void changeNodeMode(int nodeMode)
    {
        switch (nodeMode)
        {
            case 1:
                isPower = true;
                break;

            case 2:
                isGround = true;
                break;

            case 3:
                isConnection = true;
                break;

            default:
                break;
        }
    }

    public void removeComponet()
    {

    }
}
