package app.springbootproj.repository;

import app.springbootproj.model.JellyBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JellyBeanRepository extends JpaRepository<JellyBean, UUID> {
}
