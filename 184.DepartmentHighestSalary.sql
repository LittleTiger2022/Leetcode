//
# Write your MySQL query statement below
select b.name as Department, a.name as Employee, salary 
from Employee a
left join Department b 
on a.departmentId=b.id
where (a.departmentId, salary) in
( select 
 departmentId, MAX(salary)
from Employee
group by departmentId
)
;

