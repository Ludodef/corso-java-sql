use sakila;
with customer_tot as (
select c.customer_id
,concat(c.first_name, " " ,c.last_name) as customer_name
, count(r.rental_id) as tot_rentals
,sum(p.amount) as tot_spent
from customer c 
inner join rental r on c.customer_id = r.customer_id
inner join payment p on r.rental_id = p.rental_id
group by c.customer_id
),
tot_spent_all as (
select sum(tot_spent) as all_spent
from customer_tot
)
select 
ct.customer_id
,ct.customer_name
,ct.tot_spent
,ct.tot_rentals
,round((ct.tot_spent / ts.all_spent) * 100 , 2) as percentage_total
from customer_tot ct 
cross join tot_spent_all ts 
order by ct.tot_spent desc; 

