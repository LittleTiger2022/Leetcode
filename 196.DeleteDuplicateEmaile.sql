delete p1 from Person p1, Person p2
where 
p1.Email = p2.Email AND p1.id> p2.id;

