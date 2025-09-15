package app.springbootproj;

import java.util.List;

public interface JellyBeanService {


    JellyBean add(JellyBean bean);

    // TODO: getAll method should return a List of JellyBeans
    String getAll();

    // TODO: change this method to accept UUID
    boolean deleteById(String id);

    void deleteAll();

    // TODO:  change this method to accept UUID and return a JellyBean object
    String getbyId(String id);

}
