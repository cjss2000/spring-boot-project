package app.springbootproj;

import java.util.List;

public interface JellyBeanService {


    JellyBean add(JellyBean bean);

    String getAll();

    boolean deleteById(String id);

    void deleteAll();

    String getbyId(String id);

}
