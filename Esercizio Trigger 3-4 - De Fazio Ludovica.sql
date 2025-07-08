/*
Esercizio: Creazione e Test di Trigger nel Database Sakila - Parte 2
*/

/*
3.Creare un trigger che impedisca la cancellazione di un record dalla tabella rental se il noleggio non è
stato ancora restituito (la colonna return_date è NULL).
*/
use sakila;
select * from rental where rental_id = 11496 ;

delimiter $

create trigger trg_no_return_date
before delete on rental
for each row
begin
 
    if old.return_date is null then
        signal sqlstate '45000'
        set message_text = "Attenzione!Non si puo' eliminare un noleggio non ancora restituito";
    end if;
end;

$
delimiter ;

-- questo noleggio non e' stato ancora restituito quindi non lo cancella
delete from rental where rental_id = 11496;

-- questo noleggio e' stato restituito quindi lo ha cancellato senza problemi
delete from rental where rental_id = 2;

/*
4.Implementare un trigger che, dopo l'inserimento di un nuovo noleggio, aggiorni un contatore nella
tabella film per tenere traccia del numero totale di volte in cui ciascun film è stato noleggiato.
(Va aggiunto un campo counter unsigned int, inizializzato a 10 oppure con query che conta i noleggi
effettivi)
*/

-- creazione colonna
alter table film add column rental_count int unsigned default 10;
select * from film;

-- creazione trigger
delimiter $

create trigger trg_rental_count
after insert on rental
for each row
begin
    
    update film 
    set rental_count = rental_count + 1
    where film_id = (select film_id from inventory where inventory_id = new.inventory_id);
end;

$

delimiter ;

insert into rental (rental_date, inventory_id, customer_id, return_date, staff_id)
values (now(), 1, 5, null, 1);

select film_id, rental_count from film
 where film_id = 
    (select film_id from inventory where inventory_id = 1);