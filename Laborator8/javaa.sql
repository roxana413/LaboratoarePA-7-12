DROP TABLE moviess CASCADE CONSTRAINTS ;

DROP TABLE genres CASCADE CONSTRAINTS;

DROP TABLE movie_g CASCADE CONSTRAINTS;

 CREATE TABLE moviess (
  id INT  PRIMARY KEY,
  title VARCHAR2 (50), 
  release_date DATE, movie_duration NUMBER(8,2) , score FLOAT(10) );
  
 CREATE TABLE genress (
 id INT NOT NULL PRIMARY KEY, 
 name VARCHAR2(30) );
 
 CREATE TABLE  movie_g (
  m_id INT PRIMARY KEY, 
  g_id INT ) ;
  
DROP TABLE persons CASCADE CONSTRAINTS;
CREATE TABLE persons(
  id INT PRIMARY KEY ,
  name VARCHAR2(256) NOT NULL
);

DROP TABLE movie_actors CASCADE CONSTRAINTS;
CREATE TABLE movie_actors(
  movie_id INT ,
  actor_id INT NOT NULL ,
  CONSTRAINT fk2_movie_id FOREIGN KEY(movie_id) REFERENCES moviess(id),
  CONSTRAINT fk_actor_id FOREIGN KEY(actor_id) REFERENCES persons(id)
)



CREATE TABLE movie_directors(
  movie_id INT ,
  director_id INT NOT NULL  ,
  CONSTRAINT fk_movie_id FOREIGN KEY(movie_id) REFERENCES moviess(id),
  CONSTRAINT fk_director_id FOREIGN KEY(director_id) REFERENCES persons(id)
)


 


