import { createBrowserRouter } from 'react-router-dom';
import MainLayout from 'layouts/MainLayout';
import Home from 'pages/Home/Home';
import LoginLayout from 'layouts/LoginLayout';
import Login from 'pages/Login/Login';
import NotFound from 'pages/NotFound/NotFound';
import MbtiLayout from 'layouts/MbtiLayout';
import Result from 'pages/Mbti/Result';
import Start from 'pages/Mbti/Start';
import Test from 'pages/Mbti/Test';
import Intro from 'pages/Intro/Intro';
import Statistics from 'pages/Intro/Statistics';
import Vision from 'pages/Intro/Vision';
import PlainLayout from 'layouts/PlainLayout';
import VideoRoomComponent from 'pages/Consulting/Meeting/components/VideoRoomComponent';
import Waiting from 'pages/Consulting/Waiting/Waiting';
import Volunteer from 'pages/Volunteer/Volunteer';
import Address from 'pages/Volunteer/Address';
import MyPage from 'pages/MyPage/MyPage';
import MyMissing from 'components/MyPage/MyMissing';
import Report from 'pages/Report/Report';
import MoreInfo from 'pages/Mbti/MoreInfo';
import InfoDetail from 'components/Community/Info/InfoDetail';
import FreeShareDetail from 'components/Community/FreeShare/FreeShareDetail';
import MissingDogDetail from 'pages/Report/MissingDog/MissingDogDetail';
import ReportCreate from 'pages/Report/Create/ReportCreate';
import KakaoLogin from 'pages/Login/SNSLogin/Kakao/KakaoLogin';
import NaverLogin from 'pages/Login/SNSLogin/Naver/NaverLogin';
import GoogleLogin from 'pages/Login/SNSLogin/Google/GoogleLogin';
import ReportUpdate from 'pages/Report/Update/ReportUpdate';
import Shelter from 'pages/Shelter/Shelter';
import SearchShelter from 'pages/SearchShelter/SearchShelter';
import PersonalDogDetail from 'pages/Report/PersonalDog/PersonalDogDetail';
import ShelterIntro from 'pages/Shelter/ShelterIntro/ShelterIntro';
import ShelterProtect from 'pages/Shelter/ShelterProtect/ShelterProtect';
import ShelterVolunteer from 'pages/Shelter/ShelterVolunteer/ShelterVolunteer';
import ShelterConsulting from 'pages/Shelter/ShelterConsulting/ShelterConsulting';
import ShelterProtectEnroll from 'pages/Shelter/ShelterProtect/ShelterProtectEnroll';
import ProtectsDetail from 'components/Common/Protects/ProtectsDetail';
import { getBreedsList } from 'apis/api/shelter';
import InfoList from 'components/Community/Info/InfoList';
import InfoUpdate from 'components/Community/Info/InfoUpdate';
import AdoptionReviewList from 'components/Community/AdoptionReview/AdoptionReviewList';
import AdoptionReviewUpdate from 'components/Community/AdoptionReview/AdoptionReviewUpdate';
import FreeShareList from 'components/Community/FreeShare/FreeShareList';
import FreeShareUpdate from 'components/Community/FreeShare/FreeShareUpdate';
import InfoWrite from 'components/Community/Info/InfoWrite';
import FreeShareWrite from 'components/Community/FreeShare/FreeShareWrite';
import AdoptionReviewWrite from 'components/Community/AdoptionReview/AdoptionReviewWrite';

const router = createBrowserRouter([
  {
    path: '/',
    element: <MainLayout />,
    errorElement: <NotFound />, // 라우터에 없는 경로로 이동시 NotFound 컴포넌트 화면에 띄운다.
    children: [
      { index: true, path: '/', element: <Home /> },
      { path: 'intro', element: <Intro /> },
      { path: 'statistics', element: <Statistics /> },
      { path: 'vision', element: <Vision /> },
      { path: 'volunteer', element: <Volunteer /> },
      { path: 'mypage', element: <MyPage /> },
      { path: 'mypage/mymissing/:id', element: <MyMissing /> },
      { path: 'volunteer/address', element: <Address /> },
      { path: 'report', element: <Report /> },
      { path: 'shelter/search', element: <SearchShelter /> },
      { path: 'protects/:id', element: <ProtectsDetail /> },
      {
        path: 'shelter/:shelterId',
        element: <Shelter />,
        children: [
          { path: 'intro', element: <ShelterIntro /> },
          { path: 'protect', element: <ShelterProtect /> },
          {
            path: 'protect/enroll',
            element: <ShelterProtectEnroll />,
            loader: async () => {
              return getBreedsList();
            },
          },
          { path: 'volunteer', element: <ShelterVolunteer /> },
          { path: 'consulting', element: <ShelterConsulting /> },
        ],
      },
      { path: 'community/info', element: <InfoList /> },
      { path: 'community/infodetail/:id', element: <InfoDetail /> },
      { path: 'community/adoptionreview', element: <AdoptionReviewList /> },
      { path: 'community/freeshare', element: <FreeShareList /> },
      { path: 'community/freesharedetail/:id', element: <FreeShareDetail /> },
      { path: 'report/missing/:id', element: <MissingDogDetail /> },
      { path: 'report/personal/:id', element: <PersonalDogDetail /> },
      { path: 'report/personal/:id/update', element: <ReportUpdate /> },
      { path: 'report/missing/:id/update', element: <ReportUpdate /> },
      { path: 'report/create', element: <ReportCreate /> },
      { path: 'community/freeshareupdate/:id', element: <FreeShareUpdate /> },
      { path: 'community/infoupdate/:id', element: <InfoUpdate /> },
      { path: 'community/adoptionreviewupdate/:id', element: <AdoptionReviewUpdate /> },
      { path: 'community/adoptionreviewwrtie', element: <AdoptionReviewWrite /> },
      { path: 'community/freesharewrite', element: <FreeShareWrite /> },
      { path: 'community/infowrite', element: <InfoWrite /> },
    ],
  },
  {
    path: '/login',
    element: <LoginLayout />,
    errorElement: <giNotFound />,
    children: [
      { index: true, element: <Login /> },
      { path: 'kakao', element: <KakaoLogin /> },
      { path: 'naver', element: <NaverLogin /> },
      { path: 'google', element: <GoogleLogin /> },
    ],
  },
  {
    path: '/mbti',
    element: <MbtiLayout />,
    errorElement: <NotFound />,
    children: [
      { index: true, element: <Start /> },
      { path: 'test', element: <Test /> },
      { path: 'result', element: <Result /> },
      { path: 'result/map', element: <MoreInfo /> },
    ],
  },
  {
    path: '/consulting',
    element: <PlainLayout />,
    errorElement: <NotFound />,
    children: [
      { path: 'meeting', element: <VideoRoomComponent /> },
      { path: 'waiting', element: <Waiting /> },
    ],
  },
]);

export default router;
