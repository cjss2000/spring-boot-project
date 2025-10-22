package app.springbootproj;

import app.springbootproj.model.JellyBean;

import java.util.List;
import java.util.UUID;

public interface JellyBeanService {


    JellyBean add(JellyBean bean);

    // TODO: getAll method should return a List of JellyBeans
   // String getAll();

    List <JellyBean> getAll();

    // TODO: change this method to accept UUID
    boolean deleteById(String id);

    void deleteAll();

    // TODO:  change this method to accept UUID and return a JellyBean object
    JellyBean getById(UUID id);

}
