package com.codewave.demo.userdatabase.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.codewave.demo.userdatabase.entity.User;
import com.codewave.demo.userdatabase.model.dto.UserDto;
import com.codewave.demo.userdatabase.service.UserService;

import ch.qos.logback.core.net.SyslogOutputStream;

@Configuration
@EnableScheduling // inject some bean(s) into spring context
public class ScheduledTaskConfig {

  @Autowired
  UserService userService;

  // @Scheduled(fixedRate = 2000) // ms
  public void ScheduleFixedRatedTask() throws Exception {
    System.out.println("Fixed rate task - " + System.currentTimeMillis() / 1000);
    // this.wait(4000);
  }

  // @Scheduled(fixedRate = 5000) // ms
  public void ScheduleFixedDelayTask() throws Exception {
    System.out.println("Fixed Delay task - " + System.currentTimeMillis() / 1000);
    // this.wait(4000);
  }
}

  /*
   * @Scheduled(cron = "0 0/1 * * * ?")
   * public void scheduleTaskUsingCronExpression() {
   * long now = System.currentTimeMillis() / 1000;
   * System.out.println(
   * "schedule tasks using cron jobs - " + now);
   * }
   */

//   @Scheduled(cron = "0 0/5 * * * MON-FRI") // Second Minute Hour DD MM Weekday Year 
//   public void scheduleTaskUsingCronExpression() {
//     long now = System.currentTimeMillis() / 1000;
//     System.out.println(
//         "Call JsonPlaceHolder /users - " + now);
//     // Business Loginc
//     // Step 0: Call plaeholder
//     List<UserDto> userDtos = userService.getAll();
//     //Step 1: Convert dto to entity
//     List<User> users = userDtos.stream()
//         .map(e -> {
//           return User.builder()
//               .id(e.getId())
//               .fullName(e.getName())
//               .userEmail(e.getEmail())
//               .userName(e.getUsername())
//               .userWebsite(e.getWebsite())
//               .userPhone(e.getPhone())
//               .build();
//         }).collect(Collectors.toList());

//     // Step 2: Save all to DB
//     userService.saveAll(users);
//   }

// }
