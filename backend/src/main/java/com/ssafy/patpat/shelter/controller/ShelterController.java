//package com.ssafy.patpat.shelter.controller;
//
//import com.ssafy.patpat.board.dto.RequestBoardDto;
//import com.ssafy.patpat.common.dto.ResponseMessage;
//import com.ssafy.patpat.shelter.dto.*;
//import com.ssafy.patpat.shelter.entity.Gugun;
//import com.ssafy.patpat.shelter.entity.Shelter;
//import com.ssafy.patpat.shelter.entity.Sido;
//import com.ssafy.patpat.shelter.service.ShelterService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import java.util.List;
//
//@RestController
//@RequestMapping("/shelters")
//@Api(tags = {"05. Shelter"},description = "보호소 관련 서비스")
//public class ShelterController {
//    @Autowired
//    //ShelterService service;
//
//    /**
//     * 시도 리스트 반환
//     * @return
//     */
//    @GetMapping("/sidos")
//    @ApiOperation(value = "시도 리스트 조회", notes = "시도 리스트 조회")
//    public ResponseEntity<Object> selectSidoList(RequestBoardDto requestBoardDto){
//        //service 호출
//        List<Sido> list = service.sidoList();
//        if(list!=null){
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(list);
//        }else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(new ResponseMessage("FAIL"));
//        }
//    }
//    /**
//     * 구군 리스트 반환
//     * @return
//     */
//    @GetMapping("/guguns")
//    @ApiOperation(value = "구군 리스트 조회", notes = "구군 리스트 조회")
//    public ResponseEntity<Object> selectGugunList(@RequestParam String sidoCode){
//        //service 호출
//        List<Gugun> gugunList = service.gugunList(sidoCode);
//        if(gugunList!=null){
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(gugunList);
//        }else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(new ResponseMessage("FAIL"));
//        }
//    }
//    /**
////     * 견종 정보 반환
////     * @return
////     */
////    @GetMapping("/mbti/{mbtiId}")
////    @ApiOperation(value = "견종 정보 반환", notes = "견종 정보 반환(이미지, 견종)")
////    public ResponseEntity<Object> selectBreedByMbti(@PathVariable String mbtiId){
////        //service 호출
////        BreedDto breedDto = service.selectBreedByMbti(mbtiId);
////        if(breedDto!=null){
////            return ResponseEntity.status(HttpStatus.OK)
////                    .body(breedDto);
////        }else{
////            return ResponseEntity.status(HttpStatus.NOT_FOUND)
////                    .body(new ResponseMessage("FAIL"));
////        }
////    }
//    /**
//     * 8도, 전체 해당 견종을 가진
//     * @return
//     */
//    @GetMapping("/mbti/{mbtiId}")
//    @ApiOperation(value = "견종 정보 반환", notes = "견종 정보 반환(이미지, 견종)")
//    public ResponseEntity<Object> selectBreedByMbti(@PathVariable String mbtiId){
//        //service 호출
//        BreedDto breedDto = service.selectBreedByMbti(mbtiId);
//        if(breedDto!=null){
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(breedDto);
//        }else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(new ResponseMessage("FAIL"));
//        }
//    }
//    /**
//     * 보호소 조회
//     * @return
//     */
//    @GetMapping
//    @ApiOperation(value = "보호소 조회", notes = "보호소 리스트 조회")
//    public ResponseEntity<Object> selectShelterList(RequestShelterDto requestShelterDto){
//        //service 호출
//        List<Shelter> shelterDtoList = service.shelterList(requestShelterDto);
//        if(shelterDtoList!=null){
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(shelterDtoList);
//        }else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(new ResponseMessage("FAIL"));
//        }
//    }
//    /**
//     * 보호소 상세 조회
//     * @return
//     */
//    @GetMapping("/{shelterId}")
//    @ApiOperation(value = "보호소 상세 조회", notes = "보호소 상세 조회")
//    public ResponseEntity<Object> detailShelter(@PathVariable int shelterId){
//        ShelterDto shelterDto = service.detailShelter(shelterId);
//        if(shelterDto!=null){
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(shelterDto);
//        }else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(new ResponseMessage("FAIL"));
//        }
//    }
//    /**
//     * 보호소 등록
//     * @return
//     */
//    @PostMapping
//    @ApiOperation(value = "보호소 등록", notes = "보호소 등록")
//    public ResponseEntity<ResponseMessage> insertShelter(RequestShelterInsertDto requestShelterInsertDto){
//        //ResponseMessage responseMessage = service.insertS
//        if(true){
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(new ResponseMessage("SUCCESS"));
//        }else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(new ResponseMessage("FAIL"));
//        }
//    }
//    /**
//     * 보호소 수정
//     * @return
//     */
//    @PostMapping("/{shelterId}")
//    @ApiOperation(value = "보호소 수정", notes = "보호소 수정")
//    public ResponseEntity<ResponseMessage> updateShelter(@PathVariable String shelterId, @RequestPart List<MultipartFile> uploadFile, ShelterDto shelterDto){
//        ResponseMessage responseMessage = service.updateShelter(shelterId,uploadFile,shelterDto);
//        if(responseMessage.getMessage()=="SUCCESS"){
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(responseMessage);
//        }else{
//            responseMessage.setMessage("FAIL");
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(responseMessage);
//        }
//    }
//    /**
//     * 보호소 인증
//     * @return
//     */
//    @GetMapping("/auth/{authCode}")
//    @ApiOperation(value = "보호소 인증", notes = "보호소 인증")
//    public ResponseEntity<ResponseMessage> authShelter(@PathVariable String authCode){
//        ResponseMessage responseMessage = service.AuthShelter(authCode);
//        if(responseMessage.getMessage()=="SUCCESS"){
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(new ResponseMessage("SUCCESS"));
//        }else{
//            responseMessage.setMessage("FAIL");
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(responseMessage);
//        }
//    }
//}