package uz.education.education.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.education.education.models.Region;
import uz.education.education.service.RegionService;

import java.util.List;

@RestController
@RequestMapping("/region/")
@RequiredArgsConstructor
public class RegionResource {

    @Autowired
    final RegionService regionService;

    @GetMapping("get")
    private ResponseEntity<List<Region>> getAll(){
        return ResponseEntity.ok().body(regionService.getAll());
    }
}
