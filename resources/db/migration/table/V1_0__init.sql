--##
--##     Flyway Migration File
--##         src/main/resources/db/migration/V1__AddPetsTable.sql
--##
--## Create pets table
--##
CREATE TABLE users
(
id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
name STRING,
type STRING,
indoor BOOLEAN DEFAULT TRUE
);