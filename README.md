# [Spring 7기] CH_3 일정 관리 앱 만들기 [Ch3_Calender_Project]

### API 명세서
> 일정 관리 앱  API 설계

| 기능 | Method | URL | request | response | 상태코드 |
|:-------:|:-----:|----|-----|------|------|
|전체 일정 조회|GET   |./calender           |요청 body          |다건 응답 정보|200 정상조회    |
|일정 상세 화면|GET   |./clender/{id}        |요청 param         |단건 응답 정보|200 정상조회 / 400 Bad Request("없는 일정입니다." |
|일정 등록    |POST  |./calender           |요청 body          |등록 정보    |200 정상등록   |
|일정 삭제    |DELETE|./calender{id}       |요청 param 요청 body|수정 정보    |200 정상삭제 / 404 Not Fount   |
|일정 수정    |PUT   |./calender{id}       |요청 param         |삭제 정보    |200 정상수정/등록|
   
###  ERD
---
<img width="784" alt="image" src="https://github.com/user-attachments/assets/5b0dd483-adae-4844-b7ed-0c631afb5477">

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
