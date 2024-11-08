package com.example.mysprintboot.controller;

import com.example.mysprintboot.DTO.UserRoleDto;
import com.example.mysprintboot.DTO.UserTrainsInt;
import com.example.mysprintboot.Entity.UsersTrain;
import com.example.mysprintboot.Service.UserTrainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-train")
@RequiredArgsConstructor
public class UserTrainController {
    private final UserTrainService userTrainService;


    @GetMapping("/getAll")
    public ResponseEntity<List<UsersTrain>> getAllUserTrain() {
        return ResponseEntity.ok(userTrainService.getAll());
    }

    @PostMapping
    public ResponseEntity<UsersTrain> create(@RequestBody UsersTrain usersTrain) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userTrainService.save(usersTrain));
    }

    @PostMapping("/createWithRole")
    public ResponseEntity<UsersTrain> createWithRole(@RequestBody UserRoleDto userRoleDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userTrainService.createWithRole(userRoleDto));
    }

    @GetMapping("/findByFirstname")
    public ResponseEntity<List<UsersTrain>> findByFirstname(@RequestParam("firstname") String firstname) {
        return ResponseEntity.ok(userTrainService.getByFirstname(firstname));
    }

    @GetMapping("getAllByName")
    public ResponseEntity<List<UserTrainsInt>> getAllByName()
    {
        return ResponseEntity.ok(userTrainService.getAllByName());
    }

    @GetMapping("/getWithPage")
    public ResponseEntity<Page<UsersTrain>> getWithPage(@RequestParam(value = "page",defaultValue = "0") int page,
                                                        @RequestParam(value = "size",defaultValue = "10") int size) {
        Page<UsersTrain> usersTrainPage = userTrainService.userWithPage(page, size);

        if(usersTrainPage.hasContent())
        {
            return ResponseEntity.ok(usersTrainPage);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
