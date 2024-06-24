# Write your MySQL query statement below
select max(num) as num from
(select num,count(num) as countNum from MyNumbers
group by num
order by countNum) as temp
where countNum=1
