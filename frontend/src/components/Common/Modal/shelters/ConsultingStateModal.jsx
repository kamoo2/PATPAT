import React from 'react';
import ModalConsultingFrame from '../ModalConsultingFrame';
import ModalFrame from '../ModalFrame';
import styles from './ConsultingStateModal.module.scss';
export default function ConsultingStateModal({ isOpen, handleClickModalClose, state, stateCode }) {
  const handleMouseOver = (e, state) => {
    const target = document.querySelector(`.${styles.state}`);
    const orig = e;
    target.textContent = orig.target.textContent;
    target.classList.remove(target.classList[1]);
    if (state === 'one') {
      target.classList.add(styles.one);
    } else if (state === 'two') {
      target.classList.add(styles.two);
    } else if (state === 'three') {
      target.classList.add(styles.three);
    } else if (state === 'four') {
      target.classList.add(styles.four);
    } else if (state === 'five') {
      target.classList.add(styles.five);
    } else if (state === 'six') {
      target.classList.add(styles.six);
    }
  };
  const handleMouseOut = e => {
    const target = document.querySelector(`.${styles.state}`);
    target.textContent = state;
    target.classList.remove(target.classList[1]);
    if (stateCode === 0) {
      target.classList.add(styles.zero);
    } else if (stateCode === 1) {
      target.classList.add(styles.one);
    } else if (stateCode === 2) {
      target.classList.add(styles.two);
    } else if (stateCode === 3) {
      target.classList.add(styles.three);
    } else if (stateCode === 4) {
      target.classList.add(styles.four);
    } else if (stateCode === 5) {
      target.classList.add(styles.five);
    } else {
      target.classList.add(styles.six);
    }
  };
  const question = stateCode => {
    if (stateCode === 0) {
      // 대기인 상태
      return (
        <>
          <div className={`${styles.select} ${styles.approve}`}>
            <span>1</span>
            <span
              className={styles.btn}
              onMouseOver={e => handleMouseOver(e, 'one')}
              onMouseOut={e => handleMouseOut(e)}
            >
              승인
            </span>
          </div>
          <div className={`${styles.select} ${styles.reject}`}>
            <span>2</span>
            <span
              className={styles.btn}
              onMouseOver={e => handleMouseOver(e, 'two')}
              onMouseOut={e => handleMouseOut(e)}
            >
              거절
            </span>
          </div>
        </>
      );
    } else if (stateCode === 1) {
      // 승인 -> 방생성 , 단 당일에만 활성화
      return (
        <div className={`${styles.select} ${styles.open}`}>
          <span
            className={styles.btn}
            onMouseOver={e => handleMouseOver(e, 'three')}
            onMouseOut={e => handleMouseOut(e)}
          >
            방 생성
          </span>
          하시겠습니까?
        </div>
      );
    } else if (stateCode === 4) {
      // 진행 중 -> 완료 , 불참 두가지 경우
      return (
        <>
          <div className={`${styles.select} ${styles.approve}`}>
            <span>1</span>
            <span
              className={styles.btn}
              onMouseOver={e => handleMouseOver(e, 'five')}
              onMouseOut={e => handleMouseOut(e)}
            >
              상담 완료
            </span>
          </div>
          <div className={`${styles.select} ${styles.reject}`}>
            <span>2</span>
            <span
              className={styles.btn}
              onMouseOver={e => handleMouseOver(e, 'six')}
              onMouseOut={e => handleMouseOut(e)}
            >
              상담 불참
            </span>
          </div>
        </>
      );
    }
  };
  const customStyle = () => {
    if (stateCode === 0) {
      return `${styles.state} ${styles.zero}`;
    } else if (stateCode === 1) {
      return `${styles.state} ${styles.one}`;
    } else if (stateCode === 2) {
      return `${styles.state} ${styles.two}`;
    } else if (stateCode === 3) {
      return `${styles.state} ${styles.three}`;
    } else if (stateCode === 4) {
      return `${styles.state} ${styles.four}`;
    } else if (stateCode === 5) {
      return `${styles.state} ${styles.five}`;
    } else {
      return `${styles.state} ${styles.six}`;
    }
  };
  return (
    <ModalConsultingFrame isOpen={isOpen} handleClickModalClose={handleClickModalClose}>
      <div className={styles.title}>상담 상태 변경</div>
      <div className={styles['state-info']}>
        현재는 <span className={customStyle()}>{state}</span> 상태입니다.
      </div>
      <div className={styles['select-wrap']}>{question(stateCode)}</div>
    </ModalConsultingFrame>
  );
}
