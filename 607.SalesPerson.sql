// s1
select name from SalesPerson
where sales_id not in
(select sales_id from Orders b
left join Company c
on b.com_id = c.com_id
where c.name="RED")
;

