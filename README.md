# Finance Data Collector
증권사 API를 이용해 분봉을 수집합니다.

## 지원 증권사
* 대신증권

## 사용 방법
- CybosPlus 설치
- .env.sample 을 .env로 이름 변경 후 환경변수 설정
- sqldump.sql을 이용해 테이블 생성
- 작업 스케쥴러 또는 cron을 이용해 매일 09시 가동