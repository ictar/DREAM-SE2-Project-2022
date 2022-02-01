DROP TRIGGER IF EXISTS `after_new_farmer`;
DELIMITER //
CREATE TRIGGER `after_new_farmer`
AFTER INSERT ON `farmer`
FOR EACH ROW
BEGIN
    DECLARE fid int;
    select farmid into fid from farm where farmer=new.phonenumber;

    IF (exists (select * from farm where farmer=new.phonenumber)) THEN
        insert into farmer_farm (farm, farmer)
        values (fid, new.farmerid);
    END IF;

END; 
//

DELIMITER ;