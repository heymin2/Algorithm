SELECT f.ID, n.FISH_NAME, f.LENGTH
FROM FISH_INFO f
JOIN FISH_NAME_INFO n ON f.FISH_TYPE = n.FISH_TYPE
WHERE f.LENGTH = (
    SELECT MAX(LENGTH) 
    FROM FISH_INFO 
    WHERE FISH_TYPE = f.FISH_TYPE
)
ORDER BY f.ID;