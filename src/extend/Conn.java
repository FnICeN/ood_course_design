package extend;

import java.sql.Connection;

public interface Conn {
    Connection createConn();
    Connection getConn();
    void close();
}
