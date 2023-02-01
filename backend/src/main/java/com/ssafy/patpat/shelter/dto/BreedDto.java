package com.ssafy.patpat.shelter.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssafy.patpat.common.dto.FileDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Builder
public class BreedDto {
    @Schema(example = "견종")
    private String breedName;
    @Schema(example = "fileUrl:dd.png")
    private FileDto fileDto;
}