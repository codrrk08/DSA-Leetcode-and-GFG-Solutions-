# Write your MySQL query statement 
select 
    contest_id,round(( count(user_id)/total.total_count)*100,2) as percentage
from 
    Register,(select distinct count(user_id) as total_count from Users) as total
group by 
    contest_id
order by
    percentage desc, contest_id

