use sakila;
select 
    c.name as categoria,
    f.title as film,
    COUNT(r.rental_id) as totale_noleggi
from rental r
inner join inventory i on r.inventory_id = i.inventory_id
inner join film f on i.film_id = f.film_id
inner join film_category fc on f.film_id = fc.film_id
inner join category c on fc.category_id = c.category_id
group by c.name, f.title
order by c.name, totale_noleggi desc;