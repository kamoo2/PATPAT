package com.ssafy.patpat.user.controller;

import com.ssafy.patpat.common.dto.ResponseMessage;
import com.ssafy.patpat.common.jwt.JwtFilter;
import com.ssafy.patpat.common.jwt.TokenProvider;
import com.ssafy.patpat.user.dto.FavoriteDto;
import com.ssafy.patpat.user.dto.LoginDto;
import com.ssafy.patpat.user.dto.TokenDto;
import com.ssafy.patpat.user.dto.UserDto;
import com.ssafy.patpat.user.entity.User;
import com.ssafy.patpat.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Api(tags = {"06. User"},description = "유저 관련 서비스")
public class UserController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserService userService;

    /**
     * 찜 동물 리스트
     * @return
     */
    @GetMapping("/favorite")
    @ApiOperation(value = "찜 동물 조회", notes = "찜 동물 리스트 조회")
    public ResponseEntity<Object> selectFavoriteList(){
        //서비스 호출 코드
        if(true){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ArrayList<FavoriteDto>());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseMessage("FAIL"));
        }
    }
    /**
     * 찜 등록
     * @return
     */
    @GetMapping("/favorite/{protectId}")
    @ApiOperation(value = "찜 등록", notes = "찜 동물 등록")
    public ResponseEntity<Object> insertFavorite(@PathVariable int protectId){
        //서비스 호출 코드
        if(true){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseMessage("SUCCESS"));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseMessage("FAIL"));
        }
    }
    /**
     * 찜 해제
     * @return
     */
    @DeleteMapping("/favorite/{protectId}")
    @ApiOperation(value = "찜 해제", notes = "찜 동물 해제")
    public ResponseEntity<Object> deleteFavorite(@PathVariable int protectId){
        //서비스 호출 코드
        if(true){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseMessage("SUCCESS"));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseMessage("FAIL"));
        }
    }


    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@Valid @RequestBody UserDto userDto) {

        TokenDto tokenDto = userService.login(userDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.ACCESSTOKEN_HEADER, "Bearer " + tokenDto.getAccessToken());
        httpHeaders.add(JwtFilter.REFRESHTOKEN_HEADER, "Bearer " + tokenDto.getRefreshToken());

        return new ResponseEntity<>(tokenDto, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/refresh")
    public ResponseEntity<TokenDto> refresh(HttpServletRequest request) {

        String refreshToken = request.getHeader(JwtFilter.REFRESHTOKEN_HEADER);
        TokenDto tokenDto = userService.refresh(refreshToken);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.ACCESSTOKEN_HEADER, "Bearer " + tokenDto.getAccessToken());
        httpHeaders.add(JwtFilter.REFRESHTOKEN_HEADER, "Bearer " + tokenDto.getRefreshToken());
        return new ResponseEntity<>(tokenDto, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/info")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<User> getMyUserInfo(){
        return ResponseEntity.ok(userService.getMyUserWithAuthorities().get());
    }

    @GetMapping("/info/{email}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<User> getUserInfo(@PathVariable String email){
        return ResponseEntity.ok(userService.getUserWithAuthorities(email).get());
    }
}