package test;

import com.DAO.Impl.SpeaksDAOImpl;
import com.pojo.Speaks;

public class SpeaksDAOImplTest {
    static SpeaksDAOImpl sp = new SpeaksDAOImpl();

    public static void main(String[] args) {
        Speaks s = sp.getSpeak("寄");
        System.out.println(s);
    }
}
