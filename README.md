# Ch3_Calender_Project

### API 명세서
> 일정 관리 앱  API 설계

| 기능 | Method | URL | request | response | 상태코드 |
|:------:|:------:|-----|------|------|------|
|전체 일정 조회|GET   |/main/calenderList |요청 body          |다건 응답 정보|200 정상조회    |
|일정 상세 화면|GET   |/main/clenderDetail|요청 param         |단건 응답 정보|200 정상조회    |
|일정 등록    |POST  |/main/enroll       |요청 body          |등록 정보    |200 정상등록    |
|일정 삭제    |DELETE|/main/delete       |요청 param 요청 body|수정 정보    |200 정상삭제    |
|일정 수정    |PUT   |/main/update       |요청 param         |삭제 정보    |200 정상수정/등록|

   
###  ERD
---
<img width="872" alt="image" src="https://github.com/user-attachments/assets/6aecbf4f-df84-48a0-9fc7-9e4c69435310">

https://www.erdcloud.com/d/zfwmJFNWTwWzABwfz


   
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
  ```sql
 CREATE TABLE user(user_id ,
                         name ,
                         user_pw ,
                         email
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
