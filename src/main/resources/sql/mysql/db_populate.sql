USE db_rwr;

INSERT INTO SEEKER (id, first_name, last_name, date_of_addition, date_of_interview) VALUES
  (1, 'fnameOne', 'lnameOne', '2015-04-02', '2015-05-01'),
  (2, 'fnameTwo', 'lnameTwo', '2015-04-15', '2015-05-11'),
  (3, 'fnameThree', 'lnameThree', '2015-03-14', '2015-06-20'),
  (4, 'fnameFour', 'lnameFour', '2015-02-13', '2015-06-21'),
  (5, 'fnameFive', 'lnameFive', '2015-01-12', '2015-07-22'),
  (6, 'fnameSix', 'lnameSix', '2015-07-11', '2015-08-22'),
  (7, 'fnameSeven', 'lnameSeven', '2015-08-10', '2015-09-23'),
  (8, 'fnameEight', 'lnameEight', '2015-05-10', '2015-10-24'),
  (9, 'fnameNine', 'lnameNine', '2015-09-09', '2015-11-25'),
  (10, 'fnameTen', 'lnameTen', '2015-10-18', '2015-11-26');

INSERT INTO SEEKER_PHONE (phone_number, seeker_id) VALUES
  ('80000000001', 1),
  ('80000000002', 2),
  ('80000000003', 3),
  ('80000000004', 4),
  ('80000000005', 5),
  ('80000000006', 6),
  ('80000000007', 7),
  ('80000000008', 8),
  ('80000000009', 9),
  ('80000000010', 10);

INSERT INTO SEEKER_EMAIL (email, seeker_id) VALUES
  ('test1email@mail.com', 1),
  ('test2email@mail.com', 2),
  ('test3email@mail.com', 3),
  ('test4email@mail.com', 4),
  ('test5email@mail.com', 5),
  ('test6email@mail.com', 6),
  ('test7email@mail.com', 7),
  ('test8email@mail.com', 8),
  ('test9email@mail.com', 9),
  ('test10email@mail.com', 10);

INSERT INTO IMS_TYPE (id, type) VALUES
  (1, 'ICQ'),
  (2, 'AIM'),
  (3, 'MSN'),
  (4, 'JABBER');

INSERT INTO SEEKER_IMS (ims_type_id, ims_login, seeker_id) VALUES
  (1, 'login1', 1),
  (1, 'login2', 1),
  (2, 'login3', 2),
  (3, 'login4', 2),
  (4, 'login5', 3),
  (3, 'login6', 4),
  (4, 'login7', 5),
  (2, 'login8', 6),
  (1, 'login9', 7),
  (2, 'login10', 8);

INSERT INTO SKILL_TYPE (id, type) VALUES
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
  (2, 10, 3),
  (1, 2, 4),
  (3, 4, 4),
  (5, 5, 4),
  (4, 6, 5),
  (3, 6, 5),
  (2, 1, 6),
  (1, 8, 6),
  (2, 9, 7),
  (4, 3, 7),
  (2, 5, 8),
  (1, 7, 8),
  (3, 2, 8),
  (4, 9, 8),
  (2, 10, 9),
  (1, 4, 9),
  (2, 3, 10);

