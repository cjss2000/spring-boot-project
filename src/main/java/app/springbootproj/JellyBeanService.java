package app.springbootproj;

import java.util.List;

public interface JellyBeanService {


    JellyBean add(JellyBean bean);

    List<JellyBean> getAll();

    boolean deleteById(int id);

    void deleteAll();

}
