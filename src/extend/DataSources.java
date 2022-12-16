package extend;

import java.util.List;

public interface DataSources<T> {
    List<T> read_csv(String path);
    List<T> read_txt(String path);
    List<T> read_json(String path);
    List<T> read_xml(String path);
}
