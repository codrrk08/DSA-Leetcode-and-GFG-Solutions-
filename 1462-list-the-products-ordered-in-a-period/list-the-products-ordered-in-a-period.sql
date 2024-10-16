# Write your MySQL query statement below
-- SELECT P.product_name, SUM(O.unit) AS unit FROM Products P INNER JOIN Orders O 
-- ON P.product_id = O.product_id WHERE order_date BETWEEN '2020-02-01' AND '2020-02-29'
-- GROUP BY O.product_id HAVING unit>=100;
select a.product_name,sum(b.unit) as unit from 
Products a join Orders b on a.product_id = b.product_id where 
Month(order_date)=02 && Year(order_date)=2020 
group by b.product_id 
having sum(b.unit)>=100  ;
