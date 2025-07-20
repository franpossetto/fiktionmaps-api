-- seed.sql
-- Users
INSERT INTO app_user (id, name, email, external_user_id, role, country, email_verified)
SELECT 1049, 'Garnero Nicolás', 'ngarnero.ng@gmail.com', 'hLRAnmZCvTN5GF8STwaxdfAhgCJ2', 'USER', 'Argentina', false
WHERE NOT EXISTS (
    SELECT 1 FROM app_user WHERE id = 1049
);

-- Cities
INSERT INTO cities (id, name, code, latitude, longitude, place_id, provider)
SELECT 11, 'Stockholm', 'STC', 59.32795169434546, 18.068985613039242, 'ChIJywtkGTF2X0YRZnedZ9MnDag', 'GOOGLE_MAPS'
WHERE NOT EXISTS (
    SELECT 1 FROM cities WHERE name = 'Stockholm'
);

INSERT INTO cities (id, name, code, latitude, longitude, place_id, provider)
SELECT 27, 'Rovinj', 'RVJ', 45.07730437354874, 13.644421352972996, 'ChIJ_4ZcTWO_fEcRU66YxWGfxv8', 'GOOGLE_MAPS'
WHERE NOT EXISTS (
    SELECT 1 FROM cities WHERE name = 'Rovinj'
);

INSERT INTO cities (id, name, code, latitude, longitude, place_id, provider)
SELECT 28, 'Washington', 'WDC', 38.90020908108166, -77.03770446157098, 'ChIJW-T2Wt7Gt4kRKl2I1CJFUsI', 'GOOGLE_MAPS'
WHERE NOT EXISTS (
    SELECT 1 FROM cities WHERE name = 'Washington'
);

--Fictions
INSERT INTO fictions (id, name, type, provider, external_id, year, duration, img_url, created_by, published)
SELECT 336, 'The Playlist', 'EPISODE', NULL, 'tt14856356', 2022, 45, 's_the_playlist.jpg', 1049, true
WHERE NOT EXISTS (
    SELECT 1 FROM fictions WHERE name = 'The Playlist'
);

-- Locations for The Playlist
INSERT INTO locations (id, formatted_address, post_code, latitude, longitude, type, name, place_id, provider, city_id)
SELECT 1026, 'Kungsgatan 35, 111 56 Stockholm, Sweden', NULL, 59.3356807, 18.0651104, NULL, NULL, 'EidLdW5nc2dhdGFuIDM1LCAxMTEgNTYgU3RvY2tob2xtLCBTd2VkZW4iMBIuChQKEgnJ6UWdXZ1fRhHzSkDQcHtApxAjKhQKEgl9DMVKZ51fRhHKjGVFAlHfzg', NULL, 11
WHERE NOT EXISTS (
    SELECT 1 FROM locations WHERE id = 1026
);

INSERT INTO locations (id, formatted_address, post_code, latitude, longitude, type, name, place_id, provider, city_id)
SELECT 1033, 'Skaraborgsgatan 14, 118 46 Stockholm, Sweden', NULL, 59.317316, 18.069775, NULL, NULL, 'EixTa2FyYWJvcmdzZ2F0YW4gMTQsIDExOCA0NiBTdG9ja2hvbG0sIFN3ZWRlbiIwEi4KFAoSCb1Hairld19GEdvuLPnd37AvEA4qFAoSCTVq_9Xkd19GEStdo_ofo0lM', NULL, 11
WHERE NOT EXISTS (
    SELECT 1 FROM locations WHERE id = 1033
);

INSERT INTO locations (id, formatted_address, post_code, latitude, longitude, type, name, place_id, provider, city_id)
SELECT 1034, 'Rågsvedsvägen, 124 65 Bandhagen, Sweden', NULL, 59.25657689999999, 18.0236126, NULL, NULL, 'EilSw6Vnc3ZlZHN2w6RnZW4sIDEyNCA2NSBCYW5kaGFnZW4sIFN3ZWRlbiIuKiwKFAoSCcdMzUtdd19GERbGzBxajaV0EhQKEgmD-EjyQndfRhGiMAgX8_4AEw', NULL, 11
WHERE NOT EXISTS (
    SELECT 1 FROM locations WHERE id = 1034
);

INSERT INTO locations (id, formatted_address, post_code, latitude, longitude, type, name, place_id, provider, city_id)
SELECT 1035, 'Smedsuddsvägen 23, 112 35 Stockholm, Sweden', NULL, 59.32548399999999, 18.023403, NULL, NULL, 'EixTbWVkc3VkZHN2w6RnZW4gMjMsIDExMiAzNSBTdG9ja2hvbG0sIFN3ZWRlbiIwEi4KFAoSCR8-fOnTd19GESgWgCYz-V78EBcqFAoSCZeZ7QPUd19GEQwQgN-ttFlL', NULL, 11
WHERE NOT EXISTS (
    SELECT 1 FROM locations WHERE id = 1035
);

