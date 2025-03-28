-- 코드를 입력하세요
SELECT ri.FOOD_TYPE, REST_ID, REST_NAME, ri.FAVORITES
FROM REST_INFO ri
JOIN (
    SELECT FOOD_TYPE, MAX(FAVORITES) AS FAVORITES
    FROM REST_INFO
    GROUP BY FOOD_TYPE
) AS MAX_VALUE ON ri.FOOD_TYPE = MAX_VALUE.FOOD_TYPE AND ri.FAVORITES = MAX_VALUE.FAVORITES
ORDER BY FOOD_TYPE DESC