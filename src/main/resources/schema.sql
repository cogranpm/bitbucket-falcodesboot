CREATE TABLE MODEL (MODELID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), NAME VARCHAR(30) NOT NULL, PRIMARY KEY(MODELID));
CREATE TABLE RELATION (RELATIONID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), MODELID BIGINT NOT NULL, NAME VARCHAR(30) NOT NULL, PRIMARY KEY(RELATIONID));
CREATE TABLE ATTRIBUTE (ATTRIBUTEID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), NAME VARCHAR(30) NOT NULL, PRIMARY KEY(ATTRIBUTEID));
