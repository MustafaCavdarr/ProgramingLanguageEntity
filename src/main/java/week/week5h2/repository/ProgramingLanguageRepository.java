package week.week5h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import week.week5h2.entity.ProgramingLanguageEntity;

@Repository
public interface ProgramingLanguageRepository extends JpaRepository <ProgramingLanguageEntity, Integer> {
}
