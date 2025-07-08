/*
Esercizio: Creazione e Test di Trigger nel Database Sakila
1. Creare un trigger che impedisca l'inserimento di un nuovo film se il titolo è già presente nel database. Il
trigger deve controllare se esiste un film con lo stesso titolo e, in caso affermativo, annullare l'operazione.
*/

use sakila;

delimiter $

create trigger tgr_duplicate_film_title
before insert on film
for each row
begin
    
    if (select count(*) from film where title = new.title) > 0 then
        signal sqlstate '45000'
        set message_text = 'Errore: Esiste già questo film ';
    end if;
end;

$
delimiter ;
-- non esiste quindi lo ha inserito senza problemi
insert into film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating)
values ('star wars', 'chewbecca', 1977, 1, 5, 2.99, 120, 19.99, 'PG');

select * from film order by film_id desc;

-- mi da' errore perche' ho gia' inserito questo film in precedenza

insert into film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating)
values ('star wars', 'chewbecca', 1977, 1, 5, 2.99, 120, 19.99, 'PG');


/*
2.Creare un trigger che registri in una tabella di log ogni volta che un film viene modificato. Il log deve
includere l'ID del film, i dettagli prima della modifica, i dettagli dopo la modifica e la data e l'ora
dell'aggiornamento (scegliere i dettagli a piacimento, ad esempio descrizione, rating e titolo del film)
*/


drop trigger tgr_edit_film;

delimiter $

create trigger tgr_edit_film
after update on film
for each row
begin
    
    insert into log (type, description) 
    values ("INFO",concat("Modificato film: film con id:", new.film_id, " e' stato modificato il titolo da:", old.title, " al nuovo titolo:", new.title, " aggiornato in data:", now() ));
    
end;

$
delimiter ;

update film 
set title = 'il signore degli agnelli'
where film_id = 1004;

insert into film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating)
values ('il signore degli anelli', 'gondor', 2001, 1, 5, 2.99, 120, 19.99, 'PG');

select * from log order by id desc;