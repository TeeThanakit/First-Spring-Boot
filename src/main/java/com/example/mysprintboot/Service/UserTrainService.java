package com.example.mysprintboot.Service;

import com.example.mysprintboot.DTO.UserRoleDto;
import com.example.mysprintboot.DTO.UserTrainsInt;
import com.example.mysprintboot.Entity.Role;
import com.example.mysprintboot.Entity.UsersTrain;
import com.example.mysprintboot.Repository.RoleRepository;
import com.example.mysprintboot.Repository.UserTrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTrainService {
    private final UserTrainRepository userTrainRepository;
    private final RoleRepository roleRepository;

    public UsersTrain save(UsersTrain usersTrain) {
        return userTrainRepository.save(usersTrain);
    }

    public List<UsersTrain> getAll() {
        return userTrainRepository.findAll();
    }

    public List<UsersTrain> getByFirstname(String firstname) {
        return userTrainRepository.findByFirstname(firstname);
    }

    public List<UsersTrain> getByFristnameJPQL(String  firstname) {
        return userTrainRepository.findByFirstname("%"+firstname+"%");
    }

    public List<UserTrainsInt> getAllByName()
    {
        return userTrainRepository.getAllByName();
    }

    public UsersTrain createWithRole(UserRoleDto userRoleDto) {
        UsersTrain newUser = new UsersTrain();
        newUser.setFirstname(userRoleDto.getFirstname());
        newUser.setLastname(userRoleDto.getLastname());
        newUser.setAge(userRoleDto.getAge());
        List<Role> roleList = roleRepository.findAllById(userRoleDto.getRoleIds());
        // select * from role where id in (:id)
        newUser.setRoles(roleList);
        return userTrainRepository.save(newUser);
    }

    //    Pagination
    public Page<UsersTrain> userWithPage(int page, int size){
        Pageable pageables = PageRequest.of(page, size);
        return userTrainRepository.findAll(pageables);
    }
}
