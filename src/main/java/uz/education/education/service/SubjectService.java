package uz.education.education.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.education.education.models.Subject;
import uz.education.education.repository.SubjectRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SubjectService {

    private final SubjectRepo subjectRepo;

    public List<Subject> getAll() {
        return subjectRepo.findAll();
    }

    public Subject save(Subject subject) {
        return subjectRepo.save(subject);
    }

    public void remove(String id) {
        Optional<Subject> subjectOptional = subjectRepo.findById(Long.parseLong(id));
        if (subjectOptional.isPresent()) {
            Subject subject = subjectOptional.get();
            subjectRepo.delete(subject);
        }
    }
}
