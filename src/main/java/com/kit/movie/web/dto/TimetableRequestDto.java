package com.kit.movie.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class TimetableRequestDto {
    String time;
    Integer price;
    Integer percentDiscount;
    Integer flatDiscount;
}
