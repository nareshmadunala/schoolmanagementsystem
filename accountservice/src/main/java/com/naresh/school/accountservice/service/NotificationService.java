package com.naresh.school.accountservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author nareshmadunala
 */
@FeignClient(name="Notification-Service", url="http://localhost:9072")
public interface NotificationService {

    @GetMapping("/api/v1/notifications")
    public String sendEmail();
}
