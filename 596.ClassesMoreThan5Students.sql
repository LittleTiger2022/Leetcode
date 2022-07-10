//
select class from Courses
group by class
having count(distinct student)>=5
;

// use temp table

select class 
from 
( select class, count(distinct student) as num
from courses
group by class) as temp_table
where 
num>=5
;
