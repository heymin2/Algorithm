-- 코드를 작성해주세요
SELECT ed.ID, 
    case when es.CHILD_COUNT is null then 0
        else es.CHILD_COUNT
    end as CHILD_COUNT
FROM ECOLI_DATA ed
LEFT JOIN (SELECT PARENT_ID, COUNT(*) AS CHILD_COUNT
    FROM ECOLI_DATA
    GROUP BY PARENT_ID
    HAVING PARENT_ID IS NOT NULL) es ON ed.ID = es.PARENT_ID;
