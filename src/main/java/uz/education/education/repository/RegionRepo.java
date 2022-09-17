package uz.education.education.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.education.education.models.Region;

@Repository
public interface RegionRepo extends CrudRepository<Region, Long> {

}