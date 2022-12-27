-- psql -U francisco -d mapToFiction -a -f seed.sql
INSERT INTO fictions (id, name, type) VALUES ('home-alone2','Home Alone', 'MOVIE');
INSERT INTO locations (id, address, latitude, longitude) VALUES ('ny-2','45 Rockefeller Plaza', 40.75893522036733, -73.97861995812193);
INSERT INTO scenes (id, description, fiction_id, location_id) VALUES (1,'Last Scene', 'home-alone2', 'ny-2');
