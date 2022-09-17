package uz.education.education.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.education.education.models.Region;
import uz.education.education.repository.RegionRepo;

@Service
@RequiredArgsConstructor
@Transactional
public class RegionService {

    final RegionRepo regionRepo;


    public Region save(Region object) {
        return regionRepo.save(object);
    }

    public Iterable<Region> getAll() {
        return regionRepo.findAll();
    }

}
