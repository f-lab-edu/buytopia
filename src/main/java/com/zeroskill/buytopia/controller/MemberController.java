package com.zeroskill.buytopia.controller;

import com.zeroskill.buytopia.dto.MemberDto;
import com.zeroskill.buytopia.dto.request.MemberAvailabilityCheckRequest;
import com.zeroskill.buytopia.dto.request.MemberRegistrationRequest;
import com.zeroskill.buytopia.dto.response.*;
import com.zeroskill.buytopia.exception.BuytopiaException;
import com.zeroskill.buytopia.exception.ErrorType;
import com.zeroskill.buytopia.service.EmailService;
import com.zeroskill.buytopia.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import static com.zeroskill.buytopia.util.Util.isValidEmail;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {
    private static final Logger logger = LogManager.getLogger(MemberController.class);

    private final MemberService memberService;
    private final EmailService emailService;

    @PostMapping({"", "/"})
    public void register(@RequestBody MemberRegistrationRequest request) {
        request.check();
        MemberDto memberDto = MemberRegistrationRequest.toMemberDto(request);
        memberService.register(memberDto);
    }

    @PostMapping("/check/availability")
    public void checkMemberAvailability(@RequestBody MemberAvailabilityCheckRequest request) {
        request.check();
        String loginId = request.loginId();
        String email = request.email();
        boolean isDuplicate = memberService.isLoginIdOrEmailDuplicate(loginId, email);
        if (isDuplicate) {
            throw new BuytopiaException(ErrorType.DUPLICATE_ENTITY, logger::error);
        }
    }

    @PostMapping("/send/verification-email")
    public void sendVerificationEmail(@RequestParam("email") String email) {
        if (!isValidEmail(email)) {
            throw new BuytopiaException(ErrorType.INVALID_EMAIL_FORMAT, logger::error);
        }
        emailService.sendVerificationEmail(email);
    }

    @GetMapping("/verify/email")
    public void verifyEmail(@RequestParam("token") String token) {
        emailService.verifyEmail(token);
    }
}
