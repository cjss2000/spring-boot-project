package app.springbootproj;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class JellyBeanServiceImpl implements JellyBeanService {
   // List<JellyBean> list = new ArrayList();
    private ArrayList<JellyBean> list;
    public JellyBeanServiceImpl(){
        this.list = new ArrayList<JellyBean>();
    }
    @Override
    public JellyBean add(JellyBean bean){
        for (JellyBean j : list){
            list.add(bean);
        }
        return bean;
    }

    @Override
   public  List<JellyBean> getAll(){
        for (JellyBean j : list){
            System.out.println(j);
        }
       return list;
    }

    @Override
    public String getbyId(String id){
        for (JellyBean j : list){
            if (j.getId().equals(id)){
                System.out.println(id);
            }
        }
        return id;
    }

    @Override
    public boolean deleteById(String id){
        for (JellyBean jellyBean : list){
            if (jellyBean.getId().equals(id)){
                list.remove(id);

            }
            else return false;
        }
    return true; //this is a filler, fix later.
    }
    @Override
    public void deleteAll(){
        List<JellyBean> list = new ArrayList();
    }
}
