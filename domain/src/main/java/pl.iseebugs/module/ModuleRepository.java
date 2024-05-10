package pl.iseebugs.module;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ModuleRepository extends JpaRepository<Module, Integer> {

    @Query(value =  "SELECT ROWNUM(), * FROM module WHERE module = :id",
        nativeQuery = true)
    List<Module> findOneModuleROWNUM(Integer id);
}
