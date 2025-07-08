use sakila;
with rental_category as (
select s.store_id
,c.name as category_name
, count(r.rental_id) as total_rentals
from rental r 
inner join inventory i on r.inventory_id = i.inventory_id
inner join film f on i.film_id = f.film_id
inner join film_category fc on f.film_id = fc.film_id
inner join category c on fc.category_id = c.category_id
inner join staff st on r.staff_id = st.staff_id
inner join store s on st.store_id = s.store_id
 group by s.store_id, c.category_id
),

max_rentals as (
select store_id 
, max(total_rentals) as max_rentals 
from rental_category
group by store_id
)
select rc.store_id
, rc.category_name
,rc.total_rentals
from rental_category rc 
inner join max_rentals mr on rc.store_id = mr.store_id and rc.total_rentals = mr.max_rentals
order by rc.store_id;
