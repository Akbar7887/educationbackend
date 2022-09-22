package uz.education.education.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.education.education.models.Region;

import java.util.List;

@Repository
public interface RegionRepo extends CrudRepository<Region, Long> {

    List<Region> findAll();
}