package org.joinup.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequiredArgsConstructor

public class KakaoController {
    @GetMapping("/kakao/callback")
    public @ResponseBody String kakaoLogin(String code){//Data를 리턴해주는 컨트롤러함수
        //Post방식으로 KEY=value 데이터 요청
        //Resttemplate = http 요청을 좀 더 편리하게 도와줌
        RestTemplate rt = new RestTemplate();
        //Httpheader 오브젝트 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","authorization_code");
        params.add("client_id","9c709b17e345954483cf843f439f8e0d");
        params.add("redirect_uri","http://localhost:8080/kakao/callback");
        params.add("code",code);
        //HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest =
                new HttpEntity<>(params,headers);
        //Http 요청하기 - POST방식으로 - 그리고 response 변수의 응답 받음.
        ResponseEntity<String> reponse = rt.exchange("https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class);

        return "카카오 인증 완료"+reponse;
    }
}
