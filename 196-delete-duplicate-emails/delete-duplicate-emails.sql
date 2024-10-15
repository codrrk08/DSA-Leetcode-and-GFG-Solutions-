# Write your MySQL query statement below
-- create temporary table temp as select min(id) as id from Person group by email;

-- delete from Person
-- where id not in (select id from temp);

-- drop temporary table temp;
WITH CTE AS (
    SELECT min(id) AS id FROM Person GROUP BY email
)
DELETE FROM Person
WHERE id NOT IN (
    SELECT id
    FROM CTE
);

