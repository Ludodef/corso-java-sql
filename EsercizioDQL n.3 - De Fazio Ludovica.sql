use sakila;
drop view customer_rental_count;
create view customer_rental_count as 
select r.customer_id, count(r.rental_id) as total_rentals
from rental r 
group by r.customer_id;

select c.customer_id, c.first_name, c.last_name, cr.total_rentals 
from customer c
inner join customer_rental_count cr on c.customer_id = cr.customer_id
where cr.total_rentals > 30 
order by cr.total_rentals 