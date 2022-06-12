package com.kit.movie.web.dto.reservation;

import com.kit.movie.domain.reservation.Reservation;
import com.kit.movie.domain.timetable.Timetable;
import com.kit.movie.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReservationSaveRequestDto {
    private Long timetableId;
    private String userName;

    public ReservationSaveRequestDto(Long timetableId, String userName) {
        this.timetableId = timetableId;
        this.userName = userName;
    }

    public Reservation toEntity(User user, Timetable timetable){
        return Reservation.builder()
                .user(user)
                .timetable(timetable)
                .build();
    }
}
