import { useQuery } from '@tanstack/react-query';
import { getVolReservationOfUser } from 'apis/api/volunteer';
import React from 'react';
import styles from './ReservationList.module.scss';
import VolunteerItem from '../Items/VolunteerItem';

export default function VolunteerList({ userId }) {
  const { data, isLoading } = useQuery({
    queryKey: ['myVolunteerList'],
    queryFn: () => getVolReservationOfUser(userId),
  });

  if (isLoading) return;

  return (
    <div className={styles.container}>
      {data.length === 0 ? (
        <div className={styles['no-data']}>신청한 봉사 정보가 없습니다.</div>
      ) : (
        data.map(item => <VolunteerItem key={item.reservationId} item={item} />)
      )}
    </div>
  );
}
