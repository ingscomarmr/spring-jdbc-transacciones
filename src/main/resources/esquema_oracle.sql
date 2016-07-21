BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE persona';
   EXECUTE IMMEDIATE 'DROP TABLE personaSequence';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;

CREATE TABLE persona (
	id_persona INT,
	nombre VARCHAR2(50) NOT NULL,
	ape_paterno VARCHAR2(50) NOT NULL,
	ape_materno VARCHAR2(50),
	email VARCHAR2(50) NOT NULL,
  CONSTRAINT id_persona_pk PRIMARY KEY (id_persona)
);

CREATE SEQUENCE personaSequence
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

--SELECT * FROM persona;

--SELECT PERSONASEQUENCE.nextval FROM DUAL;

insert into persona (ID_PERSONA, NOMBRE, APE_PATERNO,APE_MATERNO, EMAIL) values (PERSONASEQUENCE.nextval, 'Admin', 'admin','admin', 'admin@icursos.net');
insert into persona (ID_PERSONA, NOMBRE, APE_PATERNO,APE_MATERNO, EMAIL) values (PERSONASEQUENCE.nextval, 'Juan', 'Perez','Rivera', 'juan.perez@gmail.com');
insert into persona (ID_PERSONA, NOMBRE, APE_PATERNO,APE_MATERNO, EMAIL) values (PERSONASEQUENCE.nextval, 'Juan', 'Romano','Rivera', 'juan.romano@gmail.com');