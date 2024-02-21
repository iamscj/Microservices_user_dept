package com.iamscjoshi.userservice.service;

import com.iamscjoshi.userservice.VO.Department;
import com.iamscjoshi.userservice.VO.ResponseTemplateVO;
import com.iamscjoshi.userservice.entity.User;
import com.iamscjoshi.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of User Service");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {

        log.info("Inside getUserWithDepartment of User Service");


        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
