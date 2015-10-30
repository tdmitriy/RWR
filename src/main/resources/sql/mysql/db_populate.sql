USE db_rwr;

INSERT INTO SEEKER (id, first_name, last_name, date_of_addition, date_of_interview) VALUES
  (1, 'fname1', 'lname1', '2015-04-02', '2015-05-01'),
  (2, 'fname2', 'lname2', '2015-04-15', '2015-05-11'),
  (3, 'fname3', 'lname3', '2015-03-10', '2015-06-21');

INSERT INTO SEEKER_PHONE (phone_number, seeker_id) VALUES
  ('80611122222', 1),
  ('80611133333', 1),
  ('80611111111', 2),
  ('80611115555', 3);

INSERT INTO SEEKER_EMAIL (email, seeker_id) VALUES
  ('test1email@gmail.com', 1),
  ('test2email@gmail.com', 2),
  ('test3email@gmail.com', 2),
  ('test4email@gmail.com', 3);

INSERT INTO IMS_TYPE (id, type) VALUES
  (1, 'ICQ'),
  (2, 'AIM'),
  (3, 'MSN'),
  (4, 'JABBER');

INSERT INTO SEEKER_IMS (ims_type_id, ims_login, seeker_id) VALUES
  (1, 'ICQ_LOGIN1', 1),
  (1, 'ICQ_LOGIN2', 1),
  (2, 'AIM_LOGIN1', 1),
  (3, 'MSN_LOGIN1', 2),
  (4, 'JABBER_LOGIN1', 2);

INSERT INTO SKILLS_TYPE (id, type) VALUES
  (1, 'Java'),
  (2, 'C++'),
  (3, 'C'),
  (4, 'Assembler'),
  (5, 'SQL');

INSERT INTO SEEKER_SKILLS (skill_type_id, skill_rating, seeker_id) VALUES
  (1, 10, 1),
  (2, 5, 1),
  (3, 7, 1),
  (4, 6, 2),
  (5, 4, 3),
  (2, 8, 3);

