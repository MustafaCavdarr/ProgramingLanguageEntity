package programinglanguage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import programinglanguage.entity.ProgramingLanguageEntity;

@Repository
public interface ProgramingLanguageRepository extends JpaRepository <ProgramingLanguageEntity, Integer> {
}
