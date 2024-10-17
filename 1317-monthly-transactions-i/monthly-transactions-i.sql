# Write your MySQL query statement below
with cte1 as 
    (select 
        date_format(trans_date,'%Y-%m') as month,
        country, count(*) as trans_count,
        sum(amount) as trans_total_amount 
    from Transactions 
    group by month,country
),
cte2 as
    (select 
        date_format(trans_date,'%Y-%m') as month,
        country,count(*) as approved_count,
        sum(amount) as approved_total_amount 
    from Transactions
    where state = 'approved' 
    group by month,country
)
select 
    cte1.month, 
    cte1.country, 
    cte1.trans_count, 
    ifnull(cte2.approved_count,0) as approved_count, 
    cte1.trans_total_amount, 
    ifnull(cte2.approved_total_amount,0) as approved_total_amount 
from cte1 
left join cte2 
    on cte1.month = cte2.month 
    and (cte1.country = cte2.country OR (cte1.country IS NULL AND cte2.country IS NULL))