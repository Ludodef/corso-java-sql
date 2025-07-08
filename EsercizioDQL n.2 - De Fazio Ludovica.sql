use sakila;
select distinct c.customer_id, c.first_name, c.last_name
from customer c 
inner join rental r on c.customer_id = r.customer_id
inner join inventory i on r.inventory_id = i.inventory_id
inner join film f on i.film_id = f.film_id
inner join film_category fc on f.film_id = fc.film_id
inner join category cat on fc.category_id = cat.category_id
where cat.name in ('Action','Comedy')
order by c.last_name, c.first_name
