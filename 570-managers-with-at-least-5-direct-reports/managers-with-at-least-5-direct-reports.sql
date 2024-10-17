# Write your MySQL query statement below
select name from Employee where id in (select a.id from Employee a join Employee b on a.id=b.managerId group by a.id having count(*)>=5);