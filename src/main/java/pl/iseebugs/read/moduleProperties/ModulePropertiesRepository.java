package pl.iseebugs.read.moduleProperties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModulePropertiesRepository extends JpaRepository<ModuleProperties, Integer> {
}
