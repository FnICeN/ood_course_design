package extend;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.List;

public interface Export<T> {
    boolean save_csv(List<T> data, String path, boolean index);
    boolean save_txt(List<T> data, String path, String sep);
    boolean save_json(List<T> data, String path);
    HttpResponse<String> send_json(List<T> data, HttpHeaders header, String url);
}
