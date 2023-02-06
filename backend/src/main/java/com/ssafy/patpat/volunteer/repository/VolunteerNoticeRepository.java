package com.ssafy.patpat.volunteer.repository;

import com.ssafy.patpat.common.code.Reservation;
import com.ssafy.patpat.volunteer.entity.VolunteerNotice;
import com.ssafy.patpat.volunteer.mapping.VolunteerShelterIdMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolunteerNoticeRepository extends JpaRepository<VolunteerNotice, Long> {

    /**
     * 구군으로 탐색
     * */
    List<VolunteerNotice> findWithShelterByShelterGugunCodeAndReservationStateCodeAndVolunteerDateGreaterThan(String gugunCode, Reservation reservation, String volunteerDate, PageRequest pageRequest);

    /**
     * 보호소 id로 탐색
     * */
    List<VolunteerNotice> findWithShelterByShelterShelterIdAndReservationStateCodeAndVolunteerDateGreaterThan(Integer shelterId, Reservation reservation, String volunteerDate, PageRequest pageRequest);

    /**
     * 월별로 탐색
     * */
    List<VolunteerNotice> findWithShelterByShelterShelterIdAndVolunteerDateLikeOrderByVolunteerDateAsc(Integer shelterId, String volunteerDate);
}