INSERT INTO locations (id, formatted_address, post_code, latitude, longitude, type, name, place_id, provider, city_id)
SELECT 1036, 'Södra Riddarholmshamnen 15, 111 28 Stockholm, Sweden', NULL, 59.3240434, 18.0635861, NULL, NULL, 'EjVTw7ZkcmEgUmlkZGFyaG9sbXNoYW1uZW4gMTUsIDExMSAyOCBTdG9ja2hvbG0sIFN3ZWRlbiIwEi4KFAoSCdkWrnfhd19GEeBBpQAm9Uc1EA8qFAoSCUuD8p3hd19GEestuFdM839z', NULL, 11
WHERE NOT EXISTS (
    SELECT 1 FROM locations WHERE id = 1036
);

INSERT INTO locations (id, formatted_address, post_code, latitude, longitude, type, name, place_id, provider, city_id)
SELECT 1037, 'Birger Jarls Torg 2, 111 28 Stockholm, Sweden', NULL, 59.32502460000001, 18.0648539, NULL, NULL, 'Ei1CaXJnZXIgSmFybHMgVG9yZyAyLCAxMTEgMjggU3RvY2tob2xtLCBTd2VkZW4iMBIuChQKEgnv5MWI4XdfRhE36LMhHyYruhACKhQKEgk1owKa4XdfRhEoilpBL_lewg', NULL, 11
WHERE NOT EXISTS (
    SELECT 1 FROM locations WHERE id = 1037
);

INSERT INTO locations (id, formatted_address, post_code, latitude, longitude, type, name, place_id, provider, city_id)
SELECT 1038, '190 60 Stockholm-Arlanda, Sweden', NULL, 59.6493928, 17.9342942, NULL, NULL, 'ChIJpQRBrma-X0YRXz0AvbpG2CI', NULL, 11
WHERE NOT EXISTS (
    SELECT 1 FROM locations WHERE id = 1038
);

INSERT INTO locations (id, formatted_address, post_code, latitude, longitude, type, name, place_id, provider, city_id)
SELECT 1039, 'Sergelarkaden, 111 57 Stockholm, Sweden', NULL, 59.3325834, 18.0638687, NULL, NULL, 'EidTZXJnZWxhcmthZGVuLCAxMTEgNTcgU3RvY2tob2xtLCBTd2VkZW4iLiosChQKEgln2GhxXp1fRhGPhIpEpvr2EhIUChIJgSUHnF2dX0YR4xw-F_P-AAs', NULL, 11
WHERE NOT EXISTS (
    SELECT 1 FROM locations WHERE id = 1039
);

INSERT INTO locations (id, formatted_address, post_code, latitude, longitude, type, name, place_id, provider, city_id)
SELECT 1058, 'Smareglijeva ul. 1A, 52210, Rovinj, Croatia', NULL, 45.07574339999999, 13.6370721, NULL, NULL, 'ChIJ_bDLpZrAfEcR5J0j0SWkjF0', NULL, 27
WHERE NOT EXISTS (
    SELECT 1 FROM locations WHERE id = 1058
);

INSERT INTO locations (id, formatted_address, post_code, latitude, longitude, type, name, place_id, provider, city_id)
SELECT 1059, '2 15th St NW, Washington, DC 20004, USA', NULL, 38.88948389999999, -77.0352791, NULL, NULL, 'ChIJx-D7vaG3t4kRYdeRQ9buNiw', NULL, 28
WHERE NOT EXISTS (
    SELECT 1 FROM locations WHERE id = 1059
);

-- Places for The Playlist
INSERT INTO places (id, name, description, screenshot, location_id, fiction_id, created_by, published)
SELECT 1038, 'Ragsved Train Station', 'Ragsved Train Station', 'fiction_places/336/1713365567757_ragsved_train_station_scene.JPG', 1034, 336, 1049, true
WHERE NOT EXISTS (
    SELECT 1 FROM places WHERE id = 1038
);

INSERT INTO places (id, name, description, screenshot, location_id, fiction_id, created_by, published)
SELECT 1064, 'Washington Monument', 'Washington Monument', 'fiction_places/336/1713489960999_daniel_and_bobi_t_talking_scene.JPG', 1059, 336, 1049, true
WHERE NOT EXISTS (
    SELECT 1 FROM places WHERE id = 1064
);

