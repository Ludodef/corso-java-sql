use sakila;
alter table customer add column store_credit int;

-- Creazione colonne

alter table rental add column late_fee int;

select late_fee from rental;

-- Funzioni

-- 1
drop function penalty_fee;
delimiter $
create function penalty_fee(p_rental_id int)
returns int 
reads sql data 
begin 
declare days int;

	select f.rental_duration - datediff(r.return_date,r.rental_date) into days
	from rental r 
	inner join inventory i on i.inventory_id = r.inventory_id
	inner join film f on f.film_id = i.film_id
	where r.rental_id = p_rental_id and r.return_date is not null;
    
    if days < 0 then
	return days * (-2);
    else
    return 0;
    end if;
    
end;
$
delimiter ;

-- 2
drop function average_customer_profit; 
 
delimiter $
create function average_customer_profit (p_customer_id int)
returns decimal(10,2) 
reads sql data
begin
   declare tot decimal(10,2);

   select sum(amount) into tot 
   from payment p where p.customer_id= p_customer_id;
   if tot is null then
	  set tot=0;
   end if;
   
   return tot;
end;
$
delimiter ;

-- 3
delimiter $
create function customer_film_rent(p_customer_id int)
returns int
reads sql data
begin 
declare tot_rent int;
	select count(r.rental_id) into tot_rent
	from rental r
	where r.customer_id = p_customer_id and r.return_date is null;
    return tot_rent;
end ;
$
delimiter ;

-- 4
delimiter $
create function customer_credit_rental(p_customer_id int, p_import int)
returns int
reads sql data
begin
	declare has_credit int;
	select store_credit into has_credit
	from customer
    where customer_id = p_customer_id;

	if has_credit < p_import
    then return 0;
    else 
    return 1;
    end if;
end;
$
delimiter ;



-- Stored procedure

delimiter $
create procedure movie_rent(in p_customer_id smallint ,
							in p_film_id smallint,
                            in p_rental_date datetime)
begin 
declare late_fee int;
declare active_rent int;
declare has_credit int;
declare inventory int;

declare exit handler for sqlexception, sqlwarning
   begin
		get diagnostics condition 1  -- recupera le info dell'ultimo messaggio di errore
			@message = message_text,
            @sql_state = returned_sqlstate,
            @err_code = mysql_errno; 
		rollback;
		insert into log (type, description) 
			 values ("ERROR",concat(@sql_state," - Error Code: ",@err_code,": ",@message));
    end;
    
    select sum(penalty_fee(rental_id)) into late_fee
		from rental
		where customer_id = p_customer_id;
        
        select customer_film_rent(customer_id) into active_rent
        from rental
        where customer_id = p_customer_id;

		select customer_credit_rental(customer_id) into has_credit
        from customer_id
        where customer_id = p_customer_id;
    
    start transaction;
		insert into rental
        values (now() ,inventory, p_customer_id , null , staff_id, now()) 
        
        update rental 
        set rental_date = p_rental_date
        set customer_id = p_customer_id;
        where p_rental_date = rental_date;
		
        
       commit;
 


end;
$
delimiter ;
