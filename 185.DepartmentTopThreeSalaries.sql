//s1
select d.name as Department, e.name as Employee, e.salary as Salary
from Department d
join Employee e
on d.id = e.departmentId
where
3>(select count(distinct e2.salary)
from Employee e2
where 
e2.salary > e.salary and e.departmentId=e2.departmentId
)

