# --- !Ups

CREATE TABLE IF NOT EXISTS test_table (
	Active_Inactive ENUM( 'ACTIVE', 'INACTIVE', 'ON HOLD') NOT NULL,
    ABC_ID CHAR(7) NOT NULL,
    Name VARCHAR(100) NOT NULL,
    Replacement_ABC_ID VARCHAR(20) DEFAULT NULL,
    Allocation VARCHAR(30) NOT NULL,
    Portfolio VARCHAR(50) DEFAULT NULL,
    Sub_Portfolio VARCHAR(50) DEFAULT NULL,
    Type VARCHAR(30) NOT NULL,
    Funding_Source VARCHAR(20) NOT NULL,
    Master_List_Date CHAR(10) NOT NULL DEFAULT '',
    ABC_Start_Date CHAR(10) NOT NULL DEFAULT '',
    KPIT_Support_Org VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY(ABC_ID, Name));

# --- !Downs

drop table if exists test_table;