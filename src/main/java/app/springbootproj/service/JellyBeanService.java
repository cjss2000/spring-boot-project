package app.springbootproj.service;

import app.springbootproj.model.JellyBean;
import app.springbootproj.repository.JellyBeanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class JellyBeanService {

    private final JellyBeanRepository jellyBeanRepository;

    public JellyBean createOrUpdate(JellyBean bean) {
        jellyBeanRepository.save(bean);
        return bean;
    }

    public List<JellyBean> getAll() {
        return jellyBeanRepository.findAll();
    }

    public JellyBean getById(UUID id) {
       return jellyBeanRepository.findById(id).get();
    }

    public void deleteById(UUID id) {
        jellyBeanRepository.deleteById(id);
    }

    public void deleteAll() {
        jellyBeanRepository.deleteAll();
    }
}
