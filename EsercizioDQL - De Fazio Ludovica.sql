-- Esercizio 1
use sakila;

select * 
  from film
 where (rental_rate > 2.99 and length < 60);
 
 -- Esercizio 2
 select * 
 from actor 
 order by last_name 
 limit 10;
 
-- Esercizio 3
select f.rating,
count(r.rental_id) as rental_count
from rental r 
inner join inventory i on r.inventory_id = i.inventory_id
inner join film f on i.film_id= f.film_id
group by f.rating 
order by rental_count;

-- Esercizio 4

select f.rating,
count(r.rental_id) as rental_count,
avg (datediff(r.return_date, r.rental_date)) as durata
from rental r 
inner join inventory i on r.inventory_id = i.inventory_id
inner join film f on i.film_id= f.film_id
group by f.rating 
order by rental_count;

-- Esercizio 5 
select fc.category_id,
count(f.film_id) as total_films
from film f
inner join film_category fc on f.film_id = fc.film_id 
where f.rental_rate = 0.99 
group by fc.category_id;


