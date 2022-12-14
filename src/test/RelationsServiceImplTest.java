package test;

import com.Service.Impl.RelationsServiceImpl;
import com.Service.RelationsService;

public class RelationsServiceImplTest {
    static RelationsService rsi = new RelationsServiceImpl();


    public static void main(String[] args) {
        System.out.println(rsi.getRelationsByContent("寄"));
    }
}
