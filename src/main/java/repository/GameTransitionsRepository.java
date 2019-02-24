package repository;

import model.entity.Transition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameTransitionsRepository extends JpaRepository<Transition, Long> {
    List<Transition> findByUserIdAndNamePlayOrderByLastPlayDesc(String userId, String namePlay);
}
