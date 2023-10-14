-- 코드를 입력하세요
SELECT 
    book.author_id as AUTHOR_ID, 
    author.author_name as AUTHOR_NAME, 
    book.category as CATEGORY,
    sum(book.price * book_sales.sales) as TOTAL_SALES from book 
    left join book_sales 
        on book.book_id = book_sales.book_id 
    left join author 
        on book.author_id = author.author_id
    where book_sales.sales_date LIKE '2022-01%'
    group by book.author_id, book.category
    order by book.author_id asc , book.category desc;