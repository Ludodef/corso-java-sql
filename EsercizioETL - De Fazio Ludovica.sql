-- Esercizio ETL

-- Esercizio 1
use sakila;
create temporary table rental_category_summary (
	category_id int
    ,category_name varchar(50)
    ,total_rentals int
);
insert into rental_category_summary (category_name ,total_rentals) 
-- with rental_counts as(
select c.name as category_name,
	count(r.rental_id) as total_rental 
    from rental r 
    inner join inventory i on r.inventory_id = i.inventory_id
    inner join film f on i.film_id = f.film_id
    inner join film_category fc on f.film_id = fc.film_id
    inner join category c on c.category_id = fc.category_id
    group by c.name;
    -- )
 
   


select  
    *
from
    rental_category_summary;


drop table report;

CREATE TABLE report (
	report_id int,
    category_name VARCHAR(100),
    total_rentals INT,
    avg_rent_customer DECIMAL(10 , 5 )
);
    


-- Esercizio 3 

insert into report(category_name 
					, total_rentals
					, avg_rent_customer) 
with rental_data as (
select 
r.customer_id
,c.name as category_name 
,count(r.rental_id) as total_rentals
,avg(datediff(r.return_date, r.rental_date)) as avg_rent_customer
from rental r 
inner join inventory i on r.inventory_id = i.inventory_id
inner join film f on i.film_id = f.film_id
inner join film_category fc on f.film_id = fc.film_id
inner join category c on c.category_id = fc.category_id
group by c.category_id, r.customer_id
)
select 
r.category_name,
    sum(r.total_rentals) as total_rentals,  
    avg(r.avg_rent_customer) as avg_rent_customer  
from rental_data r
inner join rental_category_summary rcs on r.category_name = rcs.category_name
group by r.category_name;


select 
    *
from
    report
