DROP TABLE movies CASCADE CONSTRAINTS ;

DROP TABLE genres CASCADE CONSTRAINTS;

DROP TABLE movie_g CASCADE CONSTRAINTS;

 CREATE TABLE movies (
  id INT PRIMARY KEY,
  title VARCHAR2 (50), 
  release_date DATE, movie_duration NUMBER(8,2) , score FLOAT(10) );
  
 CREATE TABLE genres (
 id INT NOT NULL PRIMARY KEY, 
 name VARCHAR2(30) );
 
 CREATE TABLE  movie_g (
  m_id INT PRIMARY KEY, 
  g_id INT ) ;
 


