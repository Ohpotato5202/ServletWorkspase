SELECT * FROM C##KH.JOB;

-- 관리자 계정으로 KH테이블에 접근할 수 있는 권한부여
GRANT ALL ON C##KH.EMPLOYEE TO C##MYBATIS;
GRANT SELECT ON C##KH.DEPARTMENT TO C##MYBATIS;
GRANT SELECT ON C##KH.JOB TO C##MYBATIS;

GRANT CREATE SYNONYM TO C##MYBATIS;

-- 동의어 생성 -> 기본권한에 포함되지 않음
-- SYNONYM : C##KH.EMPLOYEE == emp
CREATE SYNONYM EMP FOR C##KH.EMPLOYEE;
CREATE SYNONYM DEPT FOR C##KH.DEPARTMENT;
CREATE SYNONYM JOB FOR C##KH.JOB;

SELECT * FROM DEPT;