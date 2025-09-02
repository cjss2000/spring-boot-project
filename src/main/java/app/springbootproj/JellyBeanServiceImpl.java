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
        //why won't a to string method work here?
    }

    @Override
   public  List<JellyBean> getAll(){
        for (JellyBean j : list){
            System.out.println(j);
        }
       return list;
    }

    @Override
    public boolean deleteById(int id){
        for (JellyBean jellyBean : list){
            if (jellyBean.getId() == id){
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
