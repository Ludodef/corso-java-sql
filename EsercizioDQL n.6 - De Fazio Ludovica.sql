use sakila;
with rental_category as (
select c.name as category_name
, count(r.rental_id) as total_rentals
from rental r 
inner join inventory i on r.inventory_id = i.inventory_id
inner join film f on i.film_id = f.film_id
inner join film_category fc on f.film_id = fc.film_id
inner join category c on fc.category_id = c.category_id
group by c.category_id
),

min_rentals as (
select min(total_rentals) as min_rentals 
from rental_category

)
select rc.category_name
,rc.total_rentals
from rental_category rc 
inner join min_rentals mr on rc.total_rentals = mr.min_rentals
order by rc.total_rentals;