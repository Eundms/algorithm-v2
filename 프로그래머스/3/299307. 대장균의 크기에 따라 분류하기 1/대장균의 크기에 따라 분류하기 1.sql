SELECT ID, CASE 
            WHEN SIZE_OF_COLONY>100 AND SIZE_OF_COLONY<=1000 THEN 'MEDIUM'
            WHEN SIZE_OF_COLONY>1000 THEN 'HIGH'
            ELSE 'LOW' 
            END AS SIZE FROM ECOLI_DATA ORDER BY ID;