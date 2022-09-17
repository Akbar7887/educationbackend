package uz.education.education.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.education.education.models.Active;
import uz.education.education.models.GroupEdu;
import uz.education.education.repository.GroupEduRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class GroupEduService {

    final GroupEduRepo groupEduRepo;

    public GroupEdu save(GroupEdu groupEdu) {
        return groupEduRepo.save(groupEdu);
    }

    public List<GroupEdu> getAllActive() {
        return groupEduRepo.getAllActive(Active.ACTIVE);
    }

    public GroupEdu remove(GroupEdu groupEdu) {
        groupEdu.setActive(Active.NOACTIVE);
        return groupEduRepo.save(groupEdu);
    }

    public GroupEdu getOne(String id) {

        Optional<GroupEdu> groupEduOptional = groupEduRepo.findById(Long.parseLong(id));
        if (groupEduOptional.isPresent()) {
            GroupEdu groupEdu = groupEduOptional.get();
            return groupEduRepo.save(groupEdu);
        } else {
            return null;
        }
    }
}