INSERT INTO places (id, name, description, screenshot, location_id, fiction_id, created_by, published)
SELECT 1043, 'Arlanda Train Station', 'Arlanda Train Station', 'fiction_places/336/1713444428378_andreas_and_his_grilfriend_at_trainstation_scene.JPG', 1038, 336, 1049, true
WHERE NOT EXISTS (
    SELECT 1 FROM places WHERE id = 1043
);

INSERT INTO places (id, name, description, screenshot, location_id, fiction_id, created_by, published)
SELECT 1063, 'Grand Park Hotel', 'Grand Park Hotel', 'fiction_places/336/1713488457727_martin_speech_at_wedding_scene.JPG', 1058, 336, 1049, true
WHERE NOT EXISTS (
    SELECT 1 FROM places WHERE id = 1063
);

INSERT INTO places (id, name, description, screenshot, location_id, fiction_id, created_by, published)
SELECT 1042, 'Birger Jarls Torg', 'Birger Jarls Torg', 'fiction_places/336/1713367597499_pirate''s_bay_founder_speech_scene.JPG', 1037, 336, 1049, true
WHERE NOT EXISTS (
    SELECT 1 FROM places WHERE id = 1042
);

INSERT INTO places (id, name, description, screenshot, location_id, fiction_id, created_by, published)
SELECT 1044, 'kristall vertical accent', 'kristall vertical accent', 'fiction_places/336/1713444541913_daniel_going_to_his_office_scene.JPG', 1039, 336, 1049, true
WHERE NOT EXISTS (
    SELECT 1 FROM places WHERE id = 1044
);

INSERT INTO places (id, name, description, screenshot, location_id, fiction_id, created_by, published)
SELECT 1037, 'Sodra Latin School', 'Sodra Latin School', 'fiction_places/336/1713365320575_spotify''s_staff_at_school_scene.JPG', 1033, 336, 1049, true
WHERE NOT EXISTS (
    SELECT 1 FROM places WHERE id = 1037
);

INSERT INTO places (id, name, description, screenshot, location_id, fiction_id, created_by, published)
SELECT 1040, 'Västerbron Bridge', 'Västerbron Bridge', 'fiction_places/336/1713367510021_peter_sundin_travelling_to_the_court_scene.JPG', 1035, 336, 1049, true
WHERE NOT EXISTS (
    SELECT 1 FROM places WHERE id = 1040
);

INSERT INTO places (id, name, description, screenshot, location_id, fiction_id, created_by, published)
SELECT 1039, 'Malmskillnadstrappan', 'Malmskillnadstrappan', 'fiction_places/336/1713367440334_daniel_walking_up_stairs_scene.JPG', 1026, 336, 1049, true
WHERE NOT EXISTS (
    SELECT 1 FROM places WHERE id = 1039
);

INSERT INTO places (id, name, description, screenshot, location_id, fiction_id, created_by, published)
SELECT 1041, 'Riddarholmen', 'Riddarholmen', 'fiction_places/336/1713367547144_per_sundin_talking_with_ponten_scene.JPG', 1036, 336, 1049, true
WHERE NOT EXISTS (
    SELECT 1 FROM places WHERE id = 1041
);

-- Additional Fictions for interests testing
INSERT INTO fictions (id, name, type, provider, external_id, year, duration, img_url, created_by, published)
SELECT 337, 'Stranger Things', 'EPISODE', NULL, 'tt4574334', 2016, 50, 's_stranger_things.jpg', 1049, true
WHERE NOT EXISTS (
    SELECT 1 FROM fictions WHERE id = 337
);

INSERT INTO fictions (id, name, type, provider, external_id, year, duration, img_url, created_by, published)
SELECT 338, 'Breaking Bad', 'EPISODE', NULL, 'tt0903747', 2008, 47, 's_breaking_bad.jpg', 1049, true
WHERE NOT EXISTS (
    SELECT 1 FROM fictions WHERE id = 338
);

INSERT INTO fictions (id, name, type, provider, external_id, year, duration, img_url, created_by, published)
SELECT 339, 'The Crown', 'EPISODE', NULL, 'tt4786824', 2016, 58, 's_the_crown.jpg', 1049, true
WHERE NOT EXISTS (
    SELECT 1 FROM fictions WHERE id = 339
);

-- Interests for existing user (Garnero Nicolás - 1049)
INSERT INTO interests (id, user_id, fiction_id, created_at)
SELECT 1001, 1049, 337, CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM interests WHERE user_id = 1049 AND fiction_id = 337
);

INSERT INTO interests (id, user_id, fiction_id, created_at)
SELECT 1002, 1049, 338, CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM interests WHERE user_id = 1049 AND fiction_id = 338
);

INSERT INTO interests (id, user_id, fiction_id, created_at)
SELECT 1003, 1049, 339, CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM interests WHERE user_id = 1049 AND fiction_id = 339
);