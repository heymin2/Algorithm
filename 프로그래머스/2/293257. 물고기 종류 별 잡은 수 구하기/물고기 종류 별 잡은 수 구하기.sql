-- 코드를 작성해주세요
SELECT COUNT(*) AS FISH_COUNT, fn.FISH_NAME
FROM FISH_INFO fi
JOIN FISH_NAME_INFO fn ON fi.FISH_TYPE = fn.FISH_TYPE
GROUP BY fn.FISH_NAME
ORDER BY FISH_COUNT DESC