-- 코드를 입력하세요
SELECT history_id as HISTORY_ID, car_id as CAR_ID, start_date as START_DATE, end_date as END_DATE,
(case when datediff(end_date,start_date)<29 
then "단기대여"
else "장기대여"
end )as RENT_TYPE
from car_rental_company_rental_history
where start_date like '%2022-09-%'
order by history_id desc;


SELECT
HISTORY_ID ,
CAR_ID ,
DATE_FORMAT(START_DATE,'%Y-%m-%d') as START_DATE ,
DATE_FORMAT(END_DATE,'%Y-%m-%d') as END_DATE ,
(CASE WHEN DATEDIFF(END_DATE , START_DATE) < 29
    THEN '단기 대여'
    ELSE '장기 대여'
END) AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE 1=1
AND DATE_FORMAT(START_DATE,'%Y-%m') like '%2022-09%'
ORDER BY HISTORY_ID DESC;






















