PRAGMA foreign_keys=ON;
BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS employee(Employee_id integer primary key not null, FirstName text not null, LastName text not null, Gender text not null, Driving_license_ID integer not null, Status_ID integer not null, Schedule_ID integer);
INSERT INTO "employee" (FirstName, LastName, Gender, Driving_license_ID, Status_ID, Schedule_ID) VALUES("Jonas","Lindberg", "Male", 1, 1, 1);

CREATE TABLE IF NOT EXISTS employee_status(Status_ID integer primary key not null, Status text not null);
INSERT INTO "employee_status"(Status) VALUES ('100%');
INSERT INTO "employee_status"(Status) VALUES ('50%');
INSERT INTO "employee_status"(Status) VALUES ('Sjuk');
INSERT INTO "employee_status"(Status) VALUES ('VAB');
INSERT INTO "employee_status"(Status) VALUES ('Studier');
INSERT INTO "employee_status"(Status) VALUES ('Semester');

CREATE TABLE IF NOT EXISTS schedule(Schedule_ID integer primary key not null, Schedule text not null unique);
INSERT INTO "schedule" (Schedule) VALUES('MF');
INSERT INTO "schedule" (Schedule) VALUES('LS');
INSERT INTO "schedule" (Schedule) VALUES('S');

CREATE TABLE IF NOT EXISTS ship(Ship_id integer primary key not null, Ship_name text, Company text, Volume_type text);
INSERT INTO "ship" (Ship_name, Company, Volume_type) VALUES("Ocean","Trade","A005");

CREATE TABLE IF NOT EXISTS truck(Truck_id integer primary key not null,
Truck_type text check(Truck_type in('A001','AA01','B001','BB01','C001','CC01','CCC1','K001')),
Truck_status text check(Truck_status in('Ok','Reparation','Reserv','Skada')), Truck_cost integer check(Truck_cost in(1000, 1500, 2000, 2500, 3000, 3500, 4000, 6000)));
INSERT INTO "truck" VALUES(1,"A001","Ok",1000);
INSERT INTO "truck" VALUES(2,"AA01","Reparation",1500);
INSERT INTO "truck" VALUES(3,"B001","Reserv",2000);
INSERT INTO "truck" VALUES(4,"BB01","Skada",2500);
INSERT INTO "truck" VALUES(5,"C001","Ok",3000);
INSERT INTO "truck" VALUES(6,"CC01","Reserv",3500);
INSERT INTO "truck" VALUES(7,"CCC1","Reparation",4000);
INSERT INTO "truck" VALUES(8,"K001","Ok",6000);
CREATE TABLE IF NOT EXISTS employee_salary(Driving_license_ID integer primary key not null, Hourly_salary integer);
INSERT INTO "employee_salary" (Driving_license_ID, Hourly_salary) VALUES(1, 500);
INSERT INTO "employee_salary" (Driving_license_ID, Hourly_salary) VALUES(2, 700);
INSERT INTO "employee_salary" (Driving_license_ID, Hourly_salary) VALUES(3, 900);
INSERT INTO "employee_salary" (Driving_license_ID, Hourly_salary) VALUES(4, 1000);
INSERT INTO "employee_salary" (Driving_license_ID, Hourly_salary) VALUES(5, 1250);
INSERT INTO "employee_salary" (Driving_license_ID, Hourly_salary) VALUES(6, 1500);
INSERT INTO "employee_salary" (Driving_license_ID, Hourly_salary) VALUES(7, 3000);
INSERT INTO "employee_salary" (Driving_license_ID, Hourly_salary) VALUES(8, 4000);

CREATE TABLE IF NOT EXISTS driving_licenses(Driving_license_ID integer primary key not null,
Driving_license_type text unique not null check(Driving_license_type in('A','AA','B','BB','C','CC','CCC','K')));
INSERT INTO "driving_licenses" (Driving_license_ID, Driving_license_type) VALUES(1, "A");
INSERT INTO "driving_licenses" (Driving_license_ID, Driving_license_type) VALUES(2, "AA");
INSERT INTO "driving_licenses" (Driving_license_ID, Driving_license_type) VALUES(3, "B");
INSERT INTO "driving_licenses" (Driving_license_ID, Driving_license_type) VALUES(4, "BB");
INSERT INTO "driving_licenses" (Driving_license_ID, Driving_license_type) VALUES(5, "C");
INSERT INTO "driving_licenses" (Driving_license_ID, Driving_license_type) VALUES(6, "CC");
INSERT INTO "driving_licenses" (Driving_license_ID, Driving_license_type) VALUES(7, "CCC");
INSERT INTO "driving_licenses" (Driving_license_ID, Driving_license_type) VALUES(8, "K");

CREATE TABLE IF NOT EXISTS admin(Admin_ID integer primary key not null, username text unique, password text unique check(password not like username));
INSERT INTO "admin" (Admin_ID, username, password) VALUES(1, "mohammed", "abc");
COMMIT;
