# Ch3_Calender_Project

### API 명세서
> 일정 관리 앱  API 설계

|기능|Method|URL|request|response|상태코드|
|:------:|:------:|-----|------|------|------|
|전체 일정 조회|GET|테스트3|테스트3|테스트3|200 정상조회|
|일정 상세 화면|GET|테스트3|테스트3|테스트3|200 정상조회|
|일정 등록|POST|테스트3|테스트3|테스트3|200 정상등록|
|일정 삭제|DELETE|테스트3|테스트3|테스트3|200 정상삭제|
|일정 수정|PUT|테스트3|테스트3|테스트3|200 정상수정/등록|

###  ERD

### sql
---
1.테이블을 생성 (Create)
  ```sql
  CREATE TABLE canlender(contents_no ,
                         user_id ,
                         schedules_date ,
                         title,
                         contents
                         );
  ```
2.전체 일정 조회(Selete)
  ```sql
  SELETE * FROM calender;
  ```
3.선택 일정 조회(Selete)
```sql
  SELETE * FROM calender WHERE contents_no;
```
4.일정 등록(Insert)
  ```sql
  INSERT INTO calender(contents_no , user_id , schedules_date ,title, contents)
                VALUES(        ,          ,                  ,     ,         );
  ```
5.선택 일정 수정(Update)
  ```sql
  UPDATE calender SET             where contents_no = ;
  ```
6.선택 일정 삭제(Delete)
  ```sql
  DELETE FROM calender WHERE contents_no = ;
  ``` 
