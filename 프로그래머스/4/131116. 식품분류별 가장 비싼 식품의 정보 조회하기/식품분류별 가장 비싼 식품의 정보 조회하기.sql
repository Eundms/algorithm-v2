SELECT f.category as CATEGORY ,f.price as MAX_PRICE, f.product_name as PRODUCT_NAME
from food_product as f
where 
f.price IN (SELECT max(PRICE) FROM FOOD_PRODUCT
          WHERE category in ("국","과자","김치","식용유")
             GROUP BY CATEGORY
          )
AND f.category in ("국","과자","김치","식용유")
order by f.price desc;