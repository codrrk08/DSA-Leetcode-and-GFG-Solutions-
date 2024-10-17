# Write your MySQL query statement below
-- select employee_id,department_id from Employee where primary_flag = 'Y' or employee_id in  ();
-- select employee_id, count(employee_id) as cnt from Employee group by employee_id having cnt=1;
select employee_id,department_id from Employee where primary_flag='Y' or employee_id in (select employee_id from Employee group by employee_id having count(employee_id)=1 );