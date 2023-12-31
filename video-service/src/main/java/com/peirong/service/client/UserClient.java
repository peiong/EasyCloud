package com.peirong.service.client;

import com.peirong.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient("userservice")
public interface UserClient {

    @RequestMapping("/user/list/{uid}")
    User getUserById(@PathVariable String uid);
}