
drop procedure update_rental;


delimiter $

create procedure update_rental(
    IN p_rental_id INT,
    IN p_film_id INT
)
begin
    declare v_inventory_id INT;
    declare v_old_film_id INT;
    declare v_store_id INT;
    declare v_staff_id INT;
    declare v_rental_date DATETIME;
    declare v_new_inventory_id INT;

declare EXIT handler for SQLEXCEPTION
   begin
		rollback;        
		insert into log (type, description) values ("ERROR",concat("Errore durante il noleggio ", p_rental_id));
   end;
  
    start transaction;

  select r.inventory_id, i.film_id, i.store_id, r.staff_id
    into v_inventory_id, v_old_film_id, v_store_id, v_staff_id
    from rental r
    inner join inventory i on r.inventory_id = i.inventory_id
    where r.rental_id = p_rental_id;
    
   select inventory_id 
   into v_new_inventory_id
    from inventory
    where film_id = p_film_id and store_id = v_store_id
    limit 1;

   update rental
    set inventory_id = v_inventory_id
    where rental_id = p_rental_id;

    
    insert into log (type, description)
    values ('info', CONCAT('Aggiornato noleggio con id ', p_rental_id, ': film cambiato da ', v_old_film_id, ' a ', p_film_id, ' dallo staff ', v_staff_id));

    
    commit;

end $

delimiter ;

call update_rental(30, 15);
select * from log order by data_log desc;


