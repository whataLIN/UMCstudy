package umc.spring.repository.TermRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Terms;

public interface TermRepository extends JpaRepository<Terms, Long> {
}
