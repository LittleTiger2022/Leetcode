//
update salary
set 
   sex = case sex
   when 'm' then 'f'
   else 'm'
   end;

// s2
update Salary set sex =(case when sex = 'm' then 'f' else 'm' end)
