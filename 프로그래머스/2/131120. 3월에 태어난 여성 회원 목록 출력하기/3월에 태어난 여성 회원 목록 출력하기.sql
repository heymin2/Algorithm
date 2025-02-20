-- 코드를 입력하세요
SELECT MEMBER_iD, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE GENDER = 'W' 
 AND DATE_OF_BIRTH like '%-03-%' 
 AND TLNO IS NOT NULL
ORDER BY MEMBER_ID;