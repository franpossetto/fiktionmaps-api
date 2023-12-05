CREATE TABLE IF NOT EXISTS public.places (
    id bigint PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    location_id INT,
    fiction_id INT,
    created_by INT,
    CONSTRAINT fk_place_location FOREIGN KEY (location_id)
        REFERENCES public.locations (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_place_fiction FOREIGN KEY (fiction_id)
        REFERENCES public.fictions (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_place_user FOREIGN KEY (created_by)
        REFERENCES public.app_user (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
