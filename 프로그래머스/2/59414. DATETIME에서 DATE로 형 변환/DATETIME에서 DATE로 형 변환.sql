-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, to_char(DATETIME, 'yyyy-mm-dd') AS 날짜
FROM ANIMAL_INS order by animal_id;