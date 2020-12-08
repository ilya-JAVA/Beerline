package by.peretz.spring.repository;

import by.peretz.spring.domain.Beer;
import by.peretz.spring.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {
  @Override
  Page<Beer> findAll(Pageable pageable);
  Page<Beer> findByNameStartingWithIgnoreCase(
          @Param("name") String name,
          Pageable pageable
  );
}