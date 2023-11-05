package net.testmyit.repository;

import io.swagger.v3.oas.annotations.Hidden;
import net.testmyit.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Hidden
@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
}
