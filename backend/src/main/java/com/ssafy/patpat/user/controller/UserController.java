package com.ssafy.patpat.user.controller;

import com.ssafy.patpat.common.dto.ResponseMessage;
import com.ssafy.patpat.user.dto.FavoriteDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
@Api(tags = {"06. User"},description = "유저 관련 서비스")
public class UserController {

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
}
