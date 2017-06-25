package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * @author v.bublik.
 */
public interface GenericRepository<E,K extends Serializable> extends JpaRepository<E,K> { }
