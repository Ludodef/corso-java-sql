create table log (
  id int not null auto_increment,
  type varchar(45) not null, -- info, debug, error
  description text not null,
  data_log timestamp default current_timestamp,
  primary key(id)
); 


SELECT 
    *
FROM
    log;
    

