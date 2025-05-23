-- 코드를 작성해주세요
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
WHERE SKILL_CODE & (SELECT BIT_OR(code)
                FROM SKILLCODES
                WHERE name IN ('Python', 'C#')) > 0
ORDER BY ID;