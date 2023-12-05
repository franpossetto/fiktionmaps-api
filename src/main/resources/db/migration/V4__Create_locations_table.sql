CREATE TABLE IF NOT EXISTS public.locations
(
    id bigint NOT NULL,
    formatted_address character varying(255),
    post_code character varying(255),
    latitude double precision,
    longitude double precision,
    type character varying(255),
    name character varying(255),
    place_id character varying(255),
    provider character varying(255),
    city_id bigint,
    CONSTRAINT pk_locations PRIMARY KEY (id),
    CONSTRAINT uk_place_id UNIQUE (place_id),
    CONSTRAINT fk_location_city FOREIGN KEY (city_id)
        REFERENCES public.cities (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)