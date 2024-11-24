package com.employeedetail.service;
import com.employeedetail.dto.EmpRegistrationDto;
import com.employeedetail.entity.EmpRegistration;
import com.employeedetail.repo.EmpRegistrationRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmpRegistrationService implements IEmpRegistration {
    /*@Autowired
private EmpRegistrationRepo empRegistrationRepo;*/
   /* @Autowired
private ObjectMapper objectMapper;*/
   /* @Override
    public EmpRegistration register(EmpRegistration empRegistration) {
        //EmpRegistration empRegistration = objectMapper.convertValue(empRegistrationDto, EmpRegistration.class);
        return empRegistrationRepo.save(empRegistration);
        //here i want send data on gmail
    }*/
 /*  @Autowired
   private EmpRegistrationRepo empRegistrationRepo;*/

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EmpRegistrationRepo empRegistrationRepo;

  /*  @Autowired
    private EmpRegistrationRepo empRegistrationRepo;

    @Autowired
    private JavaMailSender mailSender;
*/
    @Override
    public EmpRegistration register(EmpRegistration empRegistration) {
        // Save employee details to the database
        EmpRegistration savedEmp = empRegistrationRepo.save(empRegistration);
        // Compose the email content
        String subject = "Employee Registration Successful";
        String message = String.format(
                "Dear %s,\n\n" +
                        "Your registration is successful!\n\n" +
                        "Here are your details:\n" +
                        "Employee ID: %d\n" +
                        "Name: %s\n" +
                        "Email: %s\n" +
                        "Password: %s\n\n" +
                        "Best Regards,\nEmployee Management Team",
                savedEmp.getFullName(),
                savedEmp.getId(),
                savedEmp.getFullName(),
                savedEmp.getEmail(),
                savedEmp.getPassword() // Note: Avoid sending raw passwords in production!
        );
        // Send email
        sendEmail(savedEmp.getEmail(), subject, message);
        return savedEmp;
    }
    private void sendEmail(String toEmail, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        // Send the email
        mailSender.send(mailMessage);

        System.out.println("Email sent successfully to " + toEmail);
    }

}
