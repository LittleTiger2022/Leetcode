// s1
select name as "customers" from Customers
left join Orders 
on Customers.id = Orders.customerId
where Orders.id is null;

// s2
# Write your MySQL query statement below
select name as "customers" from Customers
where Customers.id not in 
( 
select customerid from orders
); 
