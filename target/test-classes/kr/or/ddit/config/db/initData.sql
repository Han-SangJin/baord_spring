SELECT *
FROM MEMBER1;

/*DELETE users;*/
TRUNCATE TABLE MEMBER1;

insert into member1 values('a001','123',sysdate);
insert into member1 values('abc','abc',sysdate);

COMMIT;