package com.cmm.spring.controller;

import com.cmm.spring.dto.LoginResponseDto;
import com.cmm.spring.dto.NaverUserInfo;
import com.cmm.spring.entity.User;
import com.cmm.spring.repository.UserRepository;
import com.cmm.spring.service.LoginApiService;
import com.cmm.spring.service.NaverOAuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@RequestMapping("/login/oauth2")
public class LoginApiController {
    @Autowired
    private LoginApiService loginApiService;
    @Autowired
    private NaverOAuthService naverOAuthService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/kakao/callback")
    public String kakaoLogin(HttpServletRequest request) {
        System.out.println("kakao Api 호출");

        String code = request.getParameter("code");
        System.out.println("인가코드: " + code);

        String kakaoAccessToken = loginApiService.getKakaoToken(code).getAccess_token();
        System.out.println("카카오 accessToken: " + kakaoAccessToken);

        LoginResponseDto id = loginApiService.kakaoLogin(kakaoAccessToken);
        System.out.println("LoginResponseDto: " + id);

        //if (id == null || id.getUser() == null) {
        //    System.out.println("LoginResponseDto 또는 User가 null입니다.");
        //    return null;
        //}

        return id.getUser().getUid();
    }

    @PostMapping("/naver/callback")
    public String naverLogin(@RequestBody Map<String, String> params) {
        String code = params.get("code");
        String state = params.get("state");
        System.out.println("네이버 인가코드: " + code);
        System.out.println("state: " + state);

        // 1. 네이버 토큰 요청
        String accessToken = naverOAuthService.getAccessToken(code, state);
        System.out.println("네이버 accessToken: " + accessToken);

        // 2. 네이버 유저 정보 요청
        NaverUserInfo userInfo = naverOAuthService.getUserInfo(accessToken);
        System.out.println("네이버 유저 정보: "+userInfo.toString());

        // 3. 자체 로그인/회원가입 처리 (userService에서 DB에 저장/조회)
        User user = new User(userInfo.getId(),userInfo.getName(),null);
        userRepository.save(user);
        // 4. id만 반환
        return user.getUid();
    }


}

