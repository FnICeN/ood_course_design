package test;

import com.DAO.Impl.RelationsDAOImpl;
import com.pojo.Relations;

import java.util.List;

public class RelationsDAOImplTest {
    static RelationsDAOImpl rp = new RelationsDAOImpl();

    public static void main(String[] args) {
        List<Relations> l = rp.getRelations("select * from relation where content=?", "寄");
        System.out.println(l);

    }
}
