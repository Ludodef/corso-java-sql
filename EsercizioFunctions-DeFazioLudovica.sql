-- Funzione 1

drop function film_availability;
 
delimiter $ 
create function film_availability(p_film_id int)
returns varchar(100)   
reads sql data 
begin
declare availability varchar(100);
	 if (select count(*) 
     from inventory where film_id = p_film_id) > 0 then
        set availability = 'Disponibile';
    else
        set availability = 'Non disponibile';
    end if;
    
    return availability;
end;
$
delimiter ;

select *, film_availability(film_id) as availability from film;

-- Funzione 2

drop function customer_rental_count;
 
delimiter $ 
create function customer_rental_count(p_customer_id int)
returns int   
reads sql data 
begin
declare rental_count int;
select count(*) into rental_count
from rental r
where r.customer_id = p_customer_id;
return rental_count;
end;
$
delimiter ;

select *, customer_rental_count(customer_id) as rentals from rental;

-- Funzione 3
drop function average_rental_time;
 
delimiter $ 
create function average_rental_time(p_film_id int)
returns decimal(10,2)  
reads sql data 
begin
declare rental_time decimal(10,2);
select avg(datediff(return_date,rental_date)) into rental_time
from rental r
inner join inventory i on r.inventory_id = i.inventory_id
where i.film_id = p_film_id
and return_date is not null;

return rental_time;
end;
$
delimiter ;

select *, customer_rental_count(rental_id) as days from rental;


-- Funzione 4

drop function average_customer_profit; 
 
delimiter $
create function average_customer_profit (p_customer_id int)
returns decimal(10,2) 
reads sql data
begin
   declare tot decimal(10,2);

   
   select avg(amount) into tot 
   from payment p where p.customer_id= p_customer_id;
   if tot is null then
	  set tot=0;
   end if;
   
   
    
   return tot;
end;
$
delimiter ;

select *, average_customer_profit(customer_id) as tot from payment;
