package pl.iseebugs.module;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AllModulesRepository extends JpaRepository<AllModules, Integer> {
}
