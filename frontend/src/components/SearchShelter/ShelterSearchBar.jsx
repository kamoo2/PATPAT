import { style } from '@mui/system';
import { useQuery } from '@tanstack/react-query';
import { getBreedsList, getGugunList, getShelterList } from 'apis/api/shelter';
import ShelterSearchBadge from 'components/Common/Badge/ShelterSearchBadge';
import React, { useRef, useState } from 'react';
import Select from 'react-select';
import { useRecoilState, useRecoilValue } from 'recoil';
import { gugunIsDisabledState, selectBreedState, selectGugunState, selectSidoState } from 'recoil/atoms/shelter';
import { changeBreedList, changeGugunList } from 'utils/changeSelectTemplate';
import styles from './ShelterSearchBar.module.scss';
export default React.memo(function ShelterSearchBar() {
  const sido = useRecoilValue(selectSidoState);
  const [gugun, setGugun] = useRecoilState(selectGugunState);
  const [breed, setBreed] = useRecoilState(selectBreedState);
  const [gugunIsDisabled, setGugunIsDisabled] = useRecoilState(gugunIsDisabledState);
  const gugunSelectRef = useRef(null);
  const { data: gugunList, isLoading: gugunLoading } = useQuery(
    ['gugunList', sido.sidoCode],
    () => getGugunList(sido.sidoCode),
    {
      refetchOnWindowFocus: false,
      onSuccess: data => {
        if (data.length !== 0) {
          setGugunIsDisabled(false);
        }
      },
    }
  );
  const { data: breedList, isLoading: breedLoading } = useQuery(['breedList'], () => getBreedsList(), {
    refetchOnWindowFocus: false,
  });

  const handleChangeOnGugunList = selected => {
    setGugun({ gugunCode: selected.value, name: selected.label });
  };
  const handleChangeOnBreedList = selected => {
    setBreed({ breedId: selected.value, name: selected.label });
  };

  const handleClickSearch = () => {};
  if (gugunLoading || breedLoading) return;
  return (
    <div className={styles.select__wrapper}>
      <div className={styles['select-inner']}>
        <div className={styles['select-item']}>
          <div className={styles['select-label']}>구군</div>
          <Select
            ref={gugunSelectRef}
            onChange={handleChangeOnGugunList}
            className="basic-single"
            options={changeGugunList(gugunList)}
            placeholder="선택해주세요"
            isDisabled={gugunIsDisabled}
            value={gugun.gugunCode ? { value: gugun.gugunCode, label: gugun.name } : null}
          />
        </div>
        <div className={styles['select-item']}>
          <div className={styles['select-label']}>견종</div>
          <Select
            onChange={handleChangeOnBreedList}
            className="basic-single"
            options={changeBreedList(breedList)}
            placeholder="선택해주세요"
            value={breed.breedId ? { value: breed.breedId, label: breed.name } : null}
          />
        </div>
      </div>
      <div className={styles['selected-wrap']}>
        <div className={styles.selected}>
          {sido.sidoCode && <ShelterSearchBadge value={sido.name} type="sido" />}
          {gugun.gugunCode && <ShelterSearchBadge gugunSelectRef={gugunSelectRef} value={gugun.name} type="gugun" />}
          {breed.breedId && <ShelterSearchBadge value={breed.name} type="breed" />}
        </div>
        <button onClick={handleClickSearch} className={styles['search-btn']}>
          검색
        </button>
      </div>
    </div>
  );
});
