CREATE TABLE IF NOT EXISTS public.cities
(
    id bigint NOT NULL,
    code character varying(255),
    latitude double precision,
    longitude double precision,
    name character varying(255),
    place_id character varying(255),
    provider character varying(255),
    CONSTRAINT pk_cities PRIMARY KEY (id)
);

CREATE SEQUENCE cities_id_sequence INCREMENT BY 1 START WITH 1000;
ALTER TABLE public.cities ALTER COLUMN id SET DEFAULT nextval('cities_id_sequence');