package com.ssafy.patpat.user.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private TokenDto tokenDto;
    private UserDto userDto;
}