package uz.education.education.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.education.education.models.Registration;
import uz.education.education.repository.RegistrationRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistrationService {

    @Autowired
    final RegistrationRepo registrationRepo;

    public List<Registration> getAll() {
        return registrationRepo.findAll();
    }
}
