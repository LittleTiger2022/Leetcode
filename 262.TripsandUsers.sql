//

# Write your MySQL query statement below
select t.request_at Day,
round(count(t.status like 'cancelled_%' or null)/count(*),2) "Cancellation Rate"
from Trips t
inner join Users u
on t.client_id = u.users_id and u.banned='No'
where t.Request_at between '2013-10-01' and '2013-10-03'
group by t.Request_at

// s2
// 515 ms (67%) 

# Write your MySQL query statement below
SELECT request_at as Day, ROUND((SELECT COUNT(*) FROM trips WHERE (status LIKE 'cancelled_by%' AND request_at = Day) AND client_id NOT IN (SELECT users_id FROM Users WHERE banned = 'Yes' AND Role = 'client') AND client_id NOT IN (SELECT users_id FROM Users WHERE banned = 'Yes' AND Role = 'driver')) / COUNT(request_at),2) as "Cancellation Rate" FROM trips WHERE request_at BETWEEN CAST('2013-10-01' AS DATE) AND CAST('2013-10-03' AS DATE) AND (client_id NOT IN (SELECT DISTINCT users_id FROM Users WHERE banned = "Yes" AND role = "client" )
AND
driver_id NOT IN (SELECT DISTINCT users_id FROM Users WHERE banned = "Yes" AND role = "driver" )) GROUP BY request_at 
