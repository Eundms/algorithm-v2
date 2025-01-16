WITH RankedData AS (
    SELECT 
        ID,
        size_of_colony,
        NTILE(4) OVER (ORDER BY size_of_colony DESC) AS percentile_group
    FROM 
        ecoli_data
)
SELECT 
    ID,
    CASE 
        WHEN percentile_group = 1 THEN 'CRITICAL' -- 상위 25%
        WHEN percentile_group = 2 THEN 'HIGH' -- 25~50%
        WHEN percentile_group = 3 THEN 'MEDIUM' -- 50~75%
        WHEN percentile_group = 4 THEN 'LOW' -- 하위 25%
    END AS COLONY_NAME
FROM 
    RankedData
ORDER BY 
    ID;
